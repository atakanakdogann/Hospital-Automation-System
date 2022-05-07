import java.util.ArrayList;

class Admin extends Employee{
    /**
     * Default Constructor
     */
    public Admin(){
        super();
    }
    /**
     * 
     * @param ID parameter for creating Admin object's ID
     * @param pass parameter for Admin's password
     */
    public Admin(String ID,String pass){
        super(ID,pass);
    }

    /**
     * Returns ID of Admin
     */
    public void getID(){
        return userID;
    }

    /**
     * 
     * @param EmployeeList Our Employee Arraylist for Admin's reaching all member of System
     * @param ID ID of new Member of Employees
     * @param pass Passwords of new Member of Employees
     * @return Same Employee List with new added member
     */
    public ArrayList<Employee> addEmployee(ArrayList<Employee> EmployeeList, String ID,String pass){
        Employee newEmployee = new Employee(ID,pass);
        EmployeeList.add(newEmployee);
        return EmployeeList;
    }
    /**
     * 
     * @param EmployeeList List of Employees for Admin reaching all members
     * @param empNumber Index number of deletion 
     * @return tempList of Employees which is EmployeeList - 1 member
     */
    public ArrayList<Employee> removeEmployee(ArrayList<Employee> EmployeeList,int empNumber){
        ArrayList tempList = new ArrayList<Employee>();
        for(int index = 0; index < empNumber ; index++){
            tempList.get(index).add(EmployeeList.get(index));
        }
        for(int index = empNumber+1; i < EmployeeList.size(); i++){
            tempList.get(index-1).add(EmployeeList.get(index));
        }
        return tempList;
    }
    /**
     * 
     * @param employee Employee which is will be set working days
     * @param working_days Boolean ArrayList for 7 Days
     */
    public void setWorkingDays(Employee employee,ArrayList<Boolean> working_days){
        employee.workingDays = working_days;
    }
    /**
     * 
     * @param employee Employee that will be returned 
     * @return Working Days
     */
    public ArrayList<Boolean> getWorkingDays(Employee employee){
        return employee.workingDays;
    }
    /**
     * 
     * @param employee Employee which is will be set Night Shift days
     * @param shift_days Boolean ArrayList for 7 Days
     */
    public void setNightShifts(Employee employee,ArrayList<Boolean> shift_days){
        employee.nightShifts = shift_days;
    }

    /**
     * 
     * @param employee Employee that will be returned 
     * @return Night Shift Days
     */
    public ArrayList<Boolean> getNightShifts(Employee employee){
        return employee.nightShifts;
    }
    /**
     * 
     * @param employee Guilty Employee
     * @param forensicCase String of Case
     */
    public void AssignForensic(Employee employee,String forensicCase){
        employee.forensicCases.add(forensicCase);
    }
    /**
     * 
     * @param employee Guilty Employee
     * @return Employee's Case
     */
    public ArrayList<String> getForensic(Employee employee){
        return employee.forensicCases;
    }

}