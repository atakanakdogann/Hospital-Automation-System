package main.java.database;

import main.java.datastructures.BinarySearchTree;
import main.java.user.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.function.BiConsumer;

public class Database
{
    public static Database db = new Database();

    private ArrayList<String> nightShiftList;
    private BinarySearchTree<User> userList;
    private PriorityQueue<String> testResultQueue;
    private LinkedList<String> appointmentQueue;

    public Database()
    {
        nightShiftList = new ArrayList<>();
        userList = new BinarySearchTree<>();
        testResultQueue = new PriorityQueue<>();
        appointmentQueue = new LinkedList<>();

        loadUserList();
        loadAppointmentQueue();
        loadNightShiftList();
        loadTestResultQueue();
    }

    public boolean addUser(User user)
    {
        return userList.add(user);
    }
    public User getUser(User user)
    {
        return userList.find(user);
    }
    public boolean removeUser(User user)
    {
        return userList.remove(user);
    }
    public void displayUsers()
    {
        System.out.println("ID  -  Name  -  Password  -  User Type\n");
        BiConsumer<User, Integer> displayEmployee = (a, b) ->
        {
            if(a != null)
                System.out.println(a.getUserID() + "  -  " + a.getUserName() + "  -  " + a.getUserPassword() + "  -  " + a.getUserType());
        };

        userList.preOrderTraverse(displayEmployee);
    }

    public boolean addAppointment(String patientId)
    {
        return appointmentQueue.offerLast(patientId);
    }
    public String getAppointment(String patientId)
    {
        return appointmentQueue.pollFirst();
    }

    public boolean addTestResult(String patientId)
    {
        return testResultQueue.offer(patientId);
    }
    public String getTestResult(String patientId)
    {
        return testResultQueue.poll();
    }

    public boolean addNightShift(String employeeId)
    {
        return nightShiftList.add(employeeId);
    }
    public String getNightShift(String employeeId)
    {
        for(int i = 0; i < nightShiftList.size(); i++)
        {
            if(employeeId.equals(nightShiftList.get(i)))
            {
                return nightShiftList.get(i);
            }
        }

        return null;
    }
    public boolean removeNightShift(String employeeId)
    {
        return nightShiftList.remove(employeeId);
    }

    private boolean loadUserList()
    {
        addUser(new Admin("a", "a" , "a"));
        addUser(new Doctor("d", "d" , "d"));
        addUser(new Nurse("n", "n" , "n"));
        addUser(new Patient("p", "p" , "p", 1, 1, 1, "A"));

        return true;
    }
    private boolean loadAppointmentQueue()
    {
        return true;
    }
    private boolean loadNightShiftList()
    {
        return true;
    }
    private boolean loadTestResultQueue()
    {
        return true;
    }
}
