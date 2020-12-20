package OODesignPatterns.structural;

/**
 * Intent -->
 * Provide a surrogate or placeholder for another object to control access to it.
 * Use an extra level of indirection to support distributed, controlled, or intelligent access.
 * Add a wrapper and delegation to protect the real component from undue complexity.
 *
 * Also know as Surrogate
 *
 * Applicability
 * Proxy is applicable whenever there is a need for a more versatile or sophisticated reference to an object than a simple pointer.
 *  Here are several common situations in which the Proxy pattern is applicable:
 * 1. A remote proxy provides a local representative for an object in a different address space. NEXTSTEP [Add94] uses the
 *    class NXProxy for this purpose. Coplien [Cop92] calls this kind of proxy an "Ambassador."
 * 2. A virtual proxy creates expensive objects on demand. The ImageProxy described in the Motivation is an example of such a proxy.
 * 3. A protection proxy controls access to the original object. Protection proxies are useful when objects should have different access
 *    rights. For example, KernelProxies in the Choices operating system [CIRM93] provide protected access to operating system objects.
 * 4. A smart reference is a replacement for a bare pointer that performs additional actions when an object is accessed. Typical uses include
 *    1. o counting the number of references to the real object so that it can be freed automatically when there are no more references (also called
 *       smart pointers [Ede92]).
 *    2. o loading a persistent object into memory when it's first referenced.197 o checking that the real object is locked before it's accessed to
 *       ensure that no other object can change it.
 */
public class Proxy {

    /**
     * There are four common situations in which the Proxy pattern is applicable.
     * A virtual proxy --> is a placeholder for "expensive to create" objects. The real object is only created when a
     * client first requests/accesses the object.
     * <p>
     * <p>
     * A remote proxy  --> provides a local representative for an object that resides in a different address space.
     * This is what the "stub" code in RPC and CORBA provides.
     * <p>
     * <p>
     * A protective proxy --> controls access to a sensitive master object. The "surrogate" object checks that the
     * caller has the access permissions required prior to forwarding the request.
     * <p>
     * <p>
     * A smart proxy --> interposes additional actions when an object is accessed.
     * Typical uses include:
     * 1. Counting the number of references to the real object so that it can be freed automatically when there
     * are no more references (aka smart pointer),
     * 2. Loading a persistent object into memory when it's first referenced,
     * 3. Checking that the real object is locked before it is accessed to ensure that no other object can change it.
     */
    private interface ExpensiveObject {
        void process();
    }

    private static class ExpensiveObjectImpl implements ExpensiveObject {

        public ExpensiveObjectImpl() {
            heavyInitialConfiguration();
        }

        @Override
        public void process() {
            System.out.println("processing complete.");
        }

        private void heavyInitialConfiguration() {
            System.out.println("Loading initial configuration...");
        }
    }

    private static class ExpensiveObjectProxy implements ExpensiveObject {
        private ExpensiveObject object;

        @Override
        public void process() {
            if (object == null) {
                object = new ExpensiveObjectImpl();
            }
            object.process();
        }
    }

    // Client
    public static void main(String[] args) {
        ExpensiveObject object = new ExpensiveObjectProxy();
        object.process();
        object.process();
    }

}
