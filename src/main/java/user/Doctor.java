package main.java.user;

import main.java.HelperClass.Examination;
import main.java.HelperClass.PatientRoom;
import main.java.database.Database;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

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
        Database.db.addAppointment(creation);
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
    public String getIllness(Patient patient){
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
    public void hospitalizePatient(Patient patient, int x, int y){
        PatientRoom patientRoom = new PatientRoom(x, y, patient);
        patient.setRoom(patientRoom);
    }

    private Patient findPatient(String patientID){
        User tempPatient = new User(patientID);
        Patient patient = (Patient) Database.db.getPatient(tempPatient);
        return patient;
    }

    public void createAppointment()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter day (0-6): ");
        int day = input.nextInt();
        System.out.println("enter time (0-9): ");
        int time = input.nextInt();
        System.out.println("enter patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("patient could not found");
        } else {
            Date date = new Date(day, time);
            Appointments appointment = new Appointments(patient, this, date);
            Database.db.addAppointment(appointment);
            patientAppointments.add(appointment);
            System.out.println("appointment created successfully");
        }
        input.close();
    }

    public void writePrescription()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("patient could not found");
        } else {
            System.out.println("prescription: ");
            String prescription = input.next();
            writePrescription(patient, prescription);
        }
        input.close();

    }

    public void viewPatientHistory()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("patient could not found");
        } else {
            System.out.println("patient history: " + patientHistory(patient));
        }
        input.close();
    }

    public void viewAllergies()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("patient could not found");
        } else {
            System.out.println("allergies: " + getAllergies(patient));
        }
        input.close();
    }

    public void addAllergies()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("patient could not found");
        } else {
            System.out.println("allergy: ");
            String allergy = input.next();
            setAllergy(patient, allergy);
        }
        input.close();
    }

    public void viewSymptoms()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("patient could not found");
        } else {
            System.out.println("symptoms: " + getSymptoms(patient));
        }
        input.close();
    }

    public void addSymptoms()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("patient could not found");
        } else {
            System.out.println("symptom: ");
            String symptom = input.next();
            setSymptoms(patient, symptom);
        }
        input.close();
    }

    public void viewIllness()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("patient could not found");
        } else {
            System.out.println("illnesses: " + getIllness(patient));
        }
        input.close();
    }

    public void addIllness()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("patient could not found");
        } else {
            System.out.println("illness: ");
            String illness = input.next();
            setIllness(patient, illness);
        }
        input.close();
    }

    public void enterTestResults()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("patient could not found");
        } else {
            System.out.println("proficiency: ");
            String proficiency = input.next();
            System.out.println("testName: ");
            String testName = input.next();
            createExamination(patient, proficiency, testName);
        }
        input.close();
    }

    public void hospitalizePatient()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("patient could not found");
        } else {
            System.out.println("room number: ");
            int x = input.nextInt();
            System.out.println("floor: ");
            int y = input.nextInt();
            hospitalizePatient(patient, x, y);
        }
        input.close();
    }
}
