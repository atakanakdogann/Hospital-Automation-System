 package main.java.user;

import main.java.HelperClass.Examination;
import main.java.HelperClass.PatientRoom;
import main.java.database.Database;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

 public class Patient extends User{
    private PatientRoom room;
    private int age;
    private int weight;
    private int height;
    private String bloodType;
    protected Queue<Appointments> appointments;
    private Appointments[] appointArray;
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
        history = history + "age: " + getAge();
        history = history + "\nweight: " + getWeight();
        history = history + "\nheight: " + getHeight();
        history = history + "\nblood type: " + getBloodType();

        return history;
    }
     public String getProfile(){
         String history = "";
         history = history + "name: " + this.getUserName();
         history = history + "age: " + getAge();
         history = history + "\nweight: " + getWeight();
         history = history + "\nheight: " + getHeight();
         history = history + "\nblood type: " + getBloodType();

         return history;
     }

    public void viewAppointments(){
        if (appointments.isEmpty()){
            System.out.println("\nYou don't have any Appointments.\n");
        } else {
            appointArray = appointments.toArray(new Appointments[0]);

            for (int i = 0; i < appointArray.length; i++){
                System.out.println("[" + i +"]: " + appointArray[i].getDoctor().getUserName() + " - Day:" + appointArray[i].getDate().getDay() + ", Hour:" + appointArray[i].getDate().getTime() );
            }
        }
    }
    public void addAppoinment(){

        // this part is not complated, where is appointment database? //

        listDoctorsAppointment();
        selectDoctor();
        selectDate();

        Database.db.addAppointment(this.getUserID());
    }

     public String listDoctorsAppointment() {
         String str = "";

         //  Empty Method

         return str;
     }
     public Doctor selectDoctor() {
         Doctor theSelectDoctor = new Doctor();

         //  Empty Method

         return theSelectDoctor;
     }

     public Date selectDate() {
         Date theSelectedDate = new Date();

         //  Empty Method

         return theSelectedDate;
     }

     public void deleteAppointment(){
        viewAppointments();
        if (!appointments.isEmpty()){
            System.out.println("Select a Appointment: ");
            Scanner scan = new Scanner(System.in);
            int selectIndex = scan.nextInt();
            if (selectIndex < 0 || selectIndex >= appointments.size()){
                System.out.println("Appointment Deleting is failed");
                return;
            }
            // this part is not complated, where is appointment database? //
            appointArray[selectIndex].putPatient(null);
            appointments.remove(appointArray[selectIndex]);
        }
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
            allPrescriptions = allPrescriptions + "\n" + prescription;
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
            allTestResults = allTestResults + "\n" +testResult.toString();
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
            allMedicineRequirements = allMedicineRequirements + medicineRequirement;
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
            allAllergies = allAllergies + allergie;
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
            allIllnesses = allIllnesses + illness;
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

     /**
      * doctor could add new appointment via this method
      * @param creation an appointment
      */
    public void addAppointment(Appointments creation) {
        appointments.offer(creation);
    }
}