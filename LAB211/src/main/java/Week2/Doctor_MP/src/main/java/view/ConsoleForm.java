package view;

import model.Doctor;
import model.doctorList;

public class ConsoleForm {
    public Doctor inputInformation() {
        System.out.println("--------- Add Doctor ----------");
        System.out.print("Enter Code: ");
        String Code = DataInput.inputString();
        System.out.print("Enter Name: ");
        String Name = DataInput.inputString();
        System.out.print("Enter Specialization: ");
        String Specialization = DataInput.inputString();
        System.out.print("Enter Availability: ");
        int Availability = DataInput.inputInt();
        return new Doctor(Code, Name, Specialization, Availability);
    }

    public boolean updateInformation(Doctor doc, doctorList list) {
        System.out.print("Enter Name: ");
        String newName = DataInput.updateString();
        String finalName = newName.isEmpty() ? doc.getName() : newName;
        doc.setName(finalName);

        System.out.print("Enter Specialization: ");
        String newSpecialization = DataInput.updateString();
        String finalSpecialization = newSpecialization.isEmpty() ? doc.getSpecialization() : newSpecialization;
        doc.setSpecialization(finalSpecialization);

        System.out.print("Enter Availability: ");
        Integer newAvailability = DataInput.updateInt();
        int finalAvailability = newAvailability == null ? doc.getAvailability() : newAvailability;
        return list.updateDoctor(doc,finalName,finalSpecialization,finalAvailability);
    }

    public void displayAll(String formatted) {
        System.out.printf("%-7s%-10s%-20s%s\n", "Code", "Name",
                "Specialization", "Availability");
        System.out.print(formatted);
    }

}
