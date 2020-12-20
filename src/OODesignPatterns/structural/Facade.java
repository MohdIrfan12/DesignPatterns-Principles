package OODesignPatterns.structural;

/**
 * Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface
 * that makes the subsystem easier to use.
 * <p>
 * == As the name suggests, it means the face of the building. The people walking past the road can only see this glass face of the
 * building. They do not know anything about it, the wiring, the pipes and other complexities. It hides all the
 * complexities of the building and displays a friendly face.
 *
 *
 * Applicability
 * • you want to provide a simple interface to a complex subsystem. Subsystems often get more complex as they evolve. Most patterns,
 *   when applied, result in more and smaller classes. This makes the subsystem more reusable and easier to customize, but it also
 *   becomes harder to use for clients that don't need to customize it. A facade can provide a simple default view of the subsystem that
 *   is good enough for most clients. Only clients needing more customizability will need to look beyond the facade.
 * • there are many dependencies between clients and the implementation classes of an abstraction. Introduce a facade to decouple
 *   the subsystem from clients and other subsystems, thereby promoting subsystem independence and portability.
 * • you want to layer your subsystems. Use a facade to define an entry point to each subsystem level. If subsystems are dependent,
 *   then you can simplify the dependencies between them by making them communicate with each other solely through their facades.
 */
public class Facade {

    private static class Menu {
        private String dish;
        private long prince;

        Menu(String dish, long price) {
            this.dish = dish;
            this.prince = price;
        }

        public String getDish() {
            return dish;
        }

        public long getPrince() {
            return prince;
        }
    }

    private interface Hotel {
        public Menu getMenus();
    }

    private static class NonVegRestaurant implements Hotel {
        public Menu getMenus() {
            Menu nv = new Menu("CHiken", 100L);
            return nv;
        }
    }

    private static class VegRestaurant implements Hotel {
        public Menu getMenus() {
            Menu menu = new Menu("Paneer", 100L);
            return menu;
        }
    }

    private static class FacadeFactory {
        public Menu getVegMenu() {
            VegRestaurant v = new VegRestaurant();
            return v.getMenus();
        }

        public Menu getNonVegMenu() {
            NonVegRestaurant v = new NonVegRestaurant();
            return v.getMenus();
        }
    }

    public static void main(String[] args) {
        FacadeFactory keeper = new FacadeFactory();
        Menu vegMenu = keeper.getVegMenu();
        Menu nonVegMenu = keeper.getNonVegMenu();
    }
}
