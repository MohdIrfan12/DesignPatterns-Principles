package SolidPrincipals.isp.why;

import OODesignPatterns.creational.Singleton;

import java.util.HashMap;

 class EmployeeDirectory implements CommonInterface {
    private HashMap<String, Boolean> employeeList;

    // Inner class to provide instance of class
    static class CREATER {
        private static final EmployeeDirectory INSTANCE = new EmployeeDirectory();
    }

    static EmployeeDirectory getInstance() {
        return EmployeeDirectory.CREATER.INSTANCE;
    }

    private EmployeeDirectory() {
        employeeList = new HashMap<>();
        employeeList.put("emp1", true);
        employeeList.put("emp2", true);
     }

    @Override
    public void addEmployee(String name) {
        employeeList.put(name, true);
    }

    @Override
    public void removeEmployee(String name) {
        employeeList.remove(name);
    }

    /**
     * should have returned current employees list but if someone was added today it will returns him/her as well.
     * @return
     */
    @Override
    public HashMap<String, Boolean> getCurrentEmployeesList() {
        return employeeList;
    }

    /**
     * retruns only current employees list. should have included removed employees as well.
     * @return
     */
    @Override
    public HashMap<String, Boolean> getTotalList() {
        return employeeList;
    }
}
