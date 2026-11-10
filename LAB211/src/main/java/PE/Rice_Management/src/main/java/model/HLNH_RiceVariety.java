package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HLNH_RiceVariety {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private String HLNH_name;
    private String HLNH_origin;
    private Date HLNH_harvestDate;
    private double HLNH_yield;
    private String HLNH_diseaseResistance;

    public HLNH_RiceVariety() {
    }

    public HLNH_RiceVariety(String HLNH_name, String HLNH_origin, Date HLNH_harvestDate,
                             double HLNH_yield, String HLNH_diseaseResistance) {
        this.HLNH_name = HLNH_name;
        this.HLNH_origin = HLNH_origin;
        this.HLNH_harvestDate = HLNH_harvestDate;
        this.HLNH_yield = HLNH_yield;
        this.HLNH_diseaseResistance = HLNH_diseaseResistance;
    }

    public String getHLNH_name() {
        return HLNH_name;
    }

    public void setHLNH_name(String HLNH_name) {
        this.HLNH_name = HLNH_name;
    }

    public String getHLNH_origin() {
        return HLNH_origin;
    }

    public void setHLNH_origin(String HLNH_origin) {
        this.HLNH_origin = HLNH_origin;
    }

    public Date getHLNH_harvestDate() {
        return HLNH_harvestDate;
    }

    public void setHLNH_harvestDate(Date HLNH_harvestDate) {
        this.HLNH_harvestDate = HLNH_harvestDate;
    }

    public double getHLNH_yield() {
        return HLNH_yield;
    }

    public void setHLNH_yield(double HLNH_yield) {
        this.HLNH_yield = HLNH_yield;
    }

    public String getHLNH_diseaseResistance() {
        return HLNH_diseaseResistance;
    }

    public void setHLNH_diseaseResistance(String HLNH_diseaseResistance) {
        this.HLNH_diseaseResistance = HLNH_diseaseResistance;
    }

    @Override
    public String toString() {
        return
                "name=" + HLNH_name +
                ",origin=" + HLNH_origin +
                ",harvestDate=" + (HLNH_harvestDate != null ? DATE_FORMAT.format(HLNH_harvestDate) : "null") +
                ",yield=" + HLNH_yield +
                ",diseaseResistance=" + HLNH_diseaseResistance;
    }
}
