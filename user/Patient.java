package user;

import java.util.ArrayList;

class Patient extends User{

    private int id;
    private String name;
    private int age;
    private int weight;
    private int height;
    private String bloodType;
    private ArrayList<String> prescriptions = new ArrayList<String>();
    private ArrayList<String> testResults = new ArrayList<String>();
    private ArrayList<String> medicineRequirements = new ArrayList<String>();
    private ArrayList<String> allergies = new ArrayList<String>();
    private ArrayList<String> illnesses = new ArrayList<String>();

    Patient(int theId, String theName, int theAge, int theWeight, int theHeight, String theBloodType) {
        id = theId;
        name = theName;
        age = theAge;
        weight = theWeight;
        height = theHeight;
        bloodType = theBloodType;
    }

    public void putId(int theId) {
        id = theId;
    }

    public int getId() {
        return id;
    }

    public void putAge(int theAge) {
        age = theAge;
    }

    public int getAge() {
        return age;
    }

    public void putName(String theName) {
        name = theName;
    }

    public String getName() {
        return name;
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

    public boolean addAppointment(Appointments newAppointment) {
        Date selectedDate = newAppointment.getDate();
        Doctor selectedDoctor = newAppointment.getDoctor();
        Appointments selectedAppointment = findFreeAppointment(selectedDate, selectedDoctor);
        if (selectedAppointment.getPatient() == null) {
            return true;
        } else {
            return false;
        }
    }
    public Appointments findFreeAppointment(Date selectedDate, Doctor selectedDoctor) {
        return (HospitalSystem.appointmentData[0]);
    }
    public boolean deleteAppointment(Appointments selectedAppointment) {
        if (selectedAppointment.getPatient() == this) {
            selectedAppointment.putPatient(null);
            return true;
        } else {
            return false;
        }
    }

    public String listDoctorsAppointment() {
        String str = "";

        //  Empty Method

        return str;
    }

    public Date selectDate() {
        Date theSelectedDate = new Date();

        //  Empty Method

        return theSelectedDate;
    }

    public Doctor selectDoctor() {
        Doctor theSelectDoctor = new Doctor();

        //  Empty Method

        return theSelectDoctor;
    }

    public String listMyAppoinments() {
        String str = "";

        //  Empty Method

        return str;
    }

    public String listAppointments() {
        String str = "";

        //  Empty Method

        return str;
    }

    public String getPrescriptions() {
        String str = "";

        // prescriptions[];
        // Empty Method
        return str;
    }

    public String getTestResult() {
        String str = "";

        // testResults[];
        // Empty Method

        return str;
    }

    public String getMedicineRequirements() {
        String str = "";

        // medicineRequirements;
        //  Empty Method

        return str;
    }

    public String getAllergies() {
        String str = "";

        // allergies[];
        //  Empty Method

        return str;
    }

    public String getIllness() {
        String str = "";

        // illnesses[];
        //  Empty Method

        return str;
    }
    public void addIllness(String illness) {
    }

    public void addSymptom(String symptom) {
    }


}