package view;

public class ConsoleForm {

    public int chooseType(){
        System.out.println(
                "0 → add an Electronics product\n" +
                "1 → add a Furniture product\n" +
                "2 → add a Food product");
        return DataInput.inputType();
    }

    public String inputID(){
        System.out.println("ADD NEW PRODUCT");
        System.out.print("Enter product's id: ");
        return DataInput.inputString();
    }

    public void existedID(){
        System.out.println("EXIST PRODUCT" +
                ", PLEASE TRY ANOTHER ID");
    }

    public String[] newProduct(){
        System.out.print("Enter product's name: ");
        String name = DataInput.inputString();
        float price = inputPrice();
        System.out.print("Enter product's manufacturer: ");
        String manufacturer = DataInput.inputString();
        return new String[]{name,String.valueOf(price), manufacturer};
    }

    public float inputPrice(){
        while (true){
            System.out.print("Enter product's price: ");
            float price = DataInput.inputFloat();
            if (!Validation.validatePrice(price)) {
                System.out.println("Price is invalid, please try again");
            } else return price;
        }
    }

    public int newElectronicsProduct(){
        while (true){
            System.out.print("Enter warranty years: ");
            int years = DataInput.inputInt();
            if (!Validation.inputWarranty(years)) System.out.println("Invalid years");
            else return years;
        }
    }

    public String newFurnitureProduct(){
        System.out.print("Enter product's materials ");
        return DataInput.inputString();
    }

    public String newFoodProduct(){
        while (true){
            System.out.print("Enter expiration date: ");
            String date = DataInput.inputString();
            if (!Validation.validateDate(date)) {
                System.out.print("Date is invalid, please try again");
            } else return date;
        }
    }

    public void displayRecent(String formatted){
        System.out.printf("%-5s%-10s%-10s%-15s%-5s%-10s\n",
                "ID","NAME","PRICE","MANUFACTURER","TYPE","YEARS/MATERIAL/DATE");
        System.out.println(formatted);
    }

    public String searchByName(){
        System.out.print("Enter product's name: ");
        return DataInput.inputString();
    }

    public void displaySearch(String formatted){
        System.out.printf("%-5s%-10s%-10s%-15s%-5s%-10s\n",
                "ID","NAME","PRICE","MANUFACTURER","TYPE","YEARS/MATERIAL/DATE");
        System.out.println(formatted);
    }

    public String inputUpID(){
        System.out.println("UPDATE PRODUCT");
        System.out.print("Enter product's id: ");
        return DataInput.inputString();
    }

    public float inputPriceUp(){
        while (true){
            System.out.print("Enter product's price (0.0 to skip): ");
            float price = DataInput.inputFloat();
            if (price == 0f) return price;
            if (!Validation.validatePrice(price)) {
                System.out.println("Price is invalid, please try again");
            } else return price;
        }
    }

    public String[] updateProduct(){
        System.out.print("Enter product's name: ");
        String name = DataInput.updateString();
        String finalName = name.isEmpty() ? null : name;
        float price = inputPriceUp();
        System.out.print("Enter product's manufacturer: ");
        String manufacturer = DataInput.updateString();
        String finalManufacturer = manufacturer.isEmpty() ? null : manufacturer;
        return new String[]{finalName,String.valueOf(price), finalManufacturer};
    }

    public int updateElectronicProduct(){
        while (true){
            System.out.print("Enter warranty years (-1 to skip): ");
            int years = DataInput.inputInt();
            if (years == -1) return years;
            if (!Validation.inputWarranty(years)) System.out.println("Invalid years");
            else return years;
        }
    }

    public String updateFurnitureProduct(){
        System.out.print("Enter product's materials (blank to skip): ");
        return DataInput.updateString();
    }

    public String updateFoodProduct(){
        while (true){
            System.out.print("Enter expiration date (blank to skip): ");
            String date = DataInput.updateString();
            if (date.isEmpty()) return date;
            if (!Validation.validateDate(date)) {
                System.out.println("Date is invalid, please try again");
            } else return date;
        }
    }

    public String inputDeleteID(){
        System.out.println("DELETE PRODUCT");
        System.out.print("Enter product's id: ");
        return DataInput.inputString();
    }
}
