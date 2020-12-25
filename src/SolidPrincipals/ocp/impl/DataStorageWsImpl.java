package SolidPrincipals.ocp.impl;

import SolidPrincipals.utll.WebServer;

public class DataStorageWsImpl implements DataStorege {

    private WebServer webServer;

    public DataStorageWsImpl() {
        webServer = new WebServer();
    }

    @Override
    public void saveData(Object object) {
        webServer.save(object);
    }
}
