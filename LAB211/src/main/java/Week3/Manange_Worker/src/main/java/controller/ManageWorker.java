package controller;

import model.Worker;
import model.WorkerList;
import view.ConsoleForm;
import view.DataInput;
import view.Menu;

public class ManageWorker {
    WorkerList workerList = new WorkerList();
    ConsoleForm consoleForm = new ConsoleForm();

    public void execute() {
        while (true) {
            int choice = Menu.getChoice();
            switch (choice) {
                case 1:
                    boolean success = workerList.addWorker(workerList.getWorkerList(), consoleForm.addWorker());
                    if (!success) System.out.println("Failed to add worker.");
                    else break;
                case 2:
                    System.out.println("------- Up/Down Salary --------");
                    System.out.print("Enter Code: ");
                    String upCode = DataInput.inputString();
                    Worker upFound = workerList.findWorkerByCode(workerList.getWorkerList(), upCode);
                    if (upFound == null) {
                        System.out.println("No such worker.");
                    }
                    else {
                        boolean upSuccess = consoleForm.changeSalary(workerList, true, upCode);
                        if (!upSuccess) {
                            System.out.println("Failed to change salary.");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("------- Up/Down Salary --------");
                    System.out.print("Enter Code: ");
                    String downCode = DataInput.inputString();
                    Worker downFound = workerList.findWorkerByCode(workerList.getWorkerList(), downCode);
                    if (downFound == null) {
                        System.out.println("No such worker.");
                        break;
                    }
                    boolean downSuccess = consoleForm.changeSalary(workerList, false, downCode);
                    if (!downSuccess) {
                        System.out.println("Failed to change salary.");
                        break;
                    }
                    break;
                case 4:
                    consoleForm.getInfoSalary(workerList.formatAll(workerList.getInformationSalary()));
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
