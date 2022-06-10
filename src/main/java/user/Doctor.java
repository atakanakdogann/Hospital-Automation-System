package main.java.user;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;

public class Doctor extends Employee{
    /**
     * Sees the patient appointments
     * Writes prescriptions
     * Enters the patient information(complaints, symptoms, patient's illnesses, test results) to the system
     * Decides whether the patient is going to stay in hospital or not
     * Sees the appointment and the examination history of the patients
     * (n) Sees his/her night shifts
     * (n) Sees his/her working times
     * (n) Sees his/her forensic cases if there is any
     */

    /**
     * Queue structure which keeps the doctor's appointments with patients
     */
    private Queue<Appointments> patientAppointments;

    public Doctor(){

    }
    public Doctor(String id, String password, String name){
        super(id, password, name, User.userTypeDoctor);
    }

    public void createAppointment(Patient patient, Date date){
        Appointments creation = new Appointments(patient, this, date);
        patientAppointments.add(creation);
       // patient.addAppointment(creation);
    }

    public void writePrescription(Patient patient){
        //setPrescription
    }

    public String patientHistory(Patient patient){
        //return patient.getMedicalHistory();
        return new String();
    }

    public void setSymptoms(Patient patient, String symptom){
        patient.addSymptom(symptom);
    }

    public String[] getSymptoms(Patient patient){
        return new String[3];
    }

    public void setIllness(Patient patient, String illness){
        patient.addIllness(illness);
    }

    public ArrayList<String> getIllness(Patient patient){
        return new ArrayList<>();
    }

    public void setAllergy(Patient patient, String allergy){
        //
    }

    public ArrayList<String> getAllergies(Patient patient){
        return new ArrayList<>();
    }
}
