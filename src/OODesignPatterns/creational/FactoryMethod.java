package OODesignPatterns.creational;

/**
 * Intent ----- Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory
 * Method lets a class defer instantiation to subclasses.
 * Also Known As --- "Virtual Constructor"
 * <p>
 * <p>
 * Applicability
 * • a class can't anticipate the class of objects it must create.
 * • a class wants its subclasses to specify the objects it creates.
 * • classes delegate responsibility to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is the delegate.
 */
public class FactoryMethod {

    private interface File {
        void read();

        void write();

        void edit();
    }

    private static class DocFile implements File {

        @Override
        public void read() {
            System.out.println("=======reading doc file");
        }

        @Override
        public void write() {
            System.out.println("=======writing doc file");
        }

        @Override
        public void edit() {
            System.out.println("=======editing doc file");
        }
    }

    private static class PDFFile implements File {

        @Override
        public void read() {
            System.out.println("=======reading PDF file");
        }

        @Override
        public void write() {
            System.out.println("=======writing PDF file");
        }

        @Override
        public void edit() {
            System.out.println("=======editing PDF file");
        }
    }

    private static class TXTFile implements File {

        @Override
        public void read() {
            System.out.println("=======reading TXT file");
        }

        @Override
        public void write() {
            System.out.println("=======writing TXT file");
        }

        @Override
        public void edit() {
            System.out.println("=======editing TXT file");
        }
    }

    private static class FileFactory {
        private File getFile(String planType) {
            if (planType == null) {
                return null;
            }
            if (planType.equalsIgnoreCase("DOC")) {
                return new DocFile();
            } else if (planType.equalsIgnoreCase("PDF")) {
                return new PDFFile();
            } else if (planType.equalsIgnoreCase("TXT")) {
                return new TXTFile();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        FileFactory planFactory = new FileFactory();
        planFactory.getFile("DOC").read();
        planFactory.getFile("PDF").write();
        planFactory.getFile("TXT").edit();
    }
}
