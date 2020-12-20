package OODesignPatterns.creational;


import java.util.HashMap;
import java.util.Map;

/**
 * Intent -->
 * Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.
 * client should not call new keyword
 * <p>
 * Applicability
 * Use the Prototype pattern when a system should be independent of how its products are created, composed, and
 * represented; and
 * • when the classes to instantiate are specified at run-time, for example, by dynamic loading; or
 * • to avoid building a class hierarchy of factories that parallels the class hierarchy of products; or
 * • when instances of a class can have one of only a few different combinations of state. It may be more convenient to
 * install a corresponding number of prototypes and clone them rather than instantiating the class manually, each time with
 * the appropriate state.
 */
public class Prototype {

    private interface Whicle {
        Whicle getClone();
    }

    private static class Car implements Whicle {
        private String tierType;
        private String engine;
        private int lenght;

        public Car(String tierType, String engine, int lenght) {
            this.tierType = tierType;
            this.engine = engine;
            this.lenght = lenght;
        }

        @Override
        public Whicle getClone() {
            Car obj = new Car(tierType, engine, lenght);
            return obj;
        }
    }

    private static class Truck implements Whicle {
        private String tierType;
        private String engine;
        private int lenght;

        public Truck(String tierType, String engine, int lenght) {
            this.tierType = tierType;
            this.engine = engine;
            this.lenght = lenght;
        }

        @Override
        public Whicle getClone() {
            Truck obj = new Truck(tierType, engine, lenght);
            return obj;
        }
    }

    private static class Factory {
        private static final Map<String, Whicle> prototypes = new HashMap<>();

        static {
            prototypes.put("Car", new Car("Flat Tyres", "Inline", 12));
            prototypes.put("Truck", new Truck("Flat Tyres", "Inline", 25));
        }

        private static Whicle getPrototype(String type) {
            try {
                return prototypes.get(type).getClone();
            } catch (NullPointerException ex) {
                System.out.println("we do not manufacture : " + type);
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Whicle car = Factory.getPrototype("Car");
        Whicle truck = Factory.getPrototype("Truck");
        Whicle bicycle = Factory.getPrototype("bicycle");
    }
}
