package OODesignPatterns.creational;

/**
 * Intent - Separate the construction of a complex object from its representation so that the
 * same construction process can create different representations.
 * <p>
 * <p>
 * Applicability
 * • the algorithm for creating a complex object should be independent of the parts that make up the object and how they're assembled.
 * • the construction process must allow different representations for the object that's constructed.
 */

public class TypicalBuilder {

    /**
     * problem - wre are building a house what items we need -
     * 1. a basic plan.
     * 2. builder who would build that house.
     * 3. civil engineer who verifies that house
     * <p>
     * you must have noticed, correct house object creation is complex task. that's where builder pattern fits in.
     */
    private interface HousePlan {
        public void setStructure(String structure);
        public void setRoof(String roof);
        public void setBasement(String basement);
    }

    private static class House implements HousePlan {
        private String structure;
        private String roof;
        private String basement;

        @Override
        public void setStructure(String structure) {
            this.structure = structure;
        }

        @Override
        public void setRoof(String roof) {
            this.roof = roof;
        }

        @Override
        public void setBasement(String basement) {
            this.basement = basement;
        }
    }

    private interface HouseBuilder {
        void buildBasement();
        void buildStructure();
        void buildRoof();
        House getHouse();
    }

    private static class BanglawBuilder implements HouseBuilder {
        private House house;

        public BanglawBuilder() {
            this.house = new House();
        }

        public void buildBasement() {

            house.setBasement("make Banglaw basement spacious");
        }

        public void buildStructure() {
            house.setStructure("make nice banglaw Structure");
        }

        public void buildRoof() {
            house.setRoof("banglaw's roof must be");
        }

        public House getHouse() {
            return house;
        }
    }

    private static class CivilEngineer {
        private HouseBuilder builder;

        public CivilEngineer(HouseBuilder houseBuilder) {
            this.builder = houseBuilder;
        }

        public House getHouse() {
            return builder.getHouse();
        }

        public void constructHouse() {
            builder.buildBasement();
            builder.buildStructure();
            builder.buildRoof();
        }
    }

    public static void main(String[] args) {
        HouseBuilder banglawBuilder = new BanglawBuilder();
        CivilEngineer engineer = new CivilEngineer(banglawBuilder);
        engineer.constructHouse();
        House house = engineer.getHouse();
        System.out.println("constructed house is : " + house);
    }
}
