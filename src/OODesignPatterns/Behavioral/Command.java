package OODesignPatterns.Behavioral;

import java.util.*;

/**
 * Intent - Encapsulate a request as an object, thereby letting you parameterize clients with different requests,
 *          queue or log requests, and support undoable operations.
 * Also Known as - Action, Transaction
 *
 *
 *
 * Command decouples the object that invokes the operation from the one that knows how to perform it.
 * To achieve this separation, the designer creates an abstract base class that maps a receiver with an action .
 * The base class contains an execute() method that simply calls the action on the receiver.
 *
 *
 * Applicability
 * Use the Command pattern when you want to
 * • parameterize objects by an action to perform, You can express such parameterization in a procedural language with a
 *   callback function, that is, a function that's registered somewhere to be called at a later point. Commands are an object-oriented replacement for callbacks.
 * • specify, queue, and execute requests at different times. A Command object can have a lifetime independent of the original request.
 *   If the receiver of a request can be represented in an address space-independent way, then you can transfer a command object for the request
 *   to a different process and fulfill the request there.
 * • support undo. The Command's Execute operation can store state for reversing its effects in the command itself. The Command interface must have
 *   an added Unexecute operation that reverses the effects of a previous call to Execute. Executed commands are stored in a history list. Unlimited-level
 *   undo and redo is achieved by traversing this list backwards and forwards calling Unexecute and Execute, respectively.
 * • support logging changes so that they can be reapplied in case of a system crash. By augmenting the Command interface with load and store operations,
 *   you can keep a persistent log of changes. Recovering from a crash involves reloading logged commands from disk and reexecuting them with the Execute
 *   operation.
 * • structure a system around high-level operations built on primitives operations. Such a structure is common in information systems that support
 *   transactions. A transaction encapsulates a set of changes to data. The Command pattern offers a way to model transactions. Commands have a common interface,
 *   letting you invoke all transactions the same way. The pattern also makes it easy to extend the system with new transactions.
 *
 */
public class Command {

    private interface CommandInterface {
        void play();

        void pause();
    }

    private static class Audio implements CommandInterface {

        @Override
        public void play() {
            System.out.println("Audio is playing");
        }

        @Override
        public void pause() {
            System.out.println("Video is playing");
        }
    }

    private static class Video implements CommandInterface {

        @Override
        public void play() {
            System.out.println("Video is playing");
        }

        @Override
        public void pause() {
            System.out.println("Video is playing");
        }
    }

    private static class Game implements CommandInterface {

        @Override
        public void play() {
            System.out.println("Game is playing");
        }

        @Override
        public void pause() {
            System.out.println("Game is playing");
        }
    }


    private static class ExecutorFactory {
        private Queue<CommandInterface> queue = new PriorityQueue<CommandInterface>();

        {
            queue.add(new Audio());
            queue.add(new Video());
            queue.add(new Game());
        }

        public void executePlayCommand() {
            queue.peek().play();
        }

        public void executePauseCommand() {
            queue.peek().pause();
        }
    }

    public static void main(String[] args) {
        ExecutorFactory executorFactory = new ExecutorFactory();
        executorFactory.executePlayCommand();
        executorFactory.executePauseCommand();
    }

}
