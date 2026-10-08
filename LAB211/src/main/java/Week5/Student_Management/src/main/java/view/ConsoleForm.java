package view;



public class ConsoleForm {

    public String[] addStudent(){
        System.out.println("--------- Create Student ----------");
        System.out.print("Student name: ");
        String sName = DataInput.inputString();
        System.out.print("Student semester: ");
        String semester = DataInput.inputString();
        System.out.print("Student course: ");
        String courseName = DataInput.inputString();
        return new String[] {sName,semester,courseName};
    }
    public boolean inputYN(){
        System.out.println("Do you want to continue (Y/N)?");
        System.out.println("Choose Y to continue (a student one time), " +
                "N to return to main screen.");
        System.out.print("Y or N: ");
        return DataInput.inputYN();
    }
    public String findStudentInfo(){
        System.out.println("--------- Find/Sort Student ----------");
        System.out.print("Student name: ");
        return DataInput.inputString();
    }
    public void getStudentInfo(String formatted){
        System.out.println("-------------------- Student Info --------------------");
        System.out.printf("-5%s-15%s-5%s-10%s\n",
                "ID", "Name", "Semester", "Course");
        System.out.print(formatted);
    }

    public int inputStudentID(){
        System.out.println("--------- Update Student -----------");
        System.out.print("Student ID: ");
        return DataInput.inputInt();
    }

    public boolean inputUD(){
        System.out.print("Do you want to update (U) or delete (D): ");
        return DataInput.inputUD();
    }

    public String[] updateStudentInfo(){
            System.out.print("New semester: ");
            String semester = DataInput.inputString();
            System.out.print("New course: ");
            String courseName = DataInput.inputString();
            return  new String[] {semester,courseName};
    }
}
