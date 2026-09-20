package controller;

import model.Doctor;
import model.doctorList;
import view.ConsoleForm;
import view.DataInput;
import view.menu;

public class ManageDL {

    doctorList list = new doctorList();
    ConsoleForm console = new ConsoleForm();

    public void execute() {
        while (true) {
            int choice = menu.getChoice();
            switch (choice) {
                case 1:
                    boolean success = list.addDoctor(list.getDoctors(), console.inputInformation());
                    if (!success) System.out.println("Failed to add doctor");
                    else
                        break;
                case 2:
                    System.out.println("--------- Update Doctor -------");
                    System.out.print("Enter Code: ");
                    String code = DataInput.inputString();
                    Doctor found = list.findDoctorByCode(list.getDoctors(), code);
                    if (found == null) System.out.println("Doctor code does not exist");
                    else {
                        boolean update = console.updateInformation(found, list);
                        if (update) System.out.println("Doctor info is updated");
                        else System.out.println("Failed to update doctor");
                    }
                    break;
                case 3:
                    String Code = DataInput.inputString();
                    Doctor Found = list.findDoctorByCode(list.getDoctors(), Code);
                    boolean del = list.deleteDoctor(list.getDoctors(), Found);
                    if (!del) System.out.println("code does not exist Doctor");
                    else {
                        System.out.println("Successfully deleted doctor");
                    }
                    break;
                case 4:
                    console.displayAll(list.ViewAllDoctor(list.getDoctors()));
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
