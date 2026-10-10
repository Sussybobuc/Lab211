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
                    /*
                    Rather than using a counter, I will use list size to be more consistent
                    */
                    do {
                        String[] in = consoleForm.addStudent();
                        boolean success = studentList.addStudent(in[0], in[1], in[2], in[3]);
                        if (success) {
                            System.out.println("Student added successfully!");
                        } else System.out.println("Failed to add student!");
                    } while (studentList.getSize() < 3 || consoleForm.inputYN());
                    break;
                case 2:
                    /*
                    Using List to gather all of those students with the same name + sort
                    */
                    String findName = consoleForm.findStudentInfo();
                    List<Student> found = studentList.findStudentInfo(findName);
                    if (found.isEmpty()) System.out.println("Student not found!");
                    else {
                        String formatted = studentList.formatAllStudents(found);
                        consoleForm.getStudentInfo(formatted);
                    }
                    break;
                case 3:
                    /*
                    Using List to gather all of entry with the same ID
                    Ask user for Update/Delete
                    */
                    String findID = consoleForm.inputStudentID();
                    List<Student> exists = studentList.findStudentByID(findID);
                    if (exists.isEmpty()) System.out.println("Student not found!");
                    else {
                        boolean UD = consoleForm.inputUD();
                        consoleForm.getCourseInfo(studentList.formatUpdate(exists));
                        int course = consoleForm.chooseCourse();
                        if (UD) {
                            String[] in = consoleForm.updateStudentInfo();
                            boolean update = studentList.updateStudent(findID,
                                    in[0],
                                    in[1],
                                    true,
                                    course);
                            if (update) {
                                System.out.println("Student updated successfully!");
                            } else System.out.println("Failed to update student!");
                        } else {
                            boolean delete = studentList.updateStudent(findID,
                                    "",
                                    "",
                                    false,
                                    course);
                            if (delete) System.out.println("Student deleted successfully!");
                            else System.out.println("Failed to delete student!");
                        }
                    }
                    break;
                case 4:
                    String report = studentList.report();
                    consoleForm.getReportInfo(report);
                    break;
                case 5: System.exit(0);
            }
        }
    }
}
