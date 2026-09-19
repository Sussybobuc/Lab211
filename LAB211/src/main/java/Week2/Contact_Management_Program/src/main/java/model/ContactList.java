package model;

import java.util.ArrayList;
import java.util.List;

public class ContactList {
    private final ArrayList<Contact> contactsList = new ArrayList<>();

    public ArrayList<Contact> getContactsList() {
        return contactsList;
    }

    public boolean addContact(List<Contact> list, Contact contact) {
        return list.add(contact);
    }

    public String formatAll(List<Contact> list) {
        StringBuilder result = new StringBuilder();
        for (Contact c : list) {
            result.append(c.toString()).append("\n");
        }
        return result.toString();
    }

    public Contact findContactID(List<Contact> list, int id){
        for (Contact c : list){
            if (c.getID() == id)
                return c;
        }
        return null;
    }

    public boolean deleteContact(List<Contact> list, Contact contact){
        if (contact == null){
            return false;
        } else
            return list.remove(contact);
    }

}
