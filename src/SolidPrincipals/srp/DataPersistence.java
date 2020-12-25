package SolidPrincipals.srp;

import SolidPrincipals.utll.Database;
import SolidPrincipals.utll.Inmemory;
import SolidPrincipals.utll.WebServer;

public class DataPersistence {
    private Inmemory inmemory;
    private Database database;
    private WebServer webServer;

    public DataPersistence(Database database,
                           WebServer webServer,
                           Inmemory inmemory) {
        this.database = database;
        this.webServer = webServer;
        this.inmemory = inmemory;
    }

    public void saveDataInMemory(Object data) {
        inmemory.save(data);
    }

    public void saveDataInDb(Database data) {
        database.save(data);
    }

    public void saveDataOntoWebserver(Object data) {
        webServer.save(data);
    }
}
