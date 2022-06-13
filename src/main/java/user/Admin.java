package main.java.user;

import main.java.database.Database;

import java.util.Scanner;

public class Admin extends Employee
{
   // Constructor.
    public Admin(String ID, String password, String name)
    {
        super(ID, password, name, userTypeAdmin, proAdmin);
    }


    // Adding an employee to the database.
    public boolean addEmployee()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add Employee" + "\n");

        int employeeType = -1;
        try
        {
            System.out.print("Employee type (0.Admin, 1.Doctor, 2.Nurse): ");
            employeeType = scanner.nextInt();
            scanner.nextLine();
        }
        catch(Exception e)
        {
            employeeType = -1;
            scanner = new Scanner(System.in);
        }

        System.out.print("ID Number: ");
        String id = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        // Check the Employee type
        if(employeeType < 0 || employeeType > 2)
        {
            System.out.println("\nError: Wrong employee type");
            return false;
        }

        // Add the Employee

        boolean result = true;
        String proficiency = "";

        if (employeeType == 1 || employeeType == 2){
            int prof = -1;
            try
            {
                System.out.print("\nProficiency types:\n0.Radiolog\n1.Internist\n2.Neurolog\n3.Surgeon\n");
                System.out.print("Selection: ");
                prof = scanner.nextInt();
                scanner.nextLine();
            }
            catch(Exception e)
            {
                prof = -1;
                scanner = new Scanner(System.in);
            }
            switch (prof) {
                case 0:
                    proficiency = proRadiolog;
                    break;

                case 1:
                    proficiency = proInternist;
                    break;
                case 2:
                    proficiency = proNeorolog;
                    break;
                case 3:
                    proficiency = proSurgeon;
                    break;
            
                default:
                    proficiency = proRadiolog;
                    break;
            }

        }

        if(employeeType == 0)
            result = Database.db.addEmployee(new Admin(id, password, name));

        else if(employeeType == 1){
            
            result = Database.db.addEmployee(new Doctor(id, password, name, proficiency));
        }
        else if(employeeType == 2){

            result = Database.db.addEmployee(new Nurse(id, password, name, proficiency));
        }
        if(result == false)
        {
            System.out.println("\nError: This employee already exists");
            return false;
        }

        return true;
    }

   // Removing a user from the database.
    public boolean removeUser()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Remove User" + "\n");

        System.out.print("ID Number: ");
        String id = scanner.nextLine();

        // Remove user

        if(id.equals(this.getUserID()))
            return false;

        return Database.db.removeUser(new User(id).getUserID());
    }

    public void displayEmployees()
    {
        Database.db.displayEmployees();
    }

    public void displayPatients()
    {
        Database.db.displayPatients();
    }

    public void setWorkDays()
    {
        Scanner scanner = new Scanner(System.in);
        displayEmployees();
        System.out.print("\nEnter the id number of the employee: ");
        String id = scanner.nextLine();

        var emp = Database.db.getEmployee(new User(id, "", "", ""));
        Employee _emp = (Employee) emp;

        System.out.println("\n1.Add a working day\n2.Delete a working day(turn into a rest day.)");
        System.out.print("Selection: ");

        int selection = scanner.nextInt();

        System.out.print("\nday(1 to 7, 1 is monday): ");
        int _day = scanner.nextInt();

        switch (selection) {
            case 1:
                _emp.setWorkingDay(true, _day);
                break;
            case 2:
                _emp.setWorkingDay(false, _day);
                break;
        
            default:
                break;
        }
    }

    public void setNightShifts()
    {
        Scanner scanner = new Scanner(System.in);
        displayEmployees();
        System.out.print("\nEnter the id number of the employee: ");
        String id = scanner.nextLine();

        var emp = Database.db.getEmployee(new User(id));
        Employee _emp = (Employee) emp;

        System.out.println("\n1.Add a night shift\n2.Delete a night shift");
        System.out.print("Selection: ");

        int selection = scanner.nextInt();

        System.out.print("\nday(1 to 7, 1 is monday): ");
        int _day = scanner.nextInt();

        switch (selection) {
            case 1:
                _emp.setNightShift(true, _day);
                break;
            case 2:
                _emp.setNightShift(false, _day);
                break;
        
            default:
                break;
        }
    }

    public void assignForensic()
    {
        Scanner scanner = new Scanner(System.in);
        displayEmployees();
        System.out.print("\nEnter the id number of the employee: ");
        String id = scanner.nextLine();

        var emp = Database.db.getEmployee(new User(id));
        Employee _emp = (Employee) emp;

        System.out.println("\nAdd new case:");

        String newCase = scanner.nextLine();
        _emp.addForensicCase(newCase);
    }

    public void getForensic()
    {
        Scanner scanner = new Scanner(System.in);
        displayEmployees();
        System.out.print("\nEnter the id number of the employee: ");
        String id = scanner.nextLine();

        var emp = Database.db.getEmployee(new User(id));
        Employee _emp = (Employee) emp;

        _emp.viewForensicCases();
    }
}
