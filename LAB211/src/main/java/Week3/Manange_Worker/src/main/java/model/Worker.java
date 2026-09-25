package model;

import java.util.ArrayList;

public class Worker {
    private String id;
    private String name;
    private int age;
    private int salary;
    private String work_location;
    private ArrayList<SalaryHistory> historyList = new ArrayList<>();


    public Worker(String id, String name, int age, int salary, String work_location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.work_location = work_location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWork_location() {
        return work_location;
    }

    public void setWork_location(String work_location) {
        this.work_location = work_location;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", work_location='" + work_location + '\'' +
                '}';
    }

    public ArrayList<SalaryHistory> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(ArrayList<SalaryHistory> historyList) {
        this.historyList = historyList;
    }
}
