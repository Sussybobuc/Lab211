package model;

public class Electronics extends Product {
    protected int warrantyYears;

    public Electronics() {
    }

    public Electronics(String productId, String productName, float price, String manufacturer, int warrantyYears) {
        super(productId, productName, price, manufacturer, 0);
        this.warrantyYears = warrantyYears;
    }

    public int getWarrantyYears() {
        return warrantyYears;
    }

    public void setWarrantyYears(int warrantyYears) {
        this.warrantyYears = warrantyYears;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-5d", warrantyYears);
    }
}
