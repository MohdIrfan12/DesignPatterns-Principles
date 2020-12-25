package SolidPrincipals.Lsp.impl;

public class Factory {
    public static DataStorege getDataStorage(StorageType storageType) {
        if (storageType == null) {
            return null;
        }
        if (storageType== StorageType.DB) {
            return new DataStorageDbImpl();
        } else if (storageType== StorageType.WEB_SERVER) {
            return new DataStorageWsImpl();
        }
        return null;
    }

    public enum StorageType{
        DB, WEB_SERVER
    }
}
