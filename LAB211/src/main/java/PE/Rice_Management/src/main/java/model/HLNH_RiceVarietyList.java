package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class HLNH_RiceVarietyList {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    static {
        DATE_FORMAT.setLenient(false);
    }

    private ArrayList<HLNH_RiceVariety> riceVarietyList = new ArrayList<>();

    public ArrayList<HLNH_RiceVariety> getRiceVarietyList() {
        return riceVarietyList;
    }

    public void setRiceVarietyList(ArrayList<HLNH_RiceVariety> riceVarietyList) {
        this.riceVarietyList = riceVarietyList;
    }

    public int getSize() {
        return riceVarietyList.size();
    }

    public int readFile(String path) throws Exception {
        int loaded = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                if (loadLine(line)) loaded++;
            }
        }
        return loaded;
    }

    private boolean loadLine(String line) {
        String name = null, origin = null, harvestDate = null, yield = null, diseaseResistance = null;

        for (String part : line.split(",")) {
            String[] kv = part.split("=", 2);
            if (kv.length != 2) return false;
            String key = kv[0].trim();
            String value = kv[1].trim();

            switch (key) {
                case "name": name = value; break;
                case "origin": origin = value; break;
                case "harvestDate": harvestDate = value; break;
                case "yield": yield = value; break;
                case "diseaseResistance": diseaseResistance = value; break;
            }
        }

        if (isBlank(name) || isBlank(origin) || isBlank(harvestDate)
                || isBlank(yield) || isBlank(diseaseResistance)) {
            return false;
        }
        return addRiceVariety(name, origin, harvestDate, yield, diseaseResistance);
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public boolean addRiceVariety(String name, String origin, String harvestDateStr,
                                   String yieldStr, String diseaseResistance) {
        for (HLNH_RiceVariety rv : riceVarietyList) {
            if (rv.getHLNH_name().equalsIgnoreCase(name)) return false;
        }
        try {
            Date harvestDate = DATE_FORMAT.parse(harvestDateStr);
            double yield = Double.parseDouble(yieldStr);
            riceVarietyList.add(new HLNH_RiceVariety(name, origin, harvestDate, yield, diseaseResistance));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void sortByName() {
        riceVarietyList.sort(Comparator.comparing(HLNH_RiceVariety::getHLNH_name, String.CASE_INSENSITIVE_ORDER));
    }

    public String formatGroupedByOrigin() {
        HashMap<String, List<HLNH_RiceVariety>> grouped = new HashMap<>();
        for (HLNH_RiceVariety rv : riceVarietyList) {
            String origin = rv.getHLNH_origin();
            if (!grouped.containsKey(origin)) {
                grouped.put(origin, new ArrayList<>());
            }
            grouped.get(origin).add(rv);
        }

        StringBuilder sb = new StringBuilder();
        for (String origin : grouped.keySet()) {
            sb.append("Origin: ").append(origin).append("\n");
            for (HLNH_RiceVariety rv : grouped.get(origin)) {
                sb.append("  ").append(rv.toString()).append("\n");
            }
        }
        return sb.toString();
    }

    public List<HLNH_RiceVariety> removeOlderThan10Years() {
        LocalDate cutoff = LocalDate.now().minusYears(10);

        List<HLNH_RiceVariety> removed = new ArrayList<>();
        for (HLNH_RiceVariety rv : riceVarietyList) {
            LocalDate harvestDate = rv.getHLNH_harvestDate().toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            if (harvestDate.isBefore(cutoff)) {
                removed.add(rv);
            }
        }

        riceVarietyList.removeAll(removed);
        return removed;
    }

    public String formatAll(List<HLNH_RiceVariety> list) {
        StringBuilder sb = new StringBuilder();
        for (HLNH_RiceVariety rv : list) {
            sb.append(rv.toString()).append("\n");
        }
        return sb.toString();
    }
}
