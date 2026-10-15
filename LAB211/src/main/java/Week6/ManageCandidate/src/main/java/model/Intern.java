package model;

public class Intern extends Candidates{
    protected String Majors;
    protected String Semester;
    protected String Uni_Name;

    public Intern(String firstName, String lastName, String birthdate, String address, String phone, String email,int candidateType, String majors, String semester, String uni_Name) {
        super( firstName, lastName, birthdate, address, phone, email, candidateType);
        Majors = majors;
        Semester = semester;
        Uni_Name = uni_Name;
    }

    public String getMajors() {
        return Majors;
    }

    public void setMajors(String majors) {
        Majors = majors;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getUni_Name() {
        return Uni_Name;
    }

    public void setUni_Name(String uni_Name) {
        Uni_Name = uni_Name;
    }

    @Override
    public String toString() {
        return super.toString() + "Intern";
    }
}
