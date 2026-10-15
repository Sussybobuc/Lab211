package model;

public class Candidates {
    private final int CandidateId;
    private String FirstName;
    private String LastName;
    private String Birthdate;
    private String Address;
    private String Phone;
    private String Email;
    private int CandidateType;
    private static int nextID;

    public Candidates(String firstName, String lastName, String birthdate, String address, String phone, String email,  int candidateType) {
        CandidateId = nextID;
        nextID++;
        FirstName = firstName;
        LastName = lastName;
        Birthdate = birthdate;
        Address = address;
        Phone = phone;
        Email = email;
        CandidateType = candidateType;
    }

    public int getCandidateId() {
        return CandidateId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getName(){
        return FirstName + " " + LastName;
    }
    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getCandidateType() {
        return CandidateType;
    }

    public void setCandidateType(int candidateType) {
        CandidateType = candidateType;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-7s%-15s%-15s%-30s"
                , FirstName + " " + LastName
                , Birthdate
                , Address
                , Phone
                , Email);
    }
}
