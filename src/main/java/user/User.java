package main.java.user;

import java.util.Scanner;


/** Class for User objects.
 * @author Ozan Doruk Yavuz
 * @author Number:200104004077
 */
public class User implements Comparable<User>
{
    private String userType;
    private String userID; // ID of the user that stored inside the user class.
    private String userPassword; // Password of the user that stored inside the user class.
    private String userName;

    public final static String userTypeAdmin = "Admin";
    public final static String userTypePatient = "Patient";
    public final static String userTypeDoctor = "Doctor";
    public final static String userTypeNurse = "Nurse";

    public User()
    {
    }

    /** Constructor of the User with no parameters.
     *
     */
    public User(String userID, String userPassword, String userName, String userType)
    {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userType = userType;
        this.userName = userName;
    }

    public String getUserType()
    {
        return userType;
    }

    public String getUserID()
    {
        return userID;
    }

    public String getUserPassword()
    {
        return userPassword;
    }

    public String getUserName()
    {
        return userName;
    }

    /** Function that compares the User with the given object.
     *
     * @param obj Given object to compare.
     */
    public boolean equals(Object obj){

        // If we are comparing same object with itself.
        if(obj == this){

            return true;
        }

        // If object is not a user type.
        if( !(obj instanceof User) ){

            return false;
        }

        // downcasting to compare IDs.
        User temp = (User) obj;

        // If they have same ID,
        if( temp.userID.equals(this.userID) ){

            return true;
        }

        // If they do not have same ID,
        return false;
    }

    @Override
    public int compareTo(User o)
    {
        return userID.compareTo(o.userID);
    }
}

