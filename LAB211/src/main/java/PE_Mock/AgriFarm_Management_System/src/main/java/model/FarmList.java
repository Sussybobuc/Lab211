package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
    TODO:
     Check value:
     fieldZone in “Irrigated”, “Dryland”, “Greenhouse”
     dietType in “Herbivore”, “Omnivore”, “Carnivore”
*/
public class FarmList {
    ArrayList<FarmOrganism> FarmList = new ArrayList<>();

    public ArrayList<FarmOrganism> getFarmList() {
        return FarmList;
    }

    public void setFarmList(ArrayList<FarmOrganism> farmList) {
        FarmList = farmList;
    }

    public void addFarmOrganism(FarmOrganism farmOrganism) {
        FarmList.add(farmOrganism);
    }

    public boolean checkFieldZone(String fieldZone){
        return ("Irrigated".equalsIgnoreCase(fieldZone)
                || "Dryland".equalsIgnoreCase(fieldZone)
                || "Greenhouse".equalsIgnoreCase(fieldZone));
    }

    public boolean checkDietType(String dietType){
        return ("Herbivore".equalsIgnoreCase(dietType)
                || "Omnivore".equalsIgnoreCase(dietType)
                || "Carnivore".equalsIgnoreCase(dietType));
    }

    public FarmOrganism newFarmOrganism(int type, String name, int age,
                                        String id, String species, String fieldZone, String sowedDate, double height,
                                        double weight, String dietType)
    {
        if (type == 1){
            return new Crop(name, age, id, species, fieldZone, sowedDate, height);
        }
        else if (type == 2) return new Livestock(name, age, species, weight, dietType);
        else return null;
    }

    public List<FarmOrganism> searchByName(String name){
        List<FarmOrganism> farmList = new ArrayList<>();
        for (FarmOrganism fO : FarmList) {
            if (fO.getName().contains(name)) {
                farmList.add(fO);
            }
        } return farmList;
    }

    public String formatSearch(List<FarmOrganism> farmList){
        StringBuilder sb = new StringBuilder();
        for (FarmOrganism fO : farmList) {
            sb.append(fO.toString()).append("\n");
        }
        return sb.toString();
    }

    public ArrayList<FarmOrganism> getFarmListByName(String name){
        ArrayList<FarmOrganism> farmList = new ArrayList<>();
        for (FarmOrganism fO : FarmList) {
            if (fO.getName().contains(name)) {
                farmList.add(fO);
            }
        }
        farmList.sort(Comparator.comparing(FarmOrganism::getName));
        return farmList;
    }

    public String formatSimulated(List<FarmOrganism> farmList){
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (FarmOrganism fO : farmList) {
            counter++;
            sb.append(String.format("%-5d",counter)).append(fO.toString()).append("\n");
        }
        return sb.toString();
    }

    public String simulateInteraction(String choice, int month, String f1, String f2, int choice1, int choice2){
        if (choice.equals("grow"))
        {
            if (FarmList.isEmpty()) return null;
            for (FarmOrganism fO : FarmList) {
                for (int i = 0; i < month; i++ ) fO.grow();
            } return "Grew all organisms by " + month + " month(s)";
        }
        else
        {
            List<FarmOrganism> farmList1 = getFarmListByName(f1);
            if (farmList1.isEmpty()) return null;
            List<FarmOrganism> farmList2 = getFarmListByName(f2);
            if (farmList2.isEmpty()) return null;
            if (choice1 > farmList1.size() || choice2 > farmList2.size()) return null;
            FarmOrganism First = farmList1.get(choice1 - 1);
            FarmOrganism Second = farmList2.get(choice2 - 1);
            if (First == Second) return null;
            return First.interact(Second);
        }
    }
}
