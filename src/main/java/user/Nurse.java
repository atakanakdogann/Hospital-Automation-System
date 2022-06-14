package main.java.user;

import main.java.HelperClass.Examination;
import main.java.database.Database;
import java.util.Scanner;

/**
 * Nurse class
 */
public class Nurse extends Employee
{
    /**
     * Creates a Nurse object with the given ID, password and name
     * @param ID National identity of the nurse
     * @param pass Password of the nurse
     * @param name Name of the nurse
     * @param proficiency medical proficiency of the nurse
     */
    public Nurse(String ID, String pass, String name, String proficiency)
    {
        super(ID, pass, name, User.userTypeNurse, proficiency);
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
     * search the test and enter
     */
    public void testPatient()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if(patient == null){
            System.err.println("patient could not found");
        } else {
            System.out.println(getProficiency() + " tests that need to be done: ");
            for (var element : patient.testResults) {
                if(element.getProficiency().equals(this.getProficiency()) && element.getResult() == null){
                    System.out.println(element.getTestName());
                    System.out.println(element.getTestName() + "result: ");
                    String result = input.next();
                    element.setResult(result);
                    testPatient(element, result);
                }
            }
        }
    }

    /**
     * Returns a string representation of the tests for the patient
     */
    public void viewTestsToBeDone()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter patient ID: ");
        String patientID = input.next();
        Patient patient = findPatient(patientID);
        if(patient == null){
            System.err.println("patient could not found");
        } else {
            System.out.println(getProficiency() + " tests that need to be done: ");
            for (var element : patient.testResults) {
                if(element.getProficiency().equals(this.getProficiency()) && element.getResult() == null){
                    System.out.println(element.getTestName());
                }
            }
        }

    }

    /**
     * Executes test phases and assigns the test results to the patient
     * @param medicalTest current test
     * @param result current test's result
     */
    public void testPatient(Examination medicalTest, String result)
    {
        medicalTest.setResult(result);
    }
}