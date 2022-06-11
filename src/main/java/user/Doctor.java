package main.java.user;

import main.java.HelperClass.Examination;
import main.java.HelperClass.PatientRoom;

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

    /**
     * Creates a Doctor object with the given ID, password and name
     * @param id National identity of the doctor
     * @param password Password of the doctor
     * @param name Name of the doctor
     * @param proficiency medical proficiency of the doctor
     */
    public Doctor(String id, String password, String name, String proficiency){
        super(id, password, name, User.userTypeDoctor, proficiency);
    }

    /**
     * creates appointment for given patient at given date
     * @param patient
     * @param date
     */
    public void createAppointment(Patient patient, Date date){
        Appointments creation = new Appointments(patient, this, date);
        patientAppointments.add(creation);
        patient.addAppointment(creation);
    }

    /**
     * create medical test for given patient
     * @param patient
     * @param proficiency
     * @param testName
     */
    public void createExamination(Patient patient, String proficiency, String testName){
        patient.testResults.add(new Examination(this, patient, proficiency, testName));
    }

    /**
     *
     * @param patient
     * @param prescription
     */
    public void writePrescription(Patient patient, String prescription){
        patient.prescriptions.add(prescription);
    }

    /**
     * medical informations of given patient
     * @param patient
     * @return string format of history
     */
    public String patientHistory(Patient patient){
        return patient.getMedicalHistory();
    }

    /**
     * add new symptom for patient
     * @param patient
     * @param symptom
     */
    public void setSymptoms(Patient patient, String symptom){
        patient.addSymptom(symptom);
    }

    /**
     * get symptoms of the patient
     * @param patient
     * @return
     */
    public Queue<String> getSymptoms(Patient patient){
        return patient.getSymptoms();
    }

    /**
     * set illness of the patient
     * @param patient
     * @param illness
     */
    public void setIllness(Patient patient, String illness){
        patient.addIllness(illness);
    }

    /**
     * getter method for patient's illnesses
     * @param patient
     * @return
     */
    public ArrayList<String> getIllness(Patient patient){
        return patient.getIllness();
    }

    /**
     * add allergy to the patient
     * @param patient
     * @param allergy
     */
    public void setAllergy(Patient patient, String allergy){
        //could change according to implementation of patient class
        patient.allergies.add(allergy);
    }

    /**
     * get allergies of the patient
     * @param patient
     * @return
     */
    public ArrayList<String> getAllergies(Patient patient){
        //could change according to implementation of patient class
        return patient.allergies;
    }

    /**
     * give a room at given location to hospitalize patient
     * @param patient patient to hospitalize
     * @param x x-axis location
     * @param y y-axis location
     */
    public void hospitalizePatient(Patient patient, double x, double y){
        PatientRoom patientRoom = new PatientRoom(x, y, patient);
    }
}
