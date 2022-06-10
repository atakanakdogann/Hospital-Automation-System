package main.java.user;

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
     */
    public Nurse(String ID, String pass, String name)
    {
        super(ID, pass, name, User.userTypeNurse);
    }

    /**
     * Executes test phases and assigns the test results to the patient
     */
    public void testPatient()
    {

    }

    /**
     * Returns a string representation of the tests for the patient
     */
    public void viewTestsToBeDone()
    {

    }
}