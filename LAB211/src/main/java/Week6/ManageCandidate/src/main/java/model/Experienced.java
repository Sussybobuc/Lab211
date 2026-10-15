package model;

public class Experienced extends Candidates{
    protected int ExplnYear;
    protected String ProSkill;

    public Experienced( String firstName, String lastName, String birthdate, String address, String phone, String email,int candidateType, int explnYear, String proSkill) {
        super( firstName, lastName, birthdate, address, phone, email, candidateType);
        ExplnYear = explnYear;
        ProSkill = proSkill;
    }

    public int getExplnYear() {
        return ExplnYear;
    }

    public void setExplnYear(int explnYear) {
        ExplnYear = explnYear;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String proSkill) {
        ProSkill = proSkill;
    }

    @Override
    public String toString() {
        return super.toString() + "Experienced";
    }
}
