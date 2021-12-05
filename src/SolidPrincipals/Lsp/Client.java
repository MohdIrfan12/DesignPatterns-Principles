package SolidPrincipals.Lsp;


import SolidPrincipals.Lsp.impl.DataStorege;
import SolidPrincipals.Lsp.impl.Factory;

import java.util.ArrayList;

public class Client {
//
    public static void main(String[] args) {
        ArrayList<String> employeesList = new ArrayList<>();
        employeesList.add("Irfan");
        employeesList.add("Mohd Irfan");
        employeesList.add("Irfan Ali");
        employeesList.add("Mohd Irfan Ali");

        DataStorege databaseHelper = Factory.getDataStorage(Factory.StorageType.WEB_SERVER);
        databaseHelper.saveData(employeesList);
    }
}
