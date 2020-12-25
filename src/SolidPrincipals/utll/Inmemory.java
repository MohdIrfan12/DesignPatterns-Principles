package SolidPrincipals.utll;

public class Inmemory {

    private Object data;

    private Inmemory() {
    }

    // Inner class to provide instance of class
    private static class CREATER {
        private static final Inmemory INSTANCE = new Inmemory();
    }

    public static Inmemory getInstance() {
        return Inmemory.CREATER.INSTANCE;
    }


    public void save(Object data) {
        this.data = data;
    }
}
