package SolidPrincipals.isp.impl;


import java.util.HashMap;

public class EmployeeDirectory  {
    private HashMap<String, Boolean> employeeList;

    // Inner class to provide instance of class
    static class CREATER {
        private static final EmployeeDirectory INSTANCE = new EmployeeDirectory();
    }

    public static EmployeeDirectory getInstance() {
        return EmployeeDirectory.CREATER.INSTANCE;
    }

    private EmployeeDirectory() {
        employeeList = new HashMap<>();
        employeeList.put("emp1", true);
        employeeList.put("emp2", true);
     }

     public void addEmployee(String name) {
        employeeList.put(name, true);
    }

     public void removeEmployee(String name) {
        employeeList.put(name,false);
    }

     public HashMap<String, Boolean> getCurrentEmployeesList() {
        return employeeList;
    }

     public HashMap<String, Boolean> getTotalList() {
        return employeeList;
    }
}
