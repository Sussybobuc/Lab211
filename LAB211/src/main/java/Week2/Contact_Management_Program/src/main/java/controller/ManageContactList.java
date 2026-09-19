package controller;

import model.Contact;
import model.ContactList;
import view.ConsoleForm;
import view.Menu;

public class ManageContactList {

    ContactList list = new ContactList();
    ConsoleForm console = new ConsoleForm();

    public void execute() {
        while (true) {
            int choice = Menu.getChoice();
            switch (choice) {
                case 1:
                    boolean success = list.addContact(list.getContactsList(), console.inputInformation());
                    if (!success) {System.out.println("Failed to add Contact!");
                    } else System.out.println("Successful");
                    break;
                case 2:
                    console.displayAll(list.formatAll(list.getContactsList()));
                    break;
                case 3:
                    int id = console.enterID();
                    Contact found = list.findContactID(list.getContactsList(), id);
                    boolean delete = list.deleteContact(list.getContactsList(), found);
                    if (!delete) System.out.println("No found contact");
                    else System.out.println("Successful");
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
