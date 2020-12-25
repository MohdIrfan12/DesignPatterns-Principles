package SolidPrincipals.isp.why;

import java.util.HashMap;

interface CommonInterface {

    /**
     * add employee company in directory
     *
     * @param name
     */
    void addEmployee(String name);

    /**
     * remove employee from company directory
     *
     * @param name
     */
    void removeEmployee(String name);

    /**
     * return current employee list to pay
     *
     * @return
     */
    HashMap<String, Boolean> getCurrentEmployeesList();

    /**
     * get total employee list
     *
     * @return
     */
    HashMap<String, Boolean> getTotalList();
}
