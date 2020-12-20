package OODesignPatterns.creational.abstractfactory.abf;


import OODesignPatterns.creational.abstractfactory.AbstractFactory;

public class EmberToolkit extends AbstractFactory {
    @Override
    public CPU createCPU() {
        return new EmberCPU();
    }

    @Override
    public MMU createMMU() {
        return new EmberMMU();
    }
}
