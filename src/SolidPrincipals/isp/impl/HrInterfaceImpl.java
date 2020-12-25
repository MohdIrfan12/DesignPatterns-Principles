package SolidPrincipals.isp.impl;

import java.util.HashMap;

public class HrInterfaceImpl implements HrInterface {

    private EmployeeDirectory employeeDirectory;

    HrInterfaceImpl() {
        employeeDirectory = EmployeeDirectory.getInstance();
    }

    @Override
    public void addEmployee(String name) {
        employeeDirectory.addEmployee(name);
    }

    @Override
    public void removeEmployee(String name) {
        employeeDirectory.removeEmployee(name);
    }

    @Override
    public HashMap<String, Boolean> getTotalList() {
        return employeeDirectory.getTotalList();
    }
}
