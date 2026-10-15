package model;

public class Fresher extends Candidates{
    protected String Graduation_date;
    protected String Graduation_rank;
    protected String Graduation_From;

    public Fresher( String firstName, String lastName, String birthdate, String address, String phone, String email,int candidateType, String graduation_date, String graduation_rank, String graduation_From) {
        super(firstName, lastName, birthdate, address, phone, email, candidateType);
        Graduation_date = graduation_date;
        Graduation_rank = graduation_rank;
        Graduation_From = graduation_From;
    }

    public String getGraduation_date() {
        return Graduation_date;
    }

    public void setGraduation_date(String graduation_date) {
        Graduation_date = graduation_date;
    }

    public String getGraduation_rank() {
        return Graduation_rank;
    }

    public void setGraduation_rank(String graduation_rank) {
        Graduation_rank = graduation_rank;
    }

    public String getGraduation_From() {
        return Graduation_From;
    }

    public void setGraduation_From(String graduation_From) {
        Graduation_From = graduation_From;
    }

    @Override
    public String toString() {
        return super.toString() + "Fresher";
    }
}
