package main.java;


import main.java.database.Database;
import main.java.menu.MenuManager;

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
        // 1000 objects

        System.out.println("------------------- 1000 Entries ---------------------\n");

        fillDB(1000);

        System.out.println();

        // 10000 obejcts

        System.out.println("------------------- 10000 Entries --------------------\n");

        fillDB(10000);

        System.out.println();

        // 100000 obejcts

        System.out.println("------------------- 100000 Entries -------------------\n");

        fillDB(100000);

        System.out.println();

        // 1000000 obejcts

        System.out.println("------------------- 1000000 Entries ------------------\n");

        fillDB(1000000);

        System.out.println();

        System.out.println("------------------- 10000000 Entries -----------------\n");

        fillDB(10000000);

        System.out.println();
    }

    public static void fillDB(int count)
    {
        long firstTime = 0;
        long lastTime = 0;
        double deltaTimeSec = 0;

        String name = "TestEntry";

        System.out.println(" Insertion \n");

        // Users

        for (int i = 0; i < count; i++)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(i);

            if(i + 1 != count)
            {
                //Database.db.addUser(sb.toString());
            }
            else
            {
                firstTime = System.nanoTime();
                //Database.db.addUser(sb.toString());
                lastTime = System.nanoTime();
                deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
                System.out.println("Users        - BST               - add()       - Elapsed Time: " + deltaTimeSec + "s");
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
                Database.db.addAppointment(sb.toString());
            }
            else
            {
                firstTime = System.nanoTime();
                Database.db.addAppointment(sb.toString());
                lastTime = System.nanoTime();
                deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
                System.out.println("Appointments - Queue(LinkedList) - offerLast() - Elapsed Time: " + deltaTimeSec + "s");
            }
        }

        // Test Results

        for (int i = 0; i < count; i++)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(i);

            if(i + 1 != count)
            {
                Database.db.addTestResult(sb.toString());
            }
            else
            {
                firstTime = System.nanoTime();
                Database.db.addTestResult(sb.toString());
                lastTime = System.nanoTime();
                deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
                System.out.println("Test Results - PriorityQueue     - offer()     - Elapsed Time: " + deltaTimeSec + "s");
            }
        }

        // Night Shifts

        for (int i = 0; i < count; i++)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(i);

            if(i + 1 != count)
            {
                Database.db.addNightShift(sb.toString());
            }
            else
            {
                firstTime = System.nanoTime();
                Database.db.addNightShift(sb.toString());
                lastTime = System.nanoTime();
                deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
                System.out.println("Night Shifts - ArrayList         - add()       - Elapsed Time: " + deltaTimeSec + "s");
            }
        }

        System.out.println("\n Query (With non-existent entry) \n");

        firstTime = System.nanoTime();
        //Database.db.getUser("wrongentry");
        lastTime = System.nanoTime();
        deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
        System.out.println("Users        - BST               - get()       - Elapsed Time: " + deltaTimeSec + "s");

        firstTime = System.nanoTime();
        Database.db.getAppointment("wrongentry");
        lastTime = System.nanoTime();
        deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
        System.out.println("Appointments - Queue(LinkedList) - pollFirst() - Elapsed Time: " + deltaTimeSec + "s");

        firstTime = System.nanoTime();
        Database.db.getTestResult("wrongentry");
        lastTime = System.nanoTime();
        deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
        System.out.println("Test Results - PriorityQueue     - poll()      - Elapsed Time: " + deltaTimeSec + "s");

        firstTime = System.nanoTime();
        Database.db.getNightShift("wrongentry");
        lastTime = System.nanoTime();
        deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
        System.out.println("Night Shifts - ArrayList         - get()       - Elapsed Time: " + deltaTimeSec + "s");

        System.out.println("\n Removal \n");

        firstTime = System.nanoTime();
        //Database.db.removeUser("wrongentry");
        lastTime = System.nanoTime();
        deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
        System.out.println("Users        - BST               - remove()    - Elapsed Time: " + deltaTimeSec + "s");

        firstTime = System.nanoTime();
        Database.db.removeNightShift("wrongentry");
        lastTime = System.nanoTime();
        deltaTimeSec = (lastTime - firstTime) / 1000000000.0;
        System.out.println("Night Shifts - ArrayList         - remove()    - Elapsed Time: " + deltaTimeSec + "s");

    }
    */
}
