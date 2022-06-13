package main.java.login;

import main.java.database.Database;
import main.java.user.Admin;
import main.java.user.Patient;
import main.java.user.User;

import java.util.Scanner;

public class Login
{
    private static User loggedinUser = null;

    public static void login()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Login" + "\n");

        System.out.print("ID Number: ");
        String id = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Check for the user

        User user = Database.db.getUser(new User(id, password, "", ""));

        if(user != null)
        {
            if(password.equals(user.getUserPassword()))
                loggedinUser = user;
            else
                loggedinUser = null;
        }

        if(loggedinUser == null)
            System.out.println("\nError: ID number or password is incorrect");
    }

    public static boolean register()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Register" + "\n");

        System.out.print("ID Number: ");
        String id = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        int age = 0;
        int weight = 0;
        int height = 0;
        String bloodType;


        try
        {
            System.out.print("Age: ");
            age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Weight: ");
            weight = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Height: ");
            height = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Blood Type: ");
            bloodType = scanner.nextLine();
        }
        catch(Exception e)
        {
            System.out.println("\nError: Invalid entry");
            return false;
        }

        // Check for the user

        if(Database.db.addPatient(new Patient(id, password, name, age, weight, height, bloodType)) == false)
        {
            System.out.println("\nError: User already exists");
            return false;
        }

        return true;
    }

    public static void logout()
    {
        loggedinUser = null;
    }

    public static User getLoggedinUser()
    {
        return loggedinUser;
    }
}