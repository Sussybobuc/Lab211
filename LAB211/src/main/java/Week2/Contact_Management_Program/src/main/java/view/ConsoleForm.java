package view;

import model.Contact;

import java.util.List;

public class ConsoleForm {


    public void displayAll(String formatted) {
        System.out.printf("%-5s%-15s%-10s%-10s%-8s%-15s%-10s\n", "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
        System.out.println(formatted);
    }
}
