package OODesignPatterns.creational;

/**
 * Application needs one, and only one, instance of an object.
 * Additionally, lazy initialization and global access are necessary.
 */
public class Singleton {

    private static class EagerInitialisationSingleton {
        // public instance initialized when loading the class
        private static final EagerInitialisationSingleton instance = new EagerInitialisationSingleton();

        private EagerInitialisationSingleton() {
        }

        public static EagerInitialisationSingleton getInstance() {
            return instance;
        }
    }


    private static class LazyInitialisationSingleton {
        // private instance, so that it can be accessed by only by getInstance() method
        private static LazyInitialisationSingleton instance;

        private LazyInitialisationSingleton() {
        }

        //method to return instance of class
        public static LazyInitialisationSingleton getInstance() {
            if (instance == null) {
                instance = new LazyInitialisationSingleton();
            }
            return instance;
        }
    }

    /**
     * generally prefer this one
     */
    private static class BillPughSingleton {
        private BillPughSingleton() {
        }

        // Inner class to provide instance of class
        static class CREATER {
            private static final BillPughSingleton INSTANCE = new BillPughSingleton();
        }

        public static BillPughSingleton getInstance() {
            return BillPughSingleton.CREATER.INSTANCE;
        }
    }

    /**
     * use this technique in concurrent environment
     */
    private static class LazyInitThreadSafeInitializationSingleton {
        // private instance, so that it can be accessed by only by getInstance() method
        private static LazyInitThreadSafeInitializationSingleton instance;

        private LazyInitThreadSafeInitializationSingleton() {
        }

        //method to return instance of class
        public static LazyInitThreadSafeInitializationSingleton getInstance() {
            if (instance == null) {
                //synchronized block to remove overhead
                synchronized (LazyInitThreadSafeInitializationSingleton.class) {
                    if (instance == null) {
                        // if instance is null, initialize
                        instance = new LazyInitThreadSafeInitializationSingleton();
                    }
                }
            }
            return instance;
        }
    }

    public static void main(String[] args) {
        EagerInitialisationSingleton.getInstance();
        LazyInitialisationSingleton.getInstance();
        LazyInitThreadSafeInitializationSingleton.getInstance();
        BillPughSingleton.getInstance();
    }
}
