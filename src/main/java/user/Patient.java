 package main.java.user;

import main.java.HelperClass.Examination;
import main.java.HelperClass.PatientRoom;
import main.java.database.Database;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

 public class Patient extends User{
    private PatientRoom room;
    private int age;
    private int weight;
    private int height;
    private String bloodType;
    protected ArrayList<Appointments> appointArray;
    protected Queue<String> symptoms;
    protected ArrayList<String> prescriptions = new ArrayList<>();
    protected ArrayList<Examination> testResults = new ArrayList<>();
    protected ArrayList<String> medicineRequirements = new ArrayList<>();
    protected ArrayList<String> allergies = new ArrayList<>();
    protected ArrayList<String> illnesses = new ArrayList<>();

    public Patient(String id, String password, String name, int age, int weight, int height, String bloodType) {
        super(id, password, name, User.userTypePatient);
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.bloodType = bloodType;
    }

    /**
     * this method assign a hospital room for patient
     * only a doctor could be assign a room for patient
     * @param room
     */
    public void setRoom(PatientRoom room) {
        this.room = room;
    }

     public Queue<String> getSymptoms() {
         return symptoms;
     }

     public void putAge(int theAge) {
        age = theAge;
    }

    public int getAge() {
        return age;
    }

    public void putWeight(int theWeight) {
        weight = theWeight;
    }

    public int getWeight() {
        return weight;
    }

    public void putHeight(int theHeight) {
        height = theHeight;
    }

    public int getHeight() {
        return height;
    }

    public void putBloodType(String theBloodType) {
        bloodType = theBloodType;
    }

    public String getBloodType() {
        return bloodType;
    }

     /**
      * method to get medical history of patient
      * @return patient's informations as a string
      */
    public String getMedicalHistory(){
        String history = new String();
        history = history + "\nAge: " + getAge();
        history = history + "\nWeight: " + getWeight();
        history = history + "\nHeight: " + getHeight();
        history = history + "\nBlood Type: " + getBloodType();
        history = history + "\nAlergies: \n" + getAllergies();
        history = history + "\nIllness: \n" + getIllness();
        history = history + "\nPrescriptions: \n" + getPrescriptions();
        history = history + "\nTest Results: \n" + getTestResult();
        history = history + "\nMedicine Requirements: \n" + getMedicineRequirements();
        return history;
    }
     public String getProfile(){
         String history = "";
         history = history + "Name: " + this.getUserName();
         history = history + "age: " + getAge();
         history = history + "\nWeight: " + getWeight();
         history = history + "\nHeight: " + getHeight();
         history = history + "\nBlood Type: " + getBloodType();

         return history;
     }

    public void viewAppointments() {
        loadAppointment();
        if (appointArray.isEmpty()) {
            System.out.println("\nYou don't have any Appointments.\n");
        } else {
            for (int i = 0; i < appointArray.size(); i++) {
                System.out.println("[" + i + "]: " + appointArray.get(i).getDoctor().getUserName() + " - Day:" + appointArray.get(i).getDate().getDay() + ", Hour:" + appointArray.get(i).getDate().getTime());
            }
        }
    }
    public void addAppointment(){
        int selectIndex;
        Doctor selectedDoctor;
        Scanner scan = new Scanner(System.in);
        /* Get no patient appointments */
        ArrayList<Appointments> freeAppointments = Database.db.getAppointment((Patient) null);
        /* Get doctors who have an empty appointment */
        ArrayList<Doctor> doctors = new ArrayList<>();
        for (Appointments freeAppointment : freeAppointments) {
            if (!doctors.contains(freeAppointment.getDoctor())) {
                doctors.add(freeAppointment.getDoctor());
            }
        }
        /* Select doctor */
        for (int i = 0; i < doctors.size(); i++){
            System.out.println("[" + i +"]: " + doctors.get(i).getUserName());
        }
        System.out.print("\nSelect a doctor: ");
        selectIndex = scan.nextInt();
        if(selectIndex >= 0 && selectIndex < doctors.size()) {
            selectedDoctor = doctors.get(selectIndex);
            for (int i = 0; i < freeAppointments.size(); i++) {
                if (selectedDoctor.equals(freeAppointments.get(i).getDoctor())) {
                    System.out.println("[" + i + "]: " + freeAppointments.get(i).getDoctor().getUserName() + " - Day:" + freeAppointments.get(i).getDate().getDay() + ", Hour:" + freeAppointments.get(i).getDate().getTime());
                }
            }
            /* Select Appointment that the selected doctor has */
            System.out.print("\nSelect a date: ");
            selectIndex = scan.nextInt();
            if (selectIndex >= 0 && selectIndex < freeAppointments.size()) {
                freeAppointments.get(selectIndex).setPatient(this);
                System.out.println("\nAppointment created successfully.");
            } else {
                System.out.println("\nFailed to create appointment.");
            }
        } else {
            System.out.println("\nFailed to create appointment.");
        }
    }
     public void deleteAppointment(){
        viewAppointments();
        if (!appointArray.isEmpty()){
            System.out.print("Select a Appointment: ");
            Scanner scan = new Scanner(System.in);
            int selectIndex = scan.nextInt();
            if (selectIndex > 0 && selectIndex < appointArray.size()){
                Appointments deletedAppointment = Database.db.getAppointment(appointArray.get(selectIndex));
                deletedAppointment.setPatient((Patient)null);
                System.out.println("\nAppointment deleted successfully.");
            } else {
                System.out.println("\nAppointment Deleting is failed");
            }
        } else {
            System.out.println("\nYou have not any appointment");
        }
    }

     /**
      * Load appointments of the patient
      */
    private void loadAppointment(){
        appointArray = Database.db.getAppointment(this);
    }
    public void viewInformation(){
        String infMenu;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("\n-Patient Information-\n");
            System.out.println("(1): Profile");
            System.out.println("(2): View Prescriptions");
            System.out.println("(3): View Allergies");
            System.out.println("(4): View Test Results");
            System.out.println("(5): View Medicine Requirements");

            System.out.println("(O) Exit");
            /*
             * get a string from user for controlling menu
             */
            infMenu = scan.next();

            if (infMenu.equals("1")) {

                System.out.println("-Profile-\n" + getProfile());
                return;

            } else if (infMenu.equals("2")) {

                System.out.println("-Prescriptions-\n" + getPrescriptions());
                return;

            } else if (infMenu.equals("3")) {

                System.out.println("-Allergies-\n" + getAllergies());
                return;

            } else if (infMenu.equals("4")) {

                System.out.println("-Test Results-\n" + getTestResult());
                return;

            } else if (infMenu.equals("5")) {

                System.out.println("-Medicine Requirements-\n" + getMedicineRequirements());
                return;

            } else if (infMenu.equals("0")) {
                return;                                    // end the viewInformation method

            } else {
                System.out.println("\nWrong character entered, please try again.");

            }
        } while (true);
    }
    public String getPrescriptions() {
        String allPrescriptions = "";
        for (String prescription : prescriptions) {
            allPrescriptions = allPrescriptions + prescription  + "\n";
        }
        return allPrescriptions;
    }
     /**
      * Get all test results of the patient
      * @return all test results
      */
    public String getTestResult() {
           String allTestResults = "";
        for (Examination testResult : testResults) {
            allTestResults = allTestResults + testResult.toString() + "\n";
        }
            return allTestResults;
        }

     /**
      * Get all medicine requirements of the patient
      * @return all medicine requirements
      */
     public String getMedicineRequirements() {
        String allMedicineRequirements = "";
        for (String medicineRequirement : medicineRequirements) {
            allMedicineRequirements = allMedicineRequirements + medicineRequirement + "\n";
        }
        return allMedicineRequirements;
    }

     /**
      * Get all allergies of the patient
      * @return all allergies
      */
    public String getAllergies() {
        String allAllergies = "";
        for (String allergie : allergies) {
            allAllergies = allAllergies + allergie + "\n";
        }
        return allAllergies;
    }

     /**
      * Get Illnes list of the patient
      * @return ArrayList of illness
      */
    public String getIllness() {
        String allIllnesses = "";
        for (String illness : illnesses) {
            allIllnesses = allIllnesses + illness + "\n";
        }
        return allIllnesses;
    }

     /**
      * Add  a illness on illnesses of the patient
      * @param illness a illness
      */
    public void addIllness(String illness) {
        illnesses.add(illness);
    }

     /**
      * Add a symptom on symptons
      * @param symptom
      */
    public void addSymptom(String symptom) {
        symptoms.add(symptom);
    }
}