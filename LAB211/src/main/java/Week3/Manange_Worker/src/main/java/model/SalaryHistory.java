package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryHistory {
    private final String id;
    private final String name;
    private final int age;
    private final int salary;
    private final String status;
    private final LocalDate date;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public SalaryHistory(String id, String name, int age, int salary, String status, LocalDate date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        String formattedDate = (date != null) ? formatter.format(date) : "";
        return String.format("%-7s%-10s%-20d%-20d%-20s%-20s", id, name, age, salary, status, formattedDate);
    }
}
