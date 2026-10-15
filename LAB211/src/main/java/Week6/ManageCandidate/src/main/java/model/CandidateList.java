package model;

import java.util.ArrayList;
import java.util.List;


public class CandidateList {
    ArrayList<Candidates> cList = new ArrayList<>();

    public ArrayList<Candidates> getcList() {
        return cList;
    }

    public void setcList(ArrayList<Candidates> cList) {
        this.cList = cList;
    }

    public void addCandidates(Candidates candidate) {
        cList.add(candidate);
    }

    public ArrayList<Candidates> searchCandidate(String name, int type) {
        ArrayList<Candidates> result = new ArrayList<>();
        name = name.trim().toLowerCase();
        for (Candidates c : cList) {
            if((c.getFirstName().trim().toLowerCase().contains(name)
                    || c.getLastName().trim().toLowerCase().contains(name))
                    && c.getCandidateType() == type){
                result.add(c);
            }
        }
        return result;
    }

    public boolean addCandidate(Candidates c) {
        return cList.add(c);
    }

    public String formatSearch(List<Candidates> List){
        StringBuilder result = new StringBuilder();
        for(Candidates c : List){
            result.append(String.format("%s | %s | %s | %s | %s | %d",
                    c.getName(),
                    c.getBirthdate(),
                    c.getAddress(),
                    c.getPhone(),
                    c.getEmail(),
                    c.getCandidateType()));
        }
        return result.toString();
    }

    public String formatNames(int type) {
        StringBuilder sb = new StringBuilder();
        for (Candidates c : cList) {
            if (c.getCandidateType() == type) {
                sb.append(c).append("\n");
            }
        }
        return sb.toString();
    }

    public boolean checkRank(String Graduation_rank){
        return ("EXCELLENCE".equalsIgnoreCase(Graduation_rank)
                || "GOOD".equalsIgnoreCase(Graduation_rank)
                || "FAIR".equalsIgnoreCase(Graduation_rank)
                || "POOR".equalsIgnoreCase(Graduation_rank));
    }

    public boolean checkExp(int Exp, String bdate){
        int year = Integer.parseInt(bdate);
        return Exp < year;
    }
    /*
    TODO:
     BirthDate : is number with length is 4 character(1900..Current Year)
     Phone: is number with minimum 10 characters
     Email: with format <account name>@<domain>. (eg: annguyen@fpt.edu.vn)
     Year of Experience : is number from 0 to 100
     Rank of Graduation: with one of4 values (Excellence, Good, Fair, Poor)

*/
    public Candidates createCandidate(int choice, String fName, String lName
            , String Birthdate, String Address, String Phone, String Email
            , int ExplnYear, String ProSkill
            , String Graduation_date, String Graduation_rank, String Uni_name
            , String Majors, String Semester)
    {
        if (choice == 1 && checkExp(ExplnYear, Birthdate)) {
            return new Experienced(fName,
                    lName,
                    Birthdate,
                    Address,
                    Phone,
                    Email,
                    0,
                    ExplnYear,
                    ProSkill);
        } else if (choice == 2 && checkRank(Graduation_rank)) {
            return new Fresher(fName,
                    lName,
                    Birthdate,
                    Address,
                    Phone,
                    Email,
                    1,
                    Graduation_date,
                    Graduation_rank,
                    Uni_name);
        } else if (choice == 3 ) {
            return new Intern(fName,
                    lName,
                    Birthdate,
                    Address,
                    Phone,
                    Email,
                    2,
                    Majors,
                    Semester,
                    Uni_name);
        }
        return null;
    }

}
