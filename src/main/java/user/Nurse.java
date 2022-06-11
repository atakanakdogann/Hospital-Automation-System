package main.java.user;

import main.java.HelperClass.Examination;

import java.util.ArrayList;

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
     * Executes test phases and assigns the test results to the patient
     * @param medicalTest
     * @param result
     */
    public void testPatient(Examination medicalTest, String result)
    {
        medicalTest.setResult(result);
    }

    /**
     * Returns a string representation of the tests for the patient
     */
    public void viewTestsToBeDone()
    {

    }
}