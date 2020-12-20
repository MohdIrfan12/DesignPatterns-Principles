package OODesignPatterns.creational.abstractfactory.abf;

public abstract class CPU {

    public void executeInstructionSet() {
        System.out.println("=======CPU executing instructions");
    }

    public abstract String getCPUName();

}
