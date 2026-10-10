package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class StudentList {
    ArrayList<Student> studentsList = new ArrayList<>();
    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }
    public void setStudentsList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public List<Student> findStudentByID(String id)
    {
        ArrayList<Student> matches = new ArrayList<>();
        for ( Student s : studentsList){
            if(s.getId().equalsIgnoreCase(id)) matches.add(s);
        } return matches;
    }

    public ArrayList<Student> findStudentInfo(String name)
    {
        name = name.toLowerCase();
        ArrayList<Student> students = new ArrayList<>();
        for ( Student s : studentsList){
            if(s.getStudentName().toLowerCase().contains(name))
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

    public boolean addStudent(String id, String sName, String semester, String courseName){
        if(!courseExists(courseName))
            return false;
        List<Student> students = findStudentByID(id);
        if (!students.isEmpty()) {
            for (Student s : students){
                if(!(s.getStudentName().equalsIgnoreCase(sName)))
                    return false;
            }
        }
        Student newStudent = new Student(id, sName, semester, courseName);
        return studentsList.add(newStudent);
    }
/*
    find ID then depends on the choice to either update or remove
*/
    public boolean updateStudent(String id, String newSemester, String newCourseName, boolean isUpdate, int choice){
        List<Student> student = findStudentByID(id);
        if (student.isEmpty()) return false;
        if(choice > student.size()) return false;
        Student course = student.get(choice - 1);
        if (isUpdate) {
            if (!courseExists(newCourseName)) return false;
            course.setSemester(newSemester);
            course.setCourseName(newCourseName);
            return true;
        } else return studentsList.remove(course);
    }

    public String formatUpdate(List<Student> students){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (Student s : students){
            count++;
            sb.append(String.format("%-5d%-18s%-10s%s"
                    ,count,s.getStudentName(),
                    s.getSemester(),
                    s.getCourseName()))
                    .append("\n");
        } return sb.toString();
    }

    /* 1 outside & 2 inner loop, first loop put existed course into sb,
     first inner loop check if the current object already existed in the sb
     if existed, skip that object.
     Continue with 2 separate checker, which check for if the current object
     have the same ID and a second one for existed entry in the StringBuilder.
     If both of the checker passed, increase count to add to the total of courses
     */
    public String report(){
            StringBuilder sb = new StringBuilder();
            int counter = 0;

            for(int i = 0; i < getSize(); i++){
                Student s = studentsList.get(i);

                boolean contained = false;
                for (int j = 0; j < i  ; j++){
                    Student previous = studentsList.get(j);
                    if(previous.getId().equalsIgnoreCase(s.getId()))
                        contained = true;
                }
                if(contained) continue;
                counter++;

                for (int k = i; k < getSize(); k++){
                    Student sameID = studentsList.get(k);
                    if ( !(sameID.getId().equalsIgnoreCase(s.getId())) ) continue;

                    boolean passed = false;
                    for (int m = i; m < k; m++){
                        Student earlier = studentsList.get(m);
                        if (earlier.getId().equalsIgnoreCase(s.getId())
                                && earlier.getCourseName().equalsIgnoreCase(sameID.getCourseName()))
                            passed = true;
                    }
                    if (passed) continue;

                    int count = 0;
                    for (Student current: studentsList){
                        if(current.getId().equalsIgnoreCase(sameID.getId()) &&
                                current.getCourseName().equalsIgnoreCase(sameID.getCourseName()))
                            count++;
                    }

                sb.append(String.format("%02d",counter)).append(" | ")
                        .append(s.getStudentName()).append(" | ")
                        .append(sameID.getCourseName()).append(" | ")
                        .append(count).append("\n");
                }
            } return sb.toString();
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
