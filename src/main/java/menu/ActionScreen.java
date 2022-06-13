package main.java.menu;

import main.java.login.Login;
import main.java.user.*;

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

        return ((Admin) user).addEmployee();
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

    public void employeeViewNightShifts(User user)
    {
        if(!(user instanceof Employee))
            return;

        ((Employee) user).viewNightShifts();
    }

    public void employeeViewWorkingDays(User user)
    {
        if(!(user instanceof Employee))
            return;

        ((Employee) user).viewWorkingDays();
    }

    public void employeeViewForensicCases(User user)
    {
        if(!(user instanceof Employee))
            return;

        ((Employee) user).viewForensicCases();
    }

    public void doctorCreateAppointment(User user)
    {
        if(!(user instanceof Doctor))
            return;

        ((Doctor) user).createAppointment();
    }

    public void doctorWritePrescription(User user)
    {
        if(!(user instanceof Doctor))
            return;

        ((Doctor) user).writePrescription();
    }

    public void doctorViewPatientHistory(User user)
    {
        if(!(user instanceof Doctor))
            return;

        ((Doctor) user).viewPatientHistory();
    }

    public void doctorViewAllergies(User user)
    {
        if(!(user instanceof Doctor))
            return;

        ((Doctor) user).viewAllergies();
    }

    public void doctorAddAllergy(User user)
    {
        if(!(user instanceof Doctor))
            return;

        ((Doctor) user).addAllergies();
    }

    public void doctorViewSymptoms(User user)
    {
        if(!(user instanceof Doctor))
            return;

        ((Doctor) user).viewSymptoms();
    }

    public void doctorAddSymptom(User user)
    {
        if(!(user instanceof Doctor))
            return;

        ((Doctor) user).addSymptoms();
    }

    public void doctorViewIllness(User user)
    {
        if(!(user instanceof Doctor))
            return;

        ((Doctor) user).viewIllness();
    }

    public void doctorAddIllness(User user)
    {
        if(!(user instanceof Doctor))
            return;

        ((Doctor) user).addIllness();
    }

    public void doctorEnterTestResults(User user)
    {
        if(!(user instanceof Doctor))
            return;

        ((Doctor) user).enterTestResults();
    }

    public void doctorHospitalizePatient(User user)
    {
        if(!(user instanceof Doctor))
            return;

        ((Doctor) user).hospitalizePatient();
    }

    public void nurseTestPatient(User user)
    {
        if(!(user instanceof Nurse))
            return;

        ((Nurse) user).testPatient();
    }

    public void nurseViewTests(User user)
    {
        if(!(user instanceof Nurse))
            return;

        ((Nurse) user).viewTestsToBeDone();
    }

    public void patientViewAppointments(User user)
    {
        if(!(user instanceof Patient))
            return;

        ((Patient) user).viewAppointments();
    }

    public void patientAddAppointments(User user)
    {
        if(!(user instanceof Patient))
            return;

        ((Patient) user).addAppointment();
    }

    public void patientDeleteAppointments(User user)
    {
        if(!(user instanceof Patient))
            return;

        ((Patient) user).deleteAppointment();
    }

    public void patientViewInformation(User user)
    {
        if(!(user instanceof Patient))
            return;

        ((Patient) user).viewInformation();
    }

    public String getLabel()
    {
        return label;
    }
}
