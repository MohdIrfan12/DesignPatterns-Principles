package OODesignPatterns.structural;

/**
 * intent here is - Attach additional responsibilities to an object dynamically. Decorators provide a flexible
 * alternative to subclassing for extending functionality. also known as Wrapper
 *
 *
 * Applicability
 * • to add responsibilities to individual objects dynamically and transparently, that is, without affecting other objects.
 * • for responsibilities that can be withdrawn.
 * • when extension by subclassing is impractical. Sometimes a large number of independent extensions are possible and would produce
 *   an explosion of subclasses to support every combination. Or a class definition may be hidden or otherwise unavailable for subclassing.
 */
public class Decorator {

    private static abstract class Pizza {
        // it is an abstract pizza
        String description = "Unkknown Pizza";

        public String getDescription() {
            return description;
        }

        public abstract int getCost();
    }

    // Concrete pizza classes
    private static class FarmHouse extends Pizza {
        public FarmHouse() {
            description = "FarmHouse";
        }

        public int getCost() {
            return 200;
        }
    }

    private static class Margherita extends Pizza {
        public Margherita() {
            description = "Margherita";
        }

        public int getCost() {
            return 100;
        }
    }

    private static abstract class ToppingsDecorator extends Pizza {
        public abstract String getDescription();
    }

    private static class Barbeque extends ToppingsDecorator {
        Pizza pizza;

        public Barbeque(Pizza pizza) {
            this.pizza = pizza;
        }

        public String getDescription() {
            return pizza.getDescription() + ", Barbeque ";
        }

        public int getCost() {
            return 90 + pizza.getCost();
        }
    }

    private static class Paneer extends ToppingsDecorator {
        Pizza pizza;

        public Paneer(Pizza pizza) {
            this.pizza = pizza;
        }

        public String getDescription() {
            return pizza.getDescription() + ", Paneer ";
        }

        public int getCost() {
            return 70 + pizza.getCost();
        }
    }

    public static void main(String args[]) {
        // create new margherita pizza
        Pizza pizza = new Margherita();
        System.out.println(pizza.getDescription() + " Cost :" + pizza.getCost());

        // create new FarmHouse pizza
        Pizza pizza2 = new FarmHouse();

        //decorate it with paneer topping
        pizza2 = new Paneer(pizza2);
        System.out.println(pizza2.getDescription() + " Cost :" + pizza2.getCost());

        Pizza pizza3 = new Barbeque(null);    //no specific pizza
        System.out.println(pizza3.getDescription() + "  Cost :" + pizza3.getCost());
    }
}
