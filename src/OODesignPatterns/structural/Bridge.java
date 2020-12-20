package OODesignPatterns.structural;

/**
 * 1. The Bridge design pattern allows you to separate the abstraction from the implementation
 * 2. Intent here is loose coupling.
 *
 *
 * Applicability
 * • you want to avoid a permanent binding between an abstraction and its implementation.
 *   This might be the case, for example, when the implementation must be selected or switched at run-time.
 *
 * • both the abstractions and their implementations should be extensible by subclassing. In this case, the Bridge
 *   pattern lets you combine the different abstractions and implementations and extend them independently.
 *
 * • changes in the implementation of an abstraction should have no impact on clients; that is, their code should not have to be recompiled.
 *
 * • you have a proliferation of classes as shown earlier in the first Motivation diagram. Such a class hierarchy indicates
 *   the need for splitting an object into two parts. Rumbaugh uses the term "nested generalizations" [RBP+91] to refer to such class hierarchies.
 * • you want to share an implementation among multiple objects (perhaps using reference counting), and this fact should be hidden from the client.
 *   A simple example is Coplien's String class [Cop92], in which multiple objects can share the same string representation (StringRep).
 */
public class Bridge {

    //========================== abstraction part =====================

    // abstraction in bridge pattern
    private static abstract class Vehicle {
        protected Workshop workShop1;
        protected Workshop workShop2;

        protected Vehicle(Workshop workShop1, Workshop workShop2) {
            this.workShop1 = workShop1;
            this.workShop2 = workShop2;
        }

        abstract public void manufacture();
    }

    // Refine abstraction 1 in bridge pattern
    private static class Truck extends Vehicle {
        public Truck(Workshop workShop1, Workshop workShop2) {
            super(workShop1, workShop2);
        }

        @Override
        public void manufacture() {
            System.out.print("Car ");
            workShop1.work();
            workShop2.work();
        }
    }

    // Refine abstraction 2 in bridge pattern
    private static class Bycycle extends Vehicle {
        public Bycycle(Workshop workShop1, Workshop workShop2) {
            super(workShop1, workShop2);
        }

        @Override
        public void manufacture() {
            System.out.print("Bike ");
            workShop1.work();
            workShop2.work();
        }
    }


    //========================== Implementor part =====================

    // Implementor for bridge pattern
    private interface Workshop {
        void work();
    }

    // Concrete implementation 1 for bridge pattern
    private static class Produce implements Workshop {
        @Override
        public void work() {
            System.out.print("Produced");
        }
    }

    // Concrete implementation 2 for bridge pattern
    private static class Assemble implements Workshop {
        @Override
        public void work() {
            System.out.print(" And");
            System.out.println(" Assembled.");
        }
    }

    // Demonstration of bridge design pattern
    public static void main(String[] args) {
        Vehicle truck = new Truck(new Produce(), new Assemble());
        truck.manufacture();
        Vehicle bycycle = new Bycycle(new Produce(), new Assemble());
        bycycle.manufacture();
    }

}
