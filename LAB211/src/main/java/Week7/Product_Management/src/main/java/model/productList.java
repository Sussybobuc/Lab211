package model;

import java.util.ArrayList;
import java.util.List;

public class productList {
    private ArrayList<Product> pList = new ArrayList<>();

    public ArrayList<Product> getpList() {
        return pList;
    }

    public void setpList(ArrayList<Product> pList) {
        this.pList = pList;
    }

    public int getSize() {
        return pList.size();
    }
    public void addProduct(Product p) {
        pList.add(p);
    }

    public Product getRecently(){
        if(!pList.isEmpty()){
            return pList.get(pList.size()-1);
        }
        return null;
    }

    public String displayRecently(Product p){
        return p.toString();
    }

    public boolean searchById(String id){
        for(Product p:pList){
            if (p.getProductId().equals(id)){
                return true;
            }
        } return false;
    }

    public Product getProductById(String id){
        for(Product p:pList){
            if (p.getProductId().equals(id)){
                return p;
            }
        }
        return null;
    }

    public ArrayList<Product> searchByName(String name){
        ArrayList<Product> result = new ArrayList<>();
        for(Product p:pList){
            if (name.equalsIgnoreCase(p.getProductName())){
                result.add(p);
            }
        }
        return result;
    }

    public String displaySearch(List<Product> pList){
        StringBuilder result = new StringBuilder();
        for(Product p:pList){
            result.append(p.toString()).append("\n");
        }
        return result.toString();
    }

    public Product newProduct( String id, String name, float price, String manufacturer, int type,
                              int warrantyYears, String material, String expirationDate){
        switch(type){
            case 0:
                return new Electronics(id,name,price,manufacturer,warrantyYears);
            case 1:
                return new Furniture(id,name,price,manufacturer,material);
            case 2:
                return new Food(id,name,price,manufacturer,expirationDate);
        }
    return null;
    }

    public boolean deleteProduct(String id){
        pList.removeIf(p -> p.getProductId().equals(id));
        return true;
    }

    public int findType(String id){
        for(Product p:pList){
            if (p.getProductId().equals(id)){
                if (p.getType() == 0) return 0;
                else if (p.getType() == 1) return 1;
                else if (p.getType() == 2) return 2;
            }
        } return -1;
    }

    public void updateBasics(Product p, String name, float price, String manufacturer){
        if (p == null) return;
        if (name != null) p.setProductName(name);
        if (price != 0f) p.setPrice(price);
        if (manufacturer != null) p.setManufacturer(manufacturer);
    }

    public void updateWYears(Electronics e, int date){
        if (date != -1) e.setWarrantyYears(date);
    }
    public void updateMaterials(Furniture f, String material){
        if (material != null) f.setMaterial(material);
    }
    public void updateExpirationDate(Food food, String expirationDate){
        if (!expirationDate.isEmpty()) food.setExpirationDate(expirationDate);
    }

}
