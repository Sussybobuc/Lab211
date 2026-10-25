package view;

public class ConsoleForm {

    public int InputNumber() {
        System.out.print("Enter the number of element: ");
        return DataInput.inputInt();
    }

    public void displayFraction(String formatted){
        System.out.println(formatted);
    }

    public void displaySum(String formatted){
        System.out.println("Sum of fractions: " + formatted);
    }
}
