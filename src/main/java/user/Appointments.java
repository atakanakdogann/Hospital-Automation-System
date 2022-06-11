package main.java.user;

public class Appointments {
    private Doctor doctor;
    private Date date;
    private Patient patient;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    public Appointments(){

    }

    public Appointments(Patient patient, Doctor doctor, Date date) {
    }

    public Patient getPatient() {
        return patient;
    }

    public void putPatient(Patient newPatient){
        patient = newPatient;
    }

}
