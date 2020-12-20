package OODesignPatterns.structural;

/**
 *
 * Intent -- Convert the interface of a class into another interface clients expect. Adapter lets classes work together
 * that couldn't otherwise because of incompatible interfaces.
 *
 *
 *
 * Applicability
 * • you want to use an existing class, and its interface does not match the one you need.
 * • you want to create a reusable class that cooperates with unrelated or unforeseen classes, that is, classes that
 *   don't necessarily have compatible interfaces.
 * • (object adapter only) you need to use several existing subclasses, but it's impractical to adapt their interface
 *   by subclassing every one. An object adapter can adapt the interface of its parent class.
 *
 */
public class Adapter {

    private interface Bird {
          void fly();
          void makeSound();
    }

    private static class Sparrow implements Bird {
        @Override
        public void fly() {
            System.out.println("Flying");
        }

        public void makeSound() {
            System.out.println("Chirp Chirp");
        }
    }

    private interface ToyDuck {
          void squeak();
    }

    private static class PlasticToyDuck implements ToyDuck {
        public void squeak() {
            System.out.println("Squeak");
        }
    }


    private static class BirdAdapter implements ToyDuck {
        // we need to implement the interface our client expects to use.
        private Bird bird;

        BirdAdapter(Bird bird) {
            // we need reference to the object we are adapting
            this.bird = bird;
        }

        public void squeak() {
            // translate the methods appropriately
            bird.makeSound();
        }
    }

    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        ToyDuck toyDuck = new PlasticToyDuck();

        System.out.println("Sparrow...");
        sparrow.fly();
        sparrow.makeSound();

        System.out.println("ToyDuck...");
        toyDuck.squeak();

        // to make toy duck behaving like a bird Wrap a bird in a birdAdapter so that it, behaves like toy duck
        ToyDuck birdAdapter = new BirdAdapter(sparrow);
        System.out.println("BirdAdapter...");
        birdAdapter.squeak();
    }
}
