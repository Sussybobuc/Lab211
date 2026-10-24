package model;

public class Food extends Product{
    protected String expirationDate;

    public Food() {
    }

    public Food(String productId, String productName, float price, String manufacturer, String expirationDate) {
        super(productId, productName, price, manufacturer, 2);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10s", expirationDate);
    }
}
