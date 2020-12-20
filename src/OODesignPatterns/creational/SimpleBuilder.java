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
public class SimpleBuilder {

    private static class Library {
        private String book;
        private String author;
        private int price;

        static class Builder {
            private String book;
            private String author;
            private int price;

            public Builder() {
            }

            public Builder setBook(String book) {
                this.book = book;
                return this;
            }

            public Builder setAuthor(String author) {
                this.author = author;
                return this;
            }

            public Builder setPrice(int price) {
                this.price = price;
                return this;
            }

            public Library build() {
                Library obj = new Library();
                obj.author = author;
                obj.book = book;
                obj.price = price;
                return obj;
            }
        }

        void display() {
            System.out.println("Name of the Book is :" + book + ", author :" + author + ", and price :" + price);
        }
    }

    public static void main(String[] args) {
        Library library = new Library.Builder()
                .setAuthor("Robert")
                .setBook("my biography")
                .setPrice(120).build();
        library.display();
    }
}
