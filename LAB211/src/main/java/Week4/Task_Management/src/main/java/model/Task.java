/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Task {

    private final int ID;
    private String TaskTypeID;
    private String rName;
    private String date;
    private double pFrom;
    private double pTo;
    private String Assignee;
    private String Expert;
    private static int nextID = 1;

    public Task(String TaskTypeID, String rName, String date, double pFrom, double pTo, String Assignee, String Expert) {
        this.ID = nextID;
        nextID++;
        this.TaskTypeID = TaskTypeID;
        this.rName = rName;
        this.date = date;
        this.pFrom = pFrom;
        this.pTo = pTo;
        this.Assignee = Assignee;
        this.Expert = Expert;
    }

    public int getID() {
        return ID;
    }

    public String getTaskTypeID() {
        return TaskTypeID;
    }

    public void setTaskTypeID(String TaskTypeID) {
        this.TaskTypeID = TaskTypeID;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getpFrom() {
        return pFrom;
    }

    public void setpFrom(double pFrom) {
        this.pFrom = pFrom;
    }

    public double getpTo() {
        return pTo;
    }

    public void setpTo(double pTo) {
        this.pTo = pTo;
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public String getExpert() {
        return Expert;
    }

    public void setExpert(String Expert) {
        this.Expert = Expert;
    }

    @Override
    public String toString() {
        return String.format("%-8d%-20.20s%-15s%-15.15s%-10.1f%-15s%-15s",
                ID, rName, TaskTypeID, date, (pTo - pFrom), Assignee, Expert);
    }

}
