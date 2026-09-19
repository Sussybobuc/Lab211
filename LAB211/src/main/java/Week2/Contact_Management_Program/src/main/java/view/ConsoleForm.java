package view;

import model.Contact;

public class ConsoleForm {

    public Contact inputInformation() {
        System.out.println("-------- Add a Contact --------");
        System.out.print("Enter First Name: ");
        String firstname = DataInput.inputString();
        System.out.print("Enter Last Name: ");
        String lastname = DataInput.inputString();
        System.out.print("Enter Group: ");
        String group = DataInput.inputString();
        System.out.print("Enter Address: ");
        String address = DataInput.inputString();
        System.out.print("Enter Phone: ");
        String phone = DataInput.inputPhone();
        String fullname = firstname + " " + lastname;
        Contact c = new Contact(fullname, firstname, lastname, group, address, phone);
        return c;
    }

    public void displayAll(String formatted) {
        System.out.println("--------------------------------- Display all Contact ----------------------------");
        System.out.printf("%-5s%-15s%-15s%-15s%-8s%-15s%-10s\n",
                "ID", "Name", "First Name", "Last Name",
                "Group", "Address", "Phone");
        System.out.println(formatted);
    }

    public int enterID() {
        System.out.println("-------- Delete a contact --------");
        System.out.print("Enter ID: ");
        return DataInput.inputID();
    }

}
