package OODesignPatterns.Behavioral;

/**
 * Intent -- Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the
 * request. Chain the receiving objects and pass the request along the chain until an object handles it.
 *
 *
 * Applicability
 * • more than one object may handle a request, and the handler isn't known a priori. The handler should be ascertained automatically.
 * • you want to issue a request to one of several objects without specifying the receiver explicitly.
 * • the set of objects that can handle a request should be specified dynamically.
 */
public class ChainOfResponsibility {


    private interface Task {
        String process();
    }

    private static class Task1 implements Task {
        public String process() {
            return "Task1";
        }
    }

    private static class Task2 implements Task {
        public String process() {
            return "Task2";
        }
    }

    private static class Processor {
        private boolean isbusy;

        public Processor(boolean isbusy) {
            this.isbusy = isbusy;
        }

        public boolean isIsbusy() {
            return isbusy;
        }


        public boolean execute(Task task) {
            if (isbusy) {
                System.out.println("Processor is busy");
                return isbusy;
            }
            System.out.println("Processor " + " - " + task.process());
            isbusy = true;
            return isbusy;
        }
    }

    public static void main(String[] args) {
        Task[] tasks = {new Task1(), new Task2(), new Task2()};
        Processor[] multicoreProcessor = {new Processor(false), new Processor(false), new Processor(false)};

        for (int i = 0; i < tasks.length; i++) {
            System.out.println("Operation #" + (i + 1) + ":");
             for (Processor processor : multicoreProcessor) {
                if (!processor.isIsbusy()) {
                    processor.execute(tasks[i]);
                    break;
                }
            }
        }
    }

}
