package model;


import java.util.ArrayList;
import java.util.List;

public class doctorList {

    private final ArrayList<Doctor> doctors = new ArrayList<>();

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public boolean addDoctor(List<Doctor> list, Doctor doctor) {
        if ((findDoctorByCode(getDoctors(), doctor.getCode()) == null)) {
            return doctors.add(doctor);
        } else
            return false;

    }

    public Doctor findDoctorByCode(List<Doctor> list,String code) {
        for (Doctor doctor : list) {
            if (doctor.getCode().equals(code)) {
                return doctor;
            }
        } return null;
    }

    public boolean updateDoctor(Doctor doc, String newName, String newSpecialization, int newAvailability) {
        doc.setName(newName);
        doc.setSpecialization(newSpecialization);
        doc.setAvailability(newAvailability);
        return true;
    }

    public boolean deleteDoctor(List<Doctor> list, Doctor doctor) {
        if (doctor == null)
            return false;
        else return list.remove(doctor);
    }
    public String ViewAllDoctor(List<Doctor> list) {
        StringBuilder result = new StringBuilder();
        for (Doctor d : list) {
            result.append(d.toString()).append("\n");
        }
        return result.toString();
    }

}
