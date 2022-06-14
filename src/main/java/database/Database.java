package main.java.database;

import main.java.HelperClass.PatientRoom;
import main.java.datastructures.*;

import main.java.user.*;

import javax.swing.*;
import java.util.*;
import java.util.function.BiConsumer;

public class Database
{
    public static Database db = new Database();

    private BinarySearchTree<User> employees;
    private AVLTree<User> patients;
    private KWLinkedList<Appointments> appointments;
    private HashMap<String, ArrayList<Nurse>> nurses;
    private ListGraph roomsGraph;
    private ArrayList<PatientRoom> roomList;
    private SkipListJava<String, Doctor> doctors;

    private final static int roomCount = 30;
    private final static int floorCount = 5;

    public Database()
    {
        employees = new BinarySearchTree<>();
        patients = new AVLTree<>();
        appointments = new KWLinkedList<>();
        nurses = new HashMap<>();
        roomsGraph = new ListGraph(roomCount, false);
        roomList = new ArrayList<>();
        doctors = new SkipListJava<>();

        loadUserList();
        initGraph();
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
            else if(user instanceof Doctor)
            {
                Doctor doctor = (Doctor) user;

                doctors.add(doctor.getUserID(), doctor);
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

            if(user instanceof Doctor)
            {
                Doctor doctor = (Doctor) user;

                doctors.remove(doctor.getUserID());
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

    public int findEmptyRoom()
    {
        Queue < Integer > theQueue = new LinkedList < Integer > ();
        int start = 0;

        // Declare array identified and
        // initialize its elements to false.
        boolean[] identified = new boolean[roomsGraph.getNumV()];
        /* Mark the start vertex as identified and insert it
        into the queue */
        identified[start] = true;
        theQueue.offer(start);

        /* While the queue is not empty */
        while (!theQueue.isEmpty()) {
         /* Take a vertex, current, out of the queue.
       (Begin visiting current). */
            int current = theQueue.remove();

            if(roomList.get(current).getPatient() == null)
                return current;

            /* Examine each vertex, neighbor, adjacent to current. */
            Iterator < Edge > itr = roomsGraph.edgeIterator(current);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                int neighbor = edge.getDest();
                // If neighbor has not been identified
                if (!identified[neighbor]) {
                    // Mark it identified.
                    identified[neighbor] = true;

                    // Place it into the queue.
                    theQueue.offer(neighbor);
                }
            }
            // Finished visiting current.
        }

        return -1;
    }

    public boolean assignRoom(Patient patient)
    {
        if(patient == null)
            return false;

        if(patients.contains(patient) == false)
            return false;

        int roomId = findEmptyRoom();

        if(roomId == -1)
            return false;

        roomList.get(roomId).setPatient(patient);

        return true;
    }

    public boolean removePatientFromRoom(Patient patient)
    {
        Queue < Integer > theQueue = new LinkedList < Integer > ();
        int start = 0;

        // Declare array identified and
        // initialize its elements to false.
        boolean[] identified = new boolean[roomsGraph.getNumV()];
        /* Mark the start vertex as identified and insert it
        into the queue */
        identified[start] = true;
        theQueue.offer(start);

        /* While the queue is not empty */
        while (!theQueue.isEmpty()) {
         /* Take a vertex, current, out of the queue.
       (Begin visiting current). */
            int current = theQueue.remove();

            if(roomList.get(current).getPatient().equals(patient))
            {
                roomList.get(current).setPatient(null);
                return true;
            }

            /* Examine each vertex, neighbor, adjacent to current. */
            Iterator < Edge > itr = roomsGraph.edgeIterator(current);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                int neighbor = edge.getDest();
                // If neighbor has not been identified
                if (!identified[neighbor]) {
                    // Mark it identified.
                    identified[neighbor] = true;

                    // Place it into the queue.
                    theQueue.offer(neighbor);
                }
            }
            // Finished visiting current.
        }

        return false;
    }

    private void loadUserList()
    {
        addEmployee(new Admin("a", "a" , "a"));
        addEmployee(new Doctor("d", "d" , "d", Employee.proInternist));
        addEmployee(new Nurse("nurse@hospital.com", "nursePassword" , "Nurse 1", Employee.proInternist));
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

    private void initGraph()
    {
        for(int r = 0; r < floorCount; r++)
        {
            for(int j = 0; j < roomCount / floorCount; j++)
            {
                roomList.add(new PatientRoom(j, r, null));

                if(j != 0)
                {
                    int src = (r * (roomCount / floorCount)) + j;
                    int dst = src - 1;
                    roomsGraph.insert(new Edge(src, dst));
                }
            }

            if(r != 0)
            {
                int src = r * (roomCount / floorCount);
                int dst = (r - 1) * (roomCount / floorCount);
                roomsGraph.insert(new Edge(src, dst));
            }
        }

        roomsGraph.toString();
    }
}
