package main.java.user;

import main.java.HelperClass.Examination;
import main.java.HelperClass.PatientRoom;
import main.java.database.Database;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import javax.xml.crypto.Data;

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
    private Queue<Appointments> patientAppointments = new LinkedList<>();

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
        Appointments appointment = new Appointments(patient, this, date);
        if(Database.db.getAppointment(appointment) == null){
            Database.db.addAppointment(appointment);
            patient.appointArray.add(appointment);
            patientAppointments.add(appointment);
            System.out.println("Appointment created successfully.");
        } else {
            System.out.println("Appointment at given parameters is not suitable ! ! !");
        }
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
     */
    public void hospitalizePatient(Patient patient){
        if(patient == null)
            return;

        PatientRoom room = Database.db.assignRoom(patient);

        if(room == null)
        {
            System.out.println("Error: There is no available room currently");
            return;
        }

        if(patient.getRoom() != null)
        {
            System.out.println("Error: Patient is already hospitalized");
            return;
        }

        patient.setRoom(room);

        System.out.println("Patient " + patient.getUserID() + " is assigned to a room. Floor: " + room.getY() + " Number: " + room.getX());
    }

    /**
     * find patient with given patientID then return it
     * @param patientID patient's national identity number
     * @return the found patient
     */
    private Patient findPatient(String patientID){
        User tempPatient = new User(patientID);
        Patient patient = (Patient) Database.db.getPatient(tempPatient);
        return patient;
    }

    /**
     * create an appointment with the found patient
     */
    public void createAppointment()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Day (0-6): ");
        int day = input.nextInt();
        System.out.println("Enter Time (0-9): ");
        int time = input.nextInt();
        System.out.println("Enter Patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("Patient could not found ! ! !");
        } else {
            Date date = new Date(day, time);
            createAppointment(patient, date);
        }
    }

    /**
     * write a prescription to the found patient
     */
    public void writePrescription()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("Patient could not found ! ! !");
        } else {
            input.nextLine();
            System.out.println("Prescription: ");
            String prescription = input.nextLine();
            
            writePrescription(patient, prescription);
        }

    }

    /**
     * display patient's medical history on the console
     */
    public void viewPatientHistory()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("Patient could not found ! ! !");
        } else {
            System.out.println("Patient History: " + patientHistory(patient));
        }
    }

    /**
     * display patient's allergies on the console
     */
    public void viewAllergies()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("Patient could not found ! ! !");
        } else {
            System.out.println("Allergies: " + getAllergies(patient));
        }
    }

    /**
     * add new allergy information to the patient 
     */
    public void addAllergies()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("Patient could not found ! ! !");
        } else {
            input.nextLine();
            System.out.println("Allergy: ");
            String allergy = input.nextLine();

            setAllergy(patient, allergy);
        }
    }

    /**
     * display patient's symptoms on the console
     */
    public void viewSymptoms()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("Patient could not found ! ! !");
        } else {
            System.out.println("Symptoms: " + getSymptoms(patient));
        }
    }

    /**
     * add a new symptom to the patient
     */
    public void addSymptoms()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("Patient could not found ! ! !");
        } else {
            input.nextLine();
            System.out.println("Symptom: ");
            String symptom = input.nextLine();

            setSymptoms(patient, symptom);
        }
    }

    /**
     * display illnesses of patient's on the console
     */
    public void viewIllness()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("Patient could not found ! ! !");
        } else {
            System.out.println("Illnesses: " + getIllness(patient));
        }
    }

    /**
     * add new illness to the patient
     */
    public void addIllness()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("Patient could not found ! ! !");
        } else {
            input.nextLine();
            System.out.println("Illness: ");
            String illness = input.nextLine();

            setIllness(patient, illness);
        }
    }

    /**
     * create examination for patient
     */
    public void enterTestResults()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("Patient could not found ! ! !");
        } else {
            System.out.println("Proficiency: ");
            String proficiency = input.next();
            System.out.println("TestName: ");
            String testName = input.next();
            createExamination(patient, proficiency, testName);
        }
    }

    /**
     * hospitalize patient to the hospital with floor and room number entries
     */
    public void hospitalizePatient()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if( patient == null){
            System.err.println("Patient could not found ! ! !");
        } else {
            hospitalizePatient(patient);
        }
    }

            /**
     * overridden toString method
     */
    public String toString(){
        String theString;
        theString = "\nName:" + getUserName();
        theString = theString + "\nProficiency: " + getProficiency();

        return theString;
    }
}
