package controller;

import model.Student;
import model.StudentList;
import view.ConsoleForm;
import view.Menu;

import java.util.List;

public class ManageStudent {
    ConsoleForm consoleForm = new ConsoleForm();
    StudentList studentList = new StudentList();

    public void execute() {
        while (true) {
            int choice = Menu.getChoice();
            switch (choice) {
                case 1:
                    while (true) {
                        if (studentList.getSize() > 3) {
                            if (consoleForm.inputYN()) continue;
                            else break;
                        }
                        String[] in = consoleForm.addStudent();
                        boolean success = studentList.addStudent(in[0], in[1], in[2]);
                        if (success) {
                            System.out.println("Student added successfully!");
                        } else System.out.println("Failed to add student!");
                    }
                case 2:
                    String findName = consoleForm.findStudentInfo();
                    List<Student> found = studentList.findStudentInfo(findName);
                    if (found.isEmpty()) System.out.println("Student not found!");
                    else {
                        String formatted = studentList.formatAllStudents(found);
                        consoleForm.getStudentInfo(formatted);
                    }
                    break;
                case 3:
                    int findID = consoleForm.inputStudentID();
                    List<Student> exists = studentList.findStudentByID(findID);
                    if (exists.isEmpty()) System.out.println("Student not found!");
                    else {
                        boolean UD = consoleForm.inputUD();
                        String[] in = consoleForm.updateStudentInfo();
                        boolean update = studentList.updateStudent(findID, in[0], in[1], UD);
                        if (update) {
                            System.out.println("Student updated successfully!");
                        } else System.out.println("Failed to update student!");
                        break;
                    }
                case 4:

                case 5: System.exit(0);
            }
        }

    }
}
