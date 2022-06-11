package main.java.menu;

import main.java.login.Login;
import main.java.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MenuManager
{
    private Menu currentMenu;
    private HashMap<String, Menu> menuMap;

    private boolean running;

    private static final String exitButtonStr = "Exit";
    private static final String prevButtonStr = "Previous Menu";

    private static final String menuLabelLoggedOut = "Hospital Management System";
    private static final String menuLabelAdmin = "Admin Panel";
    private static final String menuLabelDoctor = "Doctor Panel";
    private static final String menuLabelNurse = "Nurse Panel";
    private static final String menuLabelPatient = "Patient Panel";

    private static final String buttonLabelLogin = "Login";
    private static final String buttonLabelRegister = "Register";
    private static final String buttonLabelLogout = "Logout";

    private static final String buttonLabelAdminAddUser = "Add User";
    private static final String buttonLabelAdminRemoveUser = "Remove User";
    private static final String buttonLabelAdminDisplayEmployees = "Display Employees";
    private static final String buttonLabelAdminDisplayPatients = "Display Patients";
    private static final String buttonLabelAdminAssignForensicCase = "Assign Forensic Case";
    private static final String buttonLabelAdminSetWorkingDays = "Set Working Days";
    private static final String buttonLabelAdminSetNightShift = "Set Night Shift";

    private static final String buttonLabelEmployeeViewNightShifts = "View Night Shifts";
    private static final String buttonLabelEmployeeViewWorkingDays= "View Working Days";
    private static final String buttonLabelEmployeeViewForensicCases = "View Forensic Cases";

    private static final String buttonLabelDoctorCreateAppointment = "Create Appointment";
    private static final String buttonLabelDoctorWritePrescription = "Write Prescription";
    private static final String buttonLabelDoctorViewPatientHistory = "View Patient History";
    private static final String buttonLabelDoctorViewAllergies = "View Allergies";
    private static final String buttonLabelDoctorAddAllergy = "Add Allergy";
    private static final String buttonLabelDoctorViewSymptoms = "View Symptoms";
    private static final String buttonLabelDoctorAddSymptom = "Add Symptom";
    private static final String buttonLabelDoctorViewIllness = "View Illness";
    private static final String buttonLabelDoctorAddIllness = "Add Illness";
    private static final String buttonLabelDoctorEnterTestResults = "Enter Test Results";
    private static final String buttonLabelDoctorHospitalizePatient = "Hospitalize Patient";

    private static final String buttonLabelNurseTestPatient = "Test Patient";
    private static final String buttonLabelNurseViewTests = "View Tests";

    private static final String buttonLabelPatientViewAppointments = "View Appointments";
    private static final String buttonLabelPatientAddAppointments = "Add Appointments";
    private static final String buttonLabelPatientDeleteAppointments = "Delete Appointments";
    private static final String buttonLabelPatientViewInformation = "View Information";

    public MenuManager()
    {
        menuMap = new HashMap<>();
        running = true;

        init();
        currentMenu = menuMap.get(menuLabelLoggedOut);
    }

    public void run()
    {
        while(running)
        {
            if(currentMenu == null)
            {
                running = false;
            }
            else
            {
                displayMenu(currentMenu);
            }
        }
    }

    private void init()
    {
        // Menus

        Menu menuLoggedOut = new Menu(menuLabelLoggedOut);
        Menu menuAdminMain = new Menu(menuLabelAdmin);
        Menu menuDoctorMain = new Menu(menuLabelDoctor);
        Menu menuNurseMain = new Menu(menuLabelNurse);
        Menu menuPatientMain = new Menu(menuLabelPatient);

        // Action Screens

        ActionScreen acLogin = new ActionScreen(buttonLabelLogin);
        ActionScreen acRegister = new ActionScreen(buttonLabelRegister);

        ActionScreen acAdminAddUser = new ActionScreen(buttonLabelAdminAddUser);
        ActionScreen acAdminRemoveUser = new ActionScreen(buttonLabelAdminRemoveUser);
        ActionScreen acAdminDisplayEmployees = new ActionScreen(buttonLabelAdminDisplayEmployees);
        ActionScreen acAdminDisplayPatients = new ActionScreen(buttonLabelAdminDisplayPatients);
        ActionScreen acAdminAssignForensicCase = new ActionScreen(buttonLabelAdminAssignForensicCase);
        ActionScreen acAdminSetWorkingDays = new ActionScreen(buttonLabelAdminSetWorkingDays);
        ActionScreen acAdminSetNightShifts = new ActionScreen(buttonLabelAdminSetNightShift);

        ActionScreen acEmployeeViewNightShifts = new ActionScreen(buttonLabelEmployeeViewNightShifts);
        ActionScreen acEmployeeViewWorkingDays = new ActionScreen(buttonLabelEmployeeViewWorkingDays);
        ActionScreen acEmployeeViewForensicCases = new ActionScreen(buttonLabelEmployeeViewForensicCases);

        ActionScreen acDoctorCreateAppointment = new ActionScreen(buttonLabelDoctorCreateAppointment);
        ActionScreen acDoctorWritePrescription = new ActionScreen(buttonLabelDoctorWritePrescription);
        ActionScreen acDoctorViewPatientHistory = new ActionScreen(buttonLabelDoctorViewPatientHistory);
        ActionScreen acDoctorViewAllergies = new ActionScreen(buttonLabelDoctorViewAllergies);
        ActionScreen acDoctorAddAllergy = new ActionScreen(buttonLabelDoctorAddAllergy);
        ActionScreen acDoctorViewSymptoms = new ActionScreen(buttonLabelDoctorViewSymptoms);
        ActionScreen acDoctorAddSymptom = new ActionScreen(buttonLabelDoctorAddSymptom);
        ActionScreen acDoctorViewIllness = new ActionScreen(buttonLabelDoctorViewIllness);
        ActionScreen acDoctorAddIllness = new ActionScreen(buttonLabelDoctorAddIllness);
        ActionScreen acDoctorEnterTestResults = new ActionScreen(buttonLabelDoctorEnterTestResults);
        ActionScreen acDoctorHospitalizePatient = new ActionScreen(buttonLabelDoctorHospitalizePatient);

        ActionScreen acNurseTestPatient = new ActionScreen(buttonLabelNurseTestPatient);
        ActionScreen acNurseViewTests = new ActionScreen(buttonLabelNurseViewTests);

        ActionScreen acPatientViewAppointments = new ActionScreen(buttonLabelPatientViewAppointments);
        ActionScreen acPatientAddAppointments = new ActionScreen(buttonLabelPatientAddAppointments);
        ActionScreen acPatientDeleteAppointments = new ActionScreen(buttonLabelPatientDeleteAppointments);
        ActionScreen acPatientViewInformation = new ActionScreen(buttonLabelPatientViewInformation);

        // Buttons

        Button buttonLogin = new Button(buttonLabelLogin);
        Button buttonRegister = new Button(buttonLabelRegister);
        Button buttonLogout = new Button(buttonLabelLogout);

        Button buttonAdminAddUser = new Button(buttonLabelAdminAddUser);
        Button buttonAdminRemoveUser = new Button(buttonLabelAdminRemoveUser);
        Button buttonAdminDisplayEmployees = new Button(buttonLabelAdminDisplayEmployees);
        Button buttonAdminDisplayPatients = new Button(buttonLabelAdminDisplayPatients);
        Button buttonAdminAssignForensicCase = new Button(buttonLabelAdminAssignForensicCase);
        Button buttonAdminSetWorkingDays = new Button(buttonLabelAdminSetWorkingDays);
        Button buttonAdminSetSetNightShift = new Button(buttonLabelAdminSetNightShift);

        Button buttonEmployeeViewNightShifts  = new Button(buttonLabelEmployeeViewNightShifts);
        Button buttonEmployeeViewWorkingDays = new Button(buttonLabelEmployeeViewWorkingDays);
        Button buttonEmployeeViewForensicCases = new Button(buttonLabelEmployeeViewForensicCases);

        Button buttonDoctorCreateAppointment = new Button(buttonLabelDoctorCreateAppointment);
        Button buttonDoctorWritePrescription = new Button(buttonLabelDoctorWritePrescription);
        Button buttonDoctorViewPatientHistory = new Button(buttonLabelDoctorViewPatientHistory);
        Button buttonDoctorViewAllergies = new Button(buttonLabelDoctorViewAllergies);
        Button buttonDoctorAddAllergy = new Button(buttonLabelDoctorAddAllergy);
        Button buttonDoctorViewSymptoms = new Button(buttonLabelDoctorViewSymptoms);
        Button buttonDoctorAddSymptom = new Button(buttonLabelDoctorAddSymptom);
        Button buttonDoctorViewIllness = new Button(buttonLabelDoctorViewIllness);
        Button buttonDoctorAddIllness = new Button(buttonLabelDoctorAddIllness);
        Button buttonDoctorEnterTestResults = new Button(buttonLabelDoctorEnterTestResults);
        Button buttonDoctorHospitalizePatient = new Button(buttonLabelDoctorHospitalizePatient);

        Button buttonNurseTestPatient = new Button(buttonLabelNurseTestPatient);
        Button buttonNurseViewTests = new Button(buttonLabelNurseViewTests);

        Button buttonPatientViewAppointments = new Button(buttonLabelPatientViewAppointments);
        Button buttonPatientAddAppointments = new Button(buttonLabelPatientAddAppointments);
        Button buttonPatientDeleteAppointments = new Button(buttonLabelPatientDeleteAppointments);
        Button buttonPatientViewInformation = new Button(buttonLabelPatientViewInformation);

        // Assign buttons to menus

        menuLoggedOut.addButton(buttonLogin);
        menuLoggedOut.addButton(buttonRegister);

        menuAdminMain.addButton(buttonAdminAddUser);
        menuAdminMain.addButton(buttonAdminRemoveUser);
        menuAdminMain.addButton(buttonAdminDisplayEmployees);
        menuAdminMain.addButton(buttonAdminDisplayPatients);
        menuAdminMain.addButton(buttonAdminAssignForensicCase);
        menuAdminMain.addButton(buttonAdminSetWorkingDays);
        menuAdminMain.addButton(buttonAdminSetSetNightShift);
        menuAdminMain.addButton(buttonLogout);

        menuDoctorMain.addButton(buttonDoctorCreateAppointment);
        menuDoctorMain.addButton(buttonDoctorWritePrescription);
        menuDoctorMain.addButton(buttonDoctorViewPatientHistory);
        menuDoctorMain.addButton(buttonDoctorViewAllergies);
        menuDoctorMain.addButton(buttonDoctorAddAllergy);
        menuDoctorMain.addButton(buttonDoctorViewSymptoms);
        menuDoctorMain.addButton(buttonDoctorAddSymptom);
        menuDoctorMain.addButton(buttonDoctorViewIllness);
        menuDoctorMain.addButton(buttonDoctorAddIllness);
        menuDoctorMain.addButton(buttonDoctorEnterTestResults);
        menuDoctorMain.addButton(buttonDoctorHospitalizePatient);
        menuDoctorMain.addButton(buttonEmployeeViewNightShifts);
        menuDoctorMain.addButton(buttonEmployeeViewWorkingDays);
        menuDoctorMain.addButton(buttonEmployeeViewForensicCases);
        menuDoctorMain.addButton(buttonLogout);

        menuNurseMain.addButton(buttonNurseTestPatient);
        menuNurseMain.addButton(buttonNurseViewTests);
        menuNurseMain.addButton(buttonEmployeeViewNightShifts);
        menuNurseMain.addButton(buttonEmployeeViewWorkingDays);
        menuNurseMain.addButton(buttonEmployeeViewForensicCases);
        menuNurseMain.addButton(buttonLogout);

        menuPatientMain.addButton(buttonPatientViewAppointments);
        menuPatientMain.addButton(buttonPatientAddAppointments);
        menuPatientMain.addButton(buttonPatientDeleteAppointments);
        menuPatientMain.addButton(buttonPatientViewInformation);
        menuPatientMain.addButton(buttonLogout);

        // Assign previous menus

        menuAdminMain.setPrevMenu(null);

        // Assign menus or action screens to buttons

        buttonLogin.setActionScreen(acLogin);
        buttonRegister.setActionScreen(acRegister);

        buttonAdminAddUser.setActionScreen(acAdminAddUser);
        buttonAdminRemoveUser.setActionScreen(acAdminRemoveUser);
        buttonAdminDisplayEmployees.setActionScreen(acAdminDisplayEmployees);
        buttonAdminDisplayPatients.setActionScreen(acAdminDisplayPatients);
        buttonAdminAssignForensicCase.setActionScreen(acAdminAssignForensicCase);
        buttonAdminSetWorkingDays.setActionScreen(acAdminSetWorkingDays);
        buttonAdminSetSetNightShift.setActionScreen(acAdminSetNightShifts);

        buttonEmployeeViewNightShifts.setActionScreen(acEmployeeViewNightShifts);
        buttonEmployeeViewWorkingDays.setActionScreen(acEmployeeViewWorkingDays);
        buttonEmployeeViewForensicCases.setActionScreen(acEmployeeViewForensicCases);

        buttonDoctorCreateAppointment.setActionScreen(acDoctorCreateAppointment);
        buttonDoctorWritePrescription.setActionScreen(acDoctorWritePrescription);
        buttonDoctorViewPatientHistory.setActionScreen(acDoctorViewPatientHistory);
        buttonDoctorViewAllergies.setActionScreen(acDoctorViewAllergies);
        buttonDoctorAddAllergy.setActionScreen(acDoctorAddAllergy);
        buttonDoctorViewSymptoms.setActionScreen(acDoctorViewSymptoms);
        buttonDoctorAddSymptom.setActionScreen(acDoctorAddSymptom);
        buttonDoctorViewIllness.setActionScreen(acDoctorViewIllness);
        buttonDoctorAddIllness.setActionScreen(acDoctorAddIllness);
        buttonDoctorEnterTestResults.setActionScreen(acDoctorEnterTestResults);
        buttonDoctorHospitalizePatient.setActionScreen(acDoctorHospitalizePatient);

        buttonNurseTestPatient.setActionScreen(acNurseTestPatient);
        buttonNurseViewTests.setActionScreen(acNurseViewTests);

        buttonPatientViewAppointments.setActionScreen(acPatientViewAppointments);
        buttonPatientAddAppointments.setActionScreen(acPatientAddAppointments);
        buttonPatientDeleteAppointments.setActionScreen(acPatientDeleteAppointments);
        buttonPatientViewInformation.setActionScreen(acPatientViewInformation);

        // Add menus to the hash map

        menuMap.put(menuLoggedOut.getLabel(), menuLoggedOut);
        menuMap.put(menuAdminMain.getLabel(), menuAdminMain);
        menuMap.put(menuDoctorMain.getLabel(), menuDoctorMain);
        menuMap.put(menuNurseMain.getLabel(), menuNurseMain);
        menuMap.put(menuPatientMain.getLabel(), menuPatientMain);
    }

    private void addMenu(Menu menu)
    {
        if(menuMap.containsKey(menu.getLabel()))
            return;

        menuMap.put(menu.getLabel(), menu);
    }

    private void actOnChoice(int choice)
    {
        // If the choice is out of bounds, do nothing
        if(choice < 0 || choice > currentMenu.getButtonlist().size())
            return;

        // If the choice is the last option which is exit or previous menu, assign previous menu to current menu
        if(choice == currentMenu.getButtonlist().size())
        {
            currentMenu = currentMenu.getPrevMenu();
            return;
        }

        // Get the button corresponding to the user choice
        Button button = currentMenu.getButtonlist().get(choice);

        if(button.getLabel().equals(buttonLabelLogout))
        {
            Login.logout();
            currentMenu = menuMap.get(menuLabelLoggedOut);
        }
        else if(button.getMenu() != null)
        {
            currentMenu = button.getMenu();
        }
        else if(button.getActionScreen() != null)
        {
            System.out.println("\n##########################################################\n");

            // If the user chose login button show login screen
            if(button.getActionScreen().getLabel().equals(buttonLabelLogin)) // Login screen
            {
                button.getActionScreen().userLogin();

                // If the returned user is not null, change the current page to the user type page
                if(Login.getLoggedinUser() != null)
                {
                    if(Login.getLoggedinUser().getUserType().equals(User.userTypeAdmin))
                        currentMenu = menuMap.get(menuLabelAdmin);
                    else if(Login.getLoggedinUser().getUserType().equals(User.userTypeDoctor))
                        currentMenu = menuMap.get(menuLabelDoctor);
                    else if(Login.getLoggedinUser().getUserType().equals(User.userTypeNurse))
                        currentMenu = menuMap.get(menuLabelNurse);
                    else if(Login.getLoggedinUser().getUserType().equals(User.userTypePatient))
                        currentMenu = menuMap.get(menuLabelPatient);
                }
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelRegister)) // Register screen
            {
                button.getActionScreen().userRegister();
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelAdminAddUser)) // Add user screen
            {
                button.getActionScreen().adminAddUser(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelAdminRemoveUser)) // Remove user screen
            {
                button.getActionScreen().adminRemoveUser(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelAdminDisplayEmployees)) // Display employees screen
            {
                button.getActionScreen().adminDisplayEmployees(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelAdminDisplayPatients)) // Display patients screen
            {
                button.getActionScreen().adminDisplayPatients(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelAdminAssignForensicCase)) // Assign forensic case
            {
                button.getActionScreen().adminAssignForensicCase(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelAdminSetWorkingDays)) // Set working days
            {
                button.getActionScreen().adminSetWorkingDays(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelAdminSetNightShift)) // Set night shift
            {
                button.getActionScreen().adminSetNightShifts(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelEmployeeViewNightShifts)) // View night shifts
            {
                button.getActionScreen().employeeViewNightShifts(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelEmployeeViewWorkingDays)) // View Working Days
            {
                button.getActionScreen().employeeViewWorkingDays(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelEmployeeViewForensicCases)) // View Forensic Cases
            {
                button.getActionScreen().employeeViewForensicCases(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelDoctorCreateAppointment)) // Create appointment
            {
                button.getActionScreen().doctorCreateAppointment(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelDoctorWritePrescription)) // Write prescription
            {
                button.getActionScreen().doctorWritePrescription(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelDoctorViewPatientHistory)) // View Patient History
            {
                button.getActionScreen().doctorViewPatientHistory(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelDoctorViewAllergies)) // View allergies
            {
                button.getActionScreen().doctorViewAllergies(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelDoctorAddAllergy)) // Add allergy
            {
                button.getActionScreen().doctorAddAllergy(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelDoctorViewSymptoms)) // View symptoms
            {
                button.getActionScreen().doctorViewSymptoms(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelDoctorAddSymptom)) // Add symptom
            {
                button.getActionScreen().doctorAddSymptom(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelDoctorViewIllness)) // View illness
            {
                button.getActionScreen().doctorViewIllness(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelDoctorAddIllness)) // Add illness
            {
                button.getActionScreen().doctorAddIllness(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelDoctorEnterTestResults)) // Enter test results
            {
                button.getActionScreen().doctorEnterTestResults(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelDoctorHospitalizePatient)) // Hospitalize patient
            {
                button.getActionScreen().doctorHospitalizePatient(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelNurseTestPatient)) // Test patient screen
            {
                button.getActionScreen().nurseTestPatient(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelNurseViewTests)) // View tests screen
            {
                button.getActionScreen().nurseViewTests(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelPatientViewAppointments)) // View Appointments
            {
                button.getActionScreen().patientViewAppointments(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelPatientAddAppointments)) // Add Appointments
            {
                button.getActionScreen().patientAddAppointments(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelPatientDeleteAppointments)) // Delete Appointments
            {
                button.getActionScreen().patientDeleteAppointments(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelPatientViewInformation)) // View Information
            {
                button.getActionScreen().patientViewInformation(Login.getLoggedinUser());
            }
        }
    }

    private int chooseOption()
    {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        try
        {
            choice = scanner.nextInt();
            scanner.nextLine(); // Clean the buffer
        }
        catch(Exception e)
        {
            choice = -1;
        }

        return choice;
    }


    public void displayMenu(Menu menu)
    {
        System.out.println("\n##########################################################\n");

        System.out.println("Menu: " + menu.getLabel() + "\n");
        for(int i = 0; i < menu.getButtonlist().size() + 1; i++)
        {
            if(i == menu.getButtonlist().size())
            {
                if(menu.getPrevMenu() == null)
                    System.out.println(i + ". " + exitButtonStr);
                else
                    System.out.println(i + ". " + prevButtonStr);
            }
            else
            {
                System.out.println(i + ". " + menu.getButtonlist().get(i).getLabel());
            }
        }

        System.out.println();
        System.out.print("Choice: ");
        int choice = chooseOption();
        actOnChoice(choice);
    }
}
