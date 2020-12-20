package Behavioral;

/**
 * Intent - Define the skeleton of an algorithm in an operation, deferring some steps to subclasses.
 *          Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.
 * <p>
 * TemplateMethod strictly follows open close principal.
 *
 *
 * Applicability
 * The Template Method pattern should be used
 * • to implement the invariant parts of an algorithm once and leave it up to subclasses to implement the behavior that can vary.
 * • when common behavior among subclasses should be factored and localized in a common class to avoid code duplication. This
 *   is a good example of "refactoring to generalize" as described by Opdyke and Johnson [OJ93]. You first identify the differences
 *   in the existing code and then separate the differences into new operations. Finally, you replace the differing code with a
 *   template method that calls one of these new operations.
 * • to control subclasses extensions. You can define a template method that calls "hook" operations (see Consequences) at
 *   specific points, thereby permitting extensions only at those points.
 */
public class TemplateMethod {

    private interface Sorting {
        void sort();
    }

    private abstract static class Template implements Sorting {
        @Override
        public void sort() {
            start();
            while (nextTry() && !isSolution()) {
            }
            stop();
        }

        abstract void start();

        abstract boolean nextTry();

        abstract boolean isSolution();

        abstract void stop();
    }


    private static class InsertionSort extends Template {
        private int state = 1;

        private InsertionSort() {
            System.out.println("====InsertionSort====");
            sort();
        }

        protected void start() {
            System.out.print("Start");
        }

        protected void stop() {
            System.out.println("Stop");
        }

        protected boolean nextTry() {
            System.out.print("NextTry-"+state);
            state++;
            return true;
        }

        protected boolean isSolution() {
            System.out.print("IsSolution-" + (state == 3));
            return (state >= 3);
        }
    }


    private static class BubbleSort extends Template {
        private int state = 1;

        private BubbleSort() {
            System.out.println("====BubbleSort====");
            sort();
        }

        protected void start() {
            System.out.print("Start  ");
        }

        protected void stop() {
            System.out.print("Stop");
        }

        protected boolean nextTry() {
            System.out.print("NextTry-");
            state++;
            return true;
        }

        protected boolean isSolution() {
            System.out.print("IsSolution-" + (state == 3) + "  ");
            return (state >= 3);
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
