package OODesignPatterns.Behavioral;

/**
 * intent- is allowing an object to alter its behavior when its internal state changes.The object will appear to change its class.
 * Also Known as - Objects for States.
 *
 * it is mostly used when your use case can be represented as a finite state machine. it's is also one of it's objective of this design pattern.
 *
 * Use the State pattern in either of the following cases:
 * • An object's behavior depends on its state, and it must change its behavior at run- time depending on that state.
 * • Operations have large, multipart conditional statements that depend on the object's state. This state is usually
 *   represented by one or more enumerated constants. Often, several operations will contain this same conditional structure.
 *   The State pattern puts each branch of the conditional in a separate class. This lets you treat the object's state as an
 *   object in its own right that can vary independently from other objects. let's explain it by designing  custom thread class
 */
public class State {

    private interface ThreadState {
        void performAction(ThreadContext thread);
    }

    private static class ThreadContext {
        private ThreadState threadState;

        private ThreadContext() {
            threadState = new NewState();
        }

        private void setState(ThreadState state) {
            this.threadState = state;
        }

        private void start() {
            threadState.performAction(this);
        }
    }

    private static class NewState implements ThreadState {
        private NewState() {
            System.out.println("thread has in new/created state. create stack trace and copy variables");
        }

        @Override
        public void performAction(ThreadContext thread) {
            StartedState startedState = new StartedState();
            thread.setState(startedState);
            startedState.performAction(thread);
        }
    }

    private static class StartedState implements ThreadState {
        @Override
        public void performAction(ThreadContext thread) {
            System.out.println("thread is in started state. executing request now.");
            TerminateState state = new TerminateState();
            thread.setState(state);
            state.performAction(thread);
        }
    }

    private static class TerminateState implements ThreadState {

        @Override
        public void performAction(ThreadContext thread) {
            System.out.println("thread is about to terminate perform cleanup operation before this block is executed");
            /**
             *
             *
             *
             */
            thread.setState(this);
            System.out.println("Terminated");
        }
    }

    public static void main(String[] args) {
        ThreadContext thread = new ThreadContext();
        thread.start();
    }
}
