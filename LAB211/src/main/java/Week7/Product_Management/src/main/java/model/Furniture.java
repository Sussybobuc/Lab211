package model;

public class Furniture extends Product{
    protected String material;

    public Furniture() {
    }

    public Furniture(String productId, String productName, float price, String manufacturer, String material) {
        super(productId, productName, price, manufacturer, 1);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10s", material);
    }
}
