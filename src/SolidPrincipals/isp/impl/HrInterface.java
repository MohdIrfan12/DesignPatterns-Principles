package SolidPrincipals.isp.impl;

import java.util.HashMap;

public interface HrInterface {

    void addEmployee(String name);
    void removeEmployee(String name);
    HashMap<String, Boolean> getTotalList();
}
