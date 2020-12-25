package SolidPrincipals.Lsp.impl;

import SolidPrincipals.utll.Database;

public class DataStorageDbImpl implements DataStorege {

    private Database database;

    public DataStorageDbImpl() {
        database = new Database();
    }

    @Override
    public void saveData(Object object) {
        database.save(object);
    }
}
