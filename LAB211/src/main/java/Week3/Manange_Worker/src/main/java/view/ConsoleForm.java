package view;

import model.SalaryHistory;
import model.Worker;
import model.WorkerList;

public class ConsoleForm {
    public Worker addWorker(){
        System.out.println("--------- Add Worker ----------");
        System.out.print("Enter Code: ");
        String Code = DataInput.inputString();
        System.out.print("Enter Name: ");
        String Name = DataInput.inputString();
        System.out.print("Enter Age: ");
        int Age = DataInput.inputInt();
        System.out.print("Enter Salary: ");
        int Salary = DataInput.inputInt();
        System.out.print("Enter work location: ");
        String WorkLocation = DataInput.inputString();
        return new Worker(Code, Name, Age, Salary, WorkLocation);
    }

    public boolean changeSalary(WorkerList list, boolean isIncrease, String code){
        System.out.print("Enter Salary: ");
        int Salary = DataInput.inputInt();
        return list.changeSalary(code, Salary, isIncrease);
    }
    public void getInfoSalary(String formatted) {
        System.out.println("--------------------Display Information Salary-----------------------");
        System.out.printf("%-7s%-10s%-20s%-20s%-20s%-20s\n", "Code", "Name",
                "Age", "Salary", "Status", "Date");
        System.out.print(formatted);
    }
}
