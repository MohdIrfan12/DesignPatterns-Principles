package SolidPrincipals.isp.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AccountantInterfaceImpl implements AccountantInterface {

    private EmployeeDirectory employeeDirectory;

    AccountantInterfaceImpl() {
        employeeDirectory = EmployeeDirectory.getInstance();
    }

    @Override
    public ArrayList<String> getCurrentEmployeesList() {
        ArrayList<String> list = new ArrayList<>();

        for (Map.Entry<String, Boolean> entry :
                employeeDirectory.getCurrentEmployeesList().entrySet()) {
            if (entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
