package OODesignPatterns.Behavioral;

/**
 * Intent - Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the
 *          algorithm vary independently from clients that use it.
 * Also Known as Policy
 *
 *
 * Applicability
 * Use the Strategy pattern when
 * • many related classes differ only in their behavior. Strategies provide a way to configure a class with one of many behaviors.
 * • you need different variants of an algorithm. For example, you might define algorithms reflecting different space/time trade-offs.
 *   Strategies can be used when these variants are implemented as a class hierarchy of algorithms [HO87].
 * • an algorithm uses data that clients shouldn't know about. Use the Strategy pattern to avoid exposing complex, algorithm-specific data structures.
 * • a class defines many behaviors, and these appear as multiple conditional statements in its operations. Instead of many conditionals,
 *   move related conditional branches into their own Strategy class.
 */
public class Strategy {

    private interface Sorting {
        void sort();
    }

    private static class InsertionSort implements Sorting {
        @Override
        public void sort() {
            System.out.println("====InsertionSort====");
        }
    }

    private static class BubbleSort implements Sorting {
        @Override
        public void sort() {
            System.out.println("====BubbleSort====");
        }
    }

    private static class Client {
        private void performSorting(Sorting sorting) {
            sorting.sort();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.performSorting(new InsertionSort());
        client.performSorting(new BubbleSort());
    }
}
