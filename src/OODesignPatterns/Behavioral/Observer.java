package OODesignPatterns.Behavioral;

import java.util.HashSet;

/**
 * intent --The Observer pattern is mostly used when you have an object or a set of objects (known as the Observers) that want
 * to be informed/updated about any changes in the state of one or more objects (known as the Observables or Subjects).
 *
 * Also Known as -- Dependents, Publish-Subscribe.
 *
 *
 * Applicability
 * Use the Observer pattern in any of the following situations:
 * • When an abstraction has two aspects, one dependent on the other. Encapsulating these aspects in separate objects
 *   lets you vary and reuse them independently.
 * • When a change to one object requires changing others, and you don't know how many objects need to be changed.
 * • When an object should be able to notify other objects without making assumptions about who these objects are. In
 *   other words, you don't want these objects tightly coupled.
 */
public class Observer {

    private interface ObserverInterface {
        void observerState(STATE value);
    }

    private static class View1 implements ObserverInterface {
        @Override
        public void observerState(STATE value) {
            System.out.println(" fresh data for view1 is : " + value);
        }
    }

    private static class View2 implements ObserverInterface {
        @Override
        public void observerState(STATE value) {
            System.out.println(" fresh data for view2 is : " + value);
        }
    }

    private static class Model {
        private STATE modelState;
        private HashSet<ObserverInterface> observerHashSet = new HashSet<>();

        public void addObserver(ObserverInterface observer) {
            observerHashSet.add(observer);
        }

        public void removeObserver(ObserverInterface observer) {
            observerHashSet.add(observer);
        }

        private void execute() {
            for (ObserverInterface observer : observerHashSet) {
                observer.observerState(modelState);
            }
        }

        public void setState(STATE state) {
            this.modelState = state;
            execute();
        }
    }

    private enum STATE {
        STATE1, STATE2, STATE3;
    }

    public static void main(String[] args) {
        Model notifier = new Model();
        notifier.addObserver(new View1());
        notifier.addObserver(new View2());
        notifier.setState(STATE.STATE1);
        notifier.setState(STATE.STATE2);
        notifier.setState(STATE.STATE3);
    }
}
