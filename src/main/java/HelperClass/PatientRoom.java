package main.java.HelperClass;
import main.java.user.Patient;

public class PatientRoom {
    private double x;
    private double y;
    private Patient patient;

    /**
     * constructor of PatientRoom class
     * @param x x-axis location of room
     * @param y y-axis location of room
     * @param patient person staying in the room
     */
    public PatientRoom(double x, double y, Patient patient){
        this.x = x;
        this.y = y;
        this.patient = patient;
    }

    /**
     * getter method of x
     * @return double value of x-axis
     */
    public double getX() {
        return x;
    }

    /**
     * getter method of y
     * @return double value of y-axis
     */
    public double getY() {
        return y;
    }

    /**
     * getter method of patient
     * @return Patient member
     */
    public Patient getPatient() {
        return patient;
    }
}
