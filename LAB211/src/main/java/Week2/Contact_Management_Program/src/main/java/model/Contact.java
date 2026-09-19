package model;

/*
TODO:
    int nextID
    int ID
 */
public class Contact {
    protected final int ID;
    protected String fullname;
    protected String group;
    protected String address;
    protected String phone;
    protected String lastname;
    protected String firstname;
    private static int nextID = 1;

    public Contact(String fullname, String firstname, String lastname, String group, String address, String phone) {
        this.ID = nextID;
        nextID++;
        this.fullname = fullname;
        this.group = group;
        this.address = address;
        this.phone = phone;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public int getID() {
        return ID;
    }

    public String getFullname() {
        return firstname + lastname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-15s%-15s%-15s%-8s%-15s%-10s", ID, fullname, firstname, lastname, group, address, phone);
    }
}
