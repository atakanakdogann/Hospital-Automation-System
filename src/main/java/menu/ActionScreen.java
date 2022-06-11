package main.java.menu;

import main.java.login.Login;
import main.java.user.Admin;
import main.java.user.Nurse;
import main.java.user.User;

public class ActionScreen
{
    private String label;

    public ActionScreen(String label)
    {
        this.label = label;
    }

    public void userLogin()
    {
        Login.login();
    }

    public boolean userRegister()
    {
        return Login.register();
    }

    public boolean adminAddUser(User user)
    {
        if(!(user instanceof Admin))
            return false;

        return ((Admin) user).addUser();
    }

    public boolean adminRemoveUser(User user)
    {
        if(!(user instanceof Admin))
            return false;

        return ((Admin) user).removeUser();
    }

    public void adminDisplayEmployees(User user)
    {
        if(!(user instanceof Admin))
            return;

        ((Admin) user).displayEmployees();
    }

    public void adminDisplayPatients(User user)
    {
        if(!(user instanceof Admin))
            return;

        ((Admin) user).displayPatients();
    }

    public void adminAssignForensicCase(User user)
    {
        if(!(user instanceof Admin))
            return;

        ((Admin) user).assignForensic();
    }

    public void adminSetWorkingDays(User user)
    {
        if(!(user instanceof Admin))
            return;

        ((Admin) user).setWorkDays();
    }

    public void adminSetNightShifts(User user)
    {
        if(!(user instanceof Admin))
            return;

        ((Admin) user).setNightShifts();
    }

    //TODO: please re-implement this method according to changes in Examination class
    /*public void nurseTestPatient(User user)
    {
        if(!(user instanceof Nurse))
            return;

        ((Nurse) user).testPatient();
    }*/

    public void nurseViewTests(User user)
    {
        if(!(user instanceof Nurse))
            return;

        ((Nurse) user).viewTestsToBeDone();
    }

    public String getLabel()
    {
        return label;
    }
}
