package main.java.user;

import main.java.database.Database;

import java.util.Scanner;
import java.util.function.BiConsumer;

public class Admin extends User
{
    public Admin(String ID, String password, String name)
    {
        super(ID, password, name, User.userTypeAdmin);
    }

    public boolean addUser()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add User" + "\n");

        int userType = -1;
        try
        {
            System.out.print("User type (0.Admin, 1.Doctor, 2.Nurse): ");
            userType = scanner.nextInt();
            scanner.nextLine();
        }
        catch(Exception e)
        {
            userType = -1;
            scanner = new Scanner(System.in);
        }

        System.out.print("ID Number: ");
        String id = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        // Check the user type
        if(userType < 0 || userType > 2)
        {
            System.out.println("\nError: Wrong user type");
            return false;
        }

        // Add the user

        boolean result = true;

        if(userType == 0)
            result = Database.db.addUser(new Admin(id, password, name));
        else if(userType == 1){
            System.out.print("Proficiency: ");
            String proficiency = scanner.nextLine();
            result = Database.db.addUser(new Doctor(id, password, name, proficiency));
        }
        else if(userType == 2){
            System.out.print("Proficiency: ");
            String proficiency = scanner.nextLine();
            result = Database.db.addUser(new Nurse(id, password, name, proficiency));
        }
        if(result == false)
        {
            System.out.println("\nError: User already exists");
            return false;
        }

        return true;
    }

    public boolean removeUser()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Remove User" + "\n");

        System.out.print("ID Number: ");
        String id = scanner.nextLine();

        // Remove user

        if(id.equals(this.getUserID()))
            return false;

        return Database.db.removeUser(new User(id, "", "", ""));
    }

    public void displayEmployees()
    {
        Database.db.displayUsers();
    }

    public void displayPatients()
    {

    }

    public void setWorkDays()
    {
    }

    public void setNightShifts()
    {
    }

    public void assignForensic()
    {
    }

    public void getForensic()
    {
    }
}
