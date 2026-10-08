package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentList {
    ArrayList<Student> studentsList = new ArrayList<>();
    private int nextID = 1;
    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }
    public void setStudentsList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }

    private int findIDbyName(String name)
    {
        for ( Student s : studentsList){
            if(s.getStudentName().trim().equalsIgnoreCase(name.trim()))
                return s.getId();
        }
        return 0;
    }

    public List<Student> findStudentByID(int id)
    {
        ArrayList<Student> matches = new ArrayList<>();
        for ( Student s : studentsList){
            if(s.getId() == id) matches.add(s);
        } return matches;
    }

    public ArrayList<Student> findStudentInfo(String name)
    {
        name = name.trim().toLowerCase();
        ArrayList<Student> students = new ArrayList<>();
        for ( Student s : studentsList){
            if(s.getStudentName().toLowerCase().trim().contains(name))
                students.add(s);
        }
        students.sort(Comparator.comparing(Student::getStudentName));
        return students;
    }

    public boolean courseExists(String courseName){
        return ("Java".equalsIgnoreCase(courseName)
                || ".Net".equalsIgnoreCase(courseName)
                || "C/C++".equalsIgnoreCase(courseName));
    }

    public boolean addStudent(String sName, String semester, String courseName){
        if(!courseExists(courseName.trim()))
            return false;
        int id = findIDbyName(sName);
        if (id == 0) {
            id = nextID;
            nextID++;
            Student student = new Student(id, sName,semester,courseName);
            return studentsList.add(student);
        }
        else return false;
    }

    public boolean updateStudent(int id, String newSemester, String newCourseName, boolean isUpdate){
        List<Student> student = findStudentByID(id);
        if (student.isEmpty()) return false;
        if (isUpdate) {
            if (!courseExists(newCourseName.trim())) return false;
            for ( Student s : student){
                s.setSemester(newSemester);
                s.setCourseName(newCourseName);
            }
            return true;
        } else return studentsList.removeIf(s -> s.getId() == id);
    }

    public String formatAllStudents(List<Student> students){
        StringBuilder result = new StringBuilder();
        for (Student s : students){
            result.append(s.toString()).append("\n");
        }
        return result.toString();
    }

    public int getSize(){
        return studentsList.size();
    }
}
