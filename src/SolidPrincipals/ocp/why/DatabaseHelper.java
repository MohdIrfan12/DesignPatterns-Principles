package SolidPrincipals.ocp.why;

import SolidPrincipals.utll.Database;

public class DatabaseHelper {
    private Database database;

    public DatabaseHelper() {
        database = new Database();
    }

    public void saveData(Object data) {
        database.save(data);
    }
}
