package main.java.HelperClass;

import main.java.user.Doctor;
import main.java.user.Patient;

/**
 * the class which creates Medical Tests
 */
public class Examination {
    private Doctor doctor;
    private Patient patient;
    private String proficiency;
    private String testName;
    private String result;

    /**
     * constructor of the examination class
     * @param doctor the doctor which wants medical test
     * @param patient the patient which has an medical test
     * @param proficiency wanted Nurse proficiency for medical test
     * @param testName name of the medical test
     */
    public Examination(Doctor doctor, Patient patient, String proficiency, String testName){
        this.doctor = doctor;
        this.patient = patient;
        this.proficiency = proficiency;
        this.testName = testName;
    }

    /**
     * getter method for patient
     * @return the patient which has an medical test
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * getter method for proficiency
     * @return wanted Nurse proficiency for medical test
     */
    public String getProficiency() {
        return proficiency;
    }

    /**
     * getter method for test result
     * @return result of the medical test
     */
    public String getResult() {
        return result;
    }

    /**
     * getter method for test name
     * @return name of the medical test
     */
    public String getTestName() {
        return testName;
    }

    /**
     * getter method for doctor
     * @return the doctor which wants medical test
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * setter method to add test result
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * overridden toString method
     */
    public String toString(){
        String theString;
        theString = "" + testName;
        theString = theString + "\ndoctor: " + doctor.getUserName();
        theString = theString + "\npatient: " + patient;
        theString = theString + "\nresult: " + result;

        return theString;
    }
}
