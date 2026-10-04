/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author ASUS
 */
public class ConsoleForm {

    public String[] addTask() {
        System.out.println("------------Add Task---------------");
        System.out.print("Requirement Name:");
        String rName = DataInput.inputString();
        System.out.print("Task type:");
        String id = DataInput.inputString();
        System.out.print("Date:");
        String date = DataInput.inputString();
        System.out.print("From:");
        String from = DataInput.inputString();
        System.out.print("To:");
        String to = DataInput.inputString();
        System.out.print("Assignee:");
        String assignee = DataInput.inputString();
        System.out.print("Reviewer:");
        String reviewer = DataInput.inputString();
        return new String[]{rName, id, date, from, to, assignee, reviewer};
    }

    public String deleteTask() {
        System.out.println("---------Del Task------");
        System.out.print("ID:");
        return DataInput.inputString();
    }
        public void getDataTask(String formatted) {
        System.out.println("----------------------------------------- Task ---------------------------------------");
        System.out.printf("%-8s%-20s%-15s%-15.15s%-10s%-15s%-15s\n", "ID", "Name",
                "Task Type", "Date", "Time", "Assignee", "Reviewer");
        System.out.print(formatted);
    }
}
