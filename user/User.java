package user;

import java.util.Scanner;


/** Class for User objects.
 * @author Ozan Doruk Yavuz
 * @author Number:200104004077
 */
public class User{

    private String userID; // ID of the user that stored inside the user class.
    private String userPassword; // Password of the user that stored inside the user class.

    private boolean loginState; // State of the user. If true, it means user is logged in. If false, it means user is logged off.

    /** Constructor of the User with no parameters.
     *
     */
    public User(){

        Scanner scnr = new Scanner(System.in);

        System.out.println("\n Please enter the ID to create a new user:");

        String givenID = scnr.nextLine();

        System.out.println("\n Please enter the password of the new user:");

        String givenPass = scnr.nextLine();

        this.userID = givenID;

        this.userPassword = givenPass;

        this.loginState = false;

    }


    /** Constructor of the User with two parameters.
     * @param ID Identification number of the created user.
     * @param pass Password of the created user.
     */
    public User(String ID, String pass){

        this.userID = ID;

        this.userPassword = pass;

        this.loginState = false;

    }


    /** Login function that compares the ID and password and changes the state to logged in if both of them is true.
     *
     */
    public void systemLogin(){

        if(!loginState){ // If user is not loggined in.

            boolean checkID = false;
            boolean checkPass = false;

            Scanner scnr = new Scanner(System.in);

            System.out.println("\n Please enter the ID:");

            String givenID = scnr.nextLine();

            System.out.println("\n Please enter the password:");

            String givenPass = scnr.nextLine();

            if( givenID.equals(userID) ){

                checkID = true;

            }

            if( givenPass.equals(userPassword) ){

                checkPass = true;

            }

            if(!checkID){ // If ID is false.

                System.out.println("\n This ID is false for this user.");

            }else if(!checkPass){ // If ID is true but password is false.

                System.out.println("\n This password is false for this user.");

            }else if(checkID && checkPass){

                System.out.println("\n User loggined in successfully.");

                this.loginState = true;

            }



        }else{ // If user already loggined jn.

            System.out.println("\n User is already logined in.");

        }


    }


    /** Log out function that directly makes the state false when it is already not logged off.
     *
     */
    public void systemLogout(){

        if(loginState){

            System.out.println("\n User successfully logged out from system.");

            this.loginState = false;

        }else{

            System.out.println("\n User is already logged out from system.");

        }

    }


    /** Function that shows the information of the User when state is logged in.
     *
     */
    public void seeMenu(){

        if(loginState){

            System.out.println("\n Menu for the user with ID number: " + userID);

        }

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

    /** toString method that converts the User to String and shows the state of the User.
     *
     */
    public String toString(){

        if(loginState){

            return "\nThis is a User with the state: Logged in.";

        }

        return "\nThis is a User with the state: Logged out.";

    }


}

