package controller;

import model.*;
import view.ConsoleForm;
import view.Menu;

import java.util.List;


public class ManageProduct {

    ConsoleForm consoleForm = new ConsoleForm();
    productList productList = new productList();

    public void execute() {
        while (true) {
            int choice = Menu.getChoice();
            switch (choice) {
                case 1:
                    int type = consoleForm.chooseType();
                    switch (type) {
                        case 0:
                            String eID;
                            while (true) {
                                eID = consoleForm.inputID();
                                if (!productList.searchById(eID)) break;
                                consoleForm.existedID();
                            }
                            String[] ep = consoleForm.newProduct();
                            int year = consoleForm.newElectronicsProduct();
                            Product newE = productList.newProduct(eID, ep[0], Float.parseFloat(ep[1]), ep[2], type
                                    , year, null, null);
                            productList.addProduct(newE);
                            System.out.println("PRODUCT CREATED");
                            break;
                        case 1:
                            String fID;
                            while (true) {
                                fID = consoleForm.inputID();
                                if (!productList.searchById(fID)) break;
                                consoleForm.existedID();
                            }
                            String[] fp = consoleForm.newProduct();
                            String material = consoleForm.newFurnitureProduct();
                            Product newF = productList.newProduct(fID, fp[0], Float.parseFloat(fp[1]), fp[2], type
                                    , -1, material, null);
                            productList.addProduct(newF);
                            System.out.println("PRODUCT CREATED");
                            break;
                        case 2:
                            String foodID;
                            while (true) {
                                foodID = consoleForm.inputID();
                                if (!productList.searchById(foodID)) break;
                                consoleForm.existedID();
                            }
                            String[] foodP =  consoleForm.newProduct();
                            String date = consoleForm.newFoodProduct();
                            Product newFood = productList.newProduct(foodID, foodP[0], Float.parseFloat(foodP[1]), foodP[2], type
                                    , -1, null, date);
                            productList.addProduct(newFood);
                            System.out.println("PRODUCT CREATED");
                            break;
                    }
                    break;
                case 2:
                    if (productList.getSize() == 0) {System.out.println("EMPTY PRODUCT LIST"); break;}
                    consoleForm.displayRecent(productList.displayRecently(productList.getRecently()));
                    break;
                case 3:
                    if (productList.getSize() == 0) {System.out.println("EMPTY PRODUCT LIST"); break;}
                    String name = consoleForm.searchByName();
                    List<Product> products = productList.searchByName(name);
                    consoleForm.displaySearch(productList.displaySearch(products));
                    break;
                case 4:
                    if (productList.getSize() == 0) {System.out.println("EMPTY PRODUCT LIST"); break;}
                    String upID = consoleForm.inputUpID();
                    if(!productList.searchById(upID)) {
                        System.out.println("PRODUCT NOT FOUND");
                        break;
                    }
                    Product p = productList.getProductById(upID);
                    int upType = productList.findType(upID);
                    String[] basics = consoleForm.updateProduct();
                    productList.updateBasics(p, basics[0], Float.parseFloat(basics[1]), basics[2]);
                    switch (upType) {
                        case 0:
                            int date = consoleForm.updateElectronicProduct();
                            productList.updateWYears((Electronics) p , date);
                            System.out.println("PRODUCT UPDATED");
                            break;
                        case 1:
                            String material = consoleForm.updateFurnitureProduct();
                            productList.updateMaterials((Furniture)  p, material);
                            System.out.println("PRODUCT UPDATED");
                            break;
                        case 2:
                            String expDate = consoleForm.updateFoodProduct();
                            productList.updateExpirationDate((Food)  p, expDate);
                            System.out.println("PRODUCT UPDATED");
                            break;
                    } break;
                case 5:
                    if (productList.getSize() == 0) {System.out.println("EMPTY PRODUCT LIST"); break;}
                    if (productList.deleteProduct(consoleForm.inputDeleteID())) System.out.println("Delete successful");
                    else System.out.println("Delete failed");
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
