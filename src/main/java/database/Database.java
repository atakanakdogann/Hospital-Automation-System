package main.java.database;

import main.java.datastructures.AVLTree;
import main.java.datastructures.BinarySearchTree;
import main.java.datastructures.KWLinkedList;
import main.java.datastructures.SkipListJava;

import main.java.user.*;

import java.util.*;
import java.util.function.BiConsumer;

public class Database
{
    public static Database db = new Database();

    private BinarySearchTree<User> employees;
    private AVLTree<User> patients;
    private KWLinkedList<Appointments> appointments;
    private HashMap<String, ArrayList<Nurse>> nurses;

    public Database()
    {
        employees = new BinarySearchTree<>();
        patients = new AVLTree<>();
        appointments = new KWLinkedList<>();
        nurses = new HashMap<>();

        loadUserList();
    }

    /**
     * Checks if the given user exists in the system
     * @param user User to be searched for
     * @return Returns the user object if the user already exists in the system or null otherwise
     */
    public User getUser(User user)
    {
        User foundUser = null;

        if((foundUser = employees.find(user)) != null)
            return foundUser;

        return patients.find(user);
    }

    /**
     * Adds an employee to the system
     * @param user User object to be added
     * @return Returns true if the user with the given id doesn't exist in the system or false otherwise
     */
    public boolean addEmployee(User user)
    {
        if(getUser(user) != null)
            return false;

        if(employees.add(user))
        {
            // If the employee is a nurse, put the nurse in the hashmap
            if(user instanceof Nurse)
            {
                Nurse nurse = (Nurse) user;

                // Check if the proficiency has an array list of nurses. If not create it.
                if(nurses.get(nurse.getProficiency()) == null)
                    nurses.put(nurse.getProficiency(), new ArrayList<Nurse>());

                // Add the nurse
                nurses.get(nurse.getProficiency()).add(nurse);
            }

            return true;
        }

        return false;
    }

    /**
     * Checks if the given employee exists in the system
     * @param user User to be searched for
     * @return Returns the user object if the user already exists in the system or null otherwise
     */
    public User getEmployee(User user)
    {
        return employees.find(user);
    }

    /**
     * Displays employees in ascending order according to their ids
     */
    public void displayEmployees()
    {
        System.out.println("ID  -  Name  -  Password - User Type - Proficiency\n");
        BiConsumer<User, Integer> displayEmployee = (a, b) ->
        {
            if(a != null)
                if(a instanceof Employee)
                    System.out.println(a.getUserID() + "  -  " + a.getUserName() + "  -  " + a.getUserPassword() + "  -  " + a.getUserType() + "  -  " + ((Employee) a).getProficiency());
        };

        employees.preOrderTraverse(displayEmployee);
    }

    /**
     * Adds a patient to the system
     * @param user User object to be added
     * @return Returns true if the user with the given id doesn't exist in the system or false otherwise
     */
    public boolean addPatient(User user)
    {
        if(getUser(user) != null)
            return false;

        return patients.add(user);
    }

    /**
     * Checks if the given patient exists in the system
     * @param user User to be searched for
     * @return Returns the user object if the user already exists in the system or null otherwise
     */
    public User getPatient(User user)
    {
        return patients.find(user);
        
    }

    /**
     * Displays patients
     */
    public void displayPatients()
    {
        System.out.println("ID  -  Name  -  Password - User Type\n");
        BiConsumer<User, Integer> displayPatient= (a, b) ->
        {
            if(a != null)
                System.out.println(a.getUserID() + "  -  " + a.getUserName() + "  -  " + a.getUserPassword());
        };

        patients.preOrderTraverse(displayPatient);
    }

    /**
     * Removes a user from the system
     * @param id Employee id
     * @return Returns true if the user exists in the system or false otherwise
     */
    public boolean removeUser(String id)
    {
        User user = employees.find(new User(id, "", "", ""));

        if(user != null)
        {
            // If the user is a nurse, delete it from the hashmap as well
            if(user instanceof Nurse)
            {
                Nurse nurse = (Nurse) user;

                // Get the array list matching the key
                ArrayList<Nurse> tempList = nurses.get(nurse.getProficiency());

                // Find and remove the nurse,
                for(int i = 0; i < tempList.size(); i++)
                {
                    if(nurse.getUserID().equals(tempList.get(i).getUserID()))
                    {
                        tempList.remove(i);
                        break;
                    }
                }
            }

            employees.remove(new User(id, "", "", ""));

            return true;
        }

        return patients.remove(new User(id, "", "", ""));
    }

    /**
     * Adds the given appointment to the list
     * @param appointment Appointment to be added
     */
    public void addAppointment(Appointments appointment)
    {
        ListIterator<Appointments> iter = appointments.listIterator();
        while(iter.hasNext())
        {
            Appointments temp = iter.next();
            if(temp.getDate().equals(appointment.getDate()) && temp.getDoctor().compareTo(appointment.getDoctor()) == 0)
                return;
        }

        appointments.addLast(appointment);
        appointments.sort();
    }

    /**
     * Removes an appointment from the list
     * @param appointment
     */
    public void removeAppointment(Appointments appointment)
    {
        ListIterator<Appointments> iter = appointments.listIterator();
        while(iter.hasNext())
        {
            Appointments temp = iter.next();
            if(temp.getDate().equals(appointment.getDate()) && temp.getDoctor().compareTo(appointment.getDoctor()) == 0)
            {
                iter.remove();
                return;
            }
        }
    }

    /**
     * Finds a given appointment
     * @param appointment Appointment to be found
     * @return Returns the requested appointment or null if it's not in the list
     */
    public Appointments getAppointment(Appointments appointment)
    {
        ListIterator<Appointments> iter = appointments.listIterator();
        while(iter.hasNext())
        {
            Appointments temp = iter.next();
            if(temp.getDate().equals(appointment.getDate()) && temp.getDoctor().compareTo(appointment.getDoctor()) == 0)
            {
                return temp;
            }
        }

        return null;
    }
    public ArrayList<Appointments> getAppointment(Patient patient)
    {
        ArrayList<Appointments> appointmentArray = new ArrayList<>();
        ListIterator<Appointments> iter = appointments.listIterator();
        while(iter.hasNext())
        {
            Appointments temp = iter.next();
            if(temp.getPatient().equals(patient))
            {
                appointmentArray.add(temp);
            }
        }
        return appointmentArray;
    }
    public ArrayList<Appointments> getAppointment(Doctor doctor)
    {
        ArrayList<Appointments> appointmentArray = new ArrayList<>();
        ListIterator<Appointments> iter = appointments.listIterator();
        while(iter.hasNext())
        {
            Appointments temp = iter.next();
            if(temp.getDoctor().equals(doctor))
            {
                appointmentArray.add(temp);
            }
        }
        return appointmentArray;
    }

    private void loadUserList()
    {
        addEmployee(new Admin("a", "a" , "a"));
        addEmployee(new Doctor("d", "d" , "d", Employee.proInternist));
        addEmployee(new Nurse("n", "n" , "n", Employee.proRadiolog));

        generatePatients(20);
    }

    private void generatePatients(int count)
    {
        for(int i = 0; i < count; i++)
        {
            StringBuilder sb = new StringBuilder();

            sb.append("p");
            sb.append(i);

            addPatient(new Patient(sb.toString(), sb.toString() , sb.toString(), 1, 1, 1, "A"));
        }
    }
}
