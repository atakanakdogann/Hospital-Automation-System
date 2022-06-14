package main.java.HelperClass;
import main.java.user.Patient;

public class PatientRoom {
    private int x;
    private int y;
    private Patient patient;

    /**
     * constructor of PatientRoom class
     * @param x x-axis location of room
     * @param y y-axis location of room
     * @param patient person staying in the room
     */
    public PatientRoom(int x, int y, Patient patient){
        this.x = x;
        this.y = y;
        this.patient = patient;
    }

    /**
     * getter method of x
     * @return int value of x-axis
     */
    public int getX() {
        return x;
    }

    /**
     * getter method of y
     * @return int value of y-axis
     */
    public int getY() {
        return y;
    }

    /**
     * getter method of patient
     * @return Patient member
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Setter method for patient
     * @param patient Patient
     */
    public void setPatient(Patient patient) { this.patient = patient; }
}
