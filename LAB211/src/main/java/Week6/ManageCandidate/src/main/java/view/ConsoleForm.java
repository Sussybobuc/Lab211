package view;

import model.Candidates;
import model.Experienced;
import model.Fresher;
import model.Intern;



public class ConsoleForm {

    public Candidates createNewCandidates() {
    System.out.println("CREATE NEW CANDIDATES");
    System.out.print("First name: ");
    String fname = DataInput.inputString();
    System.out.print("Last name: ");
    String lname = DataInput.inputString();
    System.out.print("Birth date: ");
    String birthdate = DataInput.inputBD();
    System.out.print("Address: ");
    String address = DataInput.inputString();
    System.out.print("Phone number: ");
    String phoneNumber = DataInput.inputPhone();
    System.out.print("Email: ");
    String email = DataInput.inputEmail();
    System.out.print("Candidate type: ");
    int type = DataInput.inputInt();
    return new Candidates(fname,lname,birthdate,address,phoneNumber,email,type);
    }

    public Experienced createNewExperienced() {
        System.out.print("Year of experience: ");
        int year = DataInput.inputInt();
        System.out.print("Professional Skill: ");
        String skill = DataInput.inputString();
        return new Experienced(null,null,null,null,null,null,0,year,skill);
    }

    public Fresher createNewFresher() {
        System.out.print("Graduate time: ");
        String graduateTime = DataInput.inputDate();
        System.out.print("Rank of Graduation: ");
        String rank = DataInput.inputString();
        System.out.print("University: ");
        String university = DataInput.inputString();
        return new Fresher(null,null,null,null,null,null,1,graduateTime,rank,university);
    }

    public Intern createNewIntern() {
        System.out.print("Majors: ");
        String majors = DataInput.inputString();
        System.out.print("Semester: ");
        String semester = DataInput.inputString();
        System.out.print("University: ");
        String university = DataInput.inputString();
        return new Intern(null,null,null,null,null,null,2,majors,semester,university);
    }

    public String[] searchCandidates() {
        System.out.println("SEARCH CANDIDATES");
        System.out.print("Input Candidate name ( First name or Last name ): " );
        String name = DataInput.inputString();
        System.out.print("Input type of candidate: ");
        String type = DataInput.inputType();
        return new String[]{name, type};
    }

    public void printCandidates(String exp, String fresher, String inter) {
        System.out.println("List of Candidates:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        System.out.print(exp);
        System.out.println("===========FRESHER CANDIDATE============");
        System.out.print(fresher);
        System.out.println("===========INTERN CANDIDATE============");
        System.out.print(inter);
    }

    public void displaySearch(String result){
        System.out.println("The candidates found:");
        System.out.println(result);
    }

    public boolean YN(){
        System.out.print("Do you want to continue (Y/N): ");
        return DataInput.inputYN();
    }
}
