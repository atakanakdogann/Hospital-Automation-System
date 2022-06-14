package main.java;


import main.java.database.Database;
import main.java.datastructures.Edge;
import main.java.menu.MenuManager;
import main.java.user.*;
import main.java.user.Date;

import java.util.*;
import java.util.function.BiConsumer;

public class Main
{
    public static void main(String[] args)
    {
        MenuManager menuManager = new MenuManager();
        menuManager.run();
    }
/*
    public static void test()
    {
        int count = 0;
        int increment = 5000;

        for(int i = 0; i < 6; i++)
        {
            count += increment;

            System.out.println("------------------- " + count + " Entries ---------------------\n");

            fillDB(increment);

            System.out.println();
        }

    }
*/
/*
    public static void fillDB(int count)
    {
        Database.db.initDB();
        Database.db.initGraph(count);

        long firstTime = 0;
        long lastTime = 0;
        double deltaTimeSec = 0;

        String name = "EmployeeTest";

        System.out.println(" Insertion \n");

        // Users

        for (int i = 0; i < count; i++)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(i);

            if(i + 1 != count)
            {
                Database.db.addEmployee(new Doctor("", "", "", ""));
            }
            else
            {
                firstTime = System.nanoTime();
                Database.db.addEmployee(new Doctor("", "", "", ""));
                lastTime = System.nanoTime();
                deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
                System.out.println("Employees - BST - addEmployee() - Elapsed Time: " + deltaTimeSec + "s");
            }
        }

        name = "PatientTest";

        for (int i = 0; i < count; i++)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(i);

            if(i + 1 != count)
            {
                Database.db.addPatient(new Patient("", "", "", 1, 1, 1, ""));
            }
            else
            {
                firstTime = System.nanoTime();
                Database.db.addPatient(new Patient("", "", "", 1, 1, 1, ""));
                lastTime = System.nanoTime();
                deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
                System.out.println("Patients - addPatient() - Elapsed Time: " + deltaTimeSec + "s");
            }
        }

        // Appointments

        for (int i = 0; i < count; i++)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(i);

            if(i + 1 != count)
            {
                Database.db.addAppointment(new Appointments(
                        new Patient("", "", "", 1, 1, 1, ""),
                        new Doctor("", "", "", ""),
                        new Date(i, i)));
            }
            else
            {
                firstTime = System.nanoTime();
                Database.db.addAppointment(new Appointments(
                        new Patient("", "", "", 1, 1, 1, ""),
                        new Doctor("", "", "", ""),
                        new Date(i, i)));

                lastTime = System.nanoTime();
                deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
                System.out.println("Appointments - addAppointment() - Elapsed Time: " + deltaTimeSec + "s");
            }
        }

        // Rooms

        firstTime = System.nanoTime();
        Database.db.assignRoom(new Patient("PatientTest1", "", "", 1,1,1,""));
        lastTime = System.nanoTime();
        deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
        System.out.println("Rooms - assignRoom() - Elapsed Time: " + deltaTimeSec + "s");

        System.out.println("\n Query (With non-existent entry) \n");

        firstTime = System.nanoTime();
        Database.db.getUser(new User("wrongentry", "", "", ""));
        lastTime = System.nanoTime();
        deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
        System.out.println("Users - getUser() - Elapsed Time: " + deltaTimeSec + "s");

        firstTime = System.nanoTime();
        Database.db.getEmployee(new User("wrongentry", "", "", ""));
        lastTime = System.nanoTime();
        deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
        System.out.println("Employees - getEmployee() - Elapsed Time: " + deltaTimeSec + "s");

        firstTime = System.nanoTime();
        Database.db.getPatient(new User("wrongentry", "", "", ""));
        lastTime = System.nanoTime();
        deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
        System.out.println("Patients - getPatient() - Elapsed Time: " + deltaTimeSec + "s");

        firstTime = System.nanoTime();
        Database.db.getAppointment(new Appointments(
                new Patient("wrongentry", "", "", 1, 1, 1, ""),
                new Doctor("wrongentry", "", "", ""),
                new Date(-1, -1)));

        lastTime = System.nanoTime();
        deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
        System.out.println("Appointments - getAppointments() - Elapsed Time: " + deltaTimeSec + "s");

        System.out.println("\n Removal \n");

        firstTime = System.nanoTime();
        Database.db.removeUser("wrongentry");
        lastTime = System.nanoTime();
        deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
        System.out.println("Users - removeUser() - Elapsed Time: " + deltaTimeSec + "s");

        firstTime = System.nanoTime();
        Database.db.removeAppointment(new Appointments(
                new Patient("wrongentry", "", "", 1, 1, 1, ""),
                new Doctor("wrongentry", "", "", ""),
                new Date(-1, -1)));

        lastTime = System.nanoTime();
        deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
        System.out.println("Appointments - removeAppointment() - Elapsed Time: " + deltaTimeSec + "s");
    }
*/
}
