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

    private static final String buttonLabelNurseTestPatient = "Test Patient";
    private static final String buttonLabelNurseViewTests = "View Tests";

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

        ActionScreen acNurseTestPatient = new ActionScreen(buttonLabelNurseTestPatient);
        ActionScreen acNurseViewTests = new ActionScreen(buttonLabelNurseViewTests);

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

        Button buttonNurseTestPatient = new Button(buttonLabelNurseTestPatient);
        Button buttonNurseViewTests = new Button(buttonLabelNurseViewTests);

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

        menuDoctorMain.addButton(buttonLogout);

        menuNurseMain.addButton(buttonNurseTestPatient);
        menuNurseMain.addButton(buttonNurseViewTests);
        menuNurseMain.addButton(buttonLogout);

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

        buttonNurseTestPatient.setActionScreen(acNurseTestPatient);
        buttonNurseTestPatient.setActionScreen(acNurseViewTests);

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
            else if(button.getActionScreen().getLabel().equals(buttonLabelNurseTestPatient)) // Test patient screen
            {
                button.getActionScreen().nurseTestPatient(Login.getLoggedinUser());
            }
            else if(button.getActionScreen().getLabel().equals(buttonLabelNurseViewTests)) // View tests screen
            {
                button.getActionScreen().nurseViewTests(Login.getLoggedinUser());
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
