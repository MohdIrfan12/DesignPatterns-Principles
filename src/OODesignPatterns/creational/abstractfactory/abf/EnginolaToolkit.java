package OODesignPatterns.creational.abstractfactory.abf;


import OODesignPatterns.creational.abstractfactory.AbstractFactory;

public class EnginolaToolkit extends AbstractFactory {
    @Override
    public CPU createCPU() {
        return new EnginolaCPU();
    }

    @Override
    public MMU createMMU() {
        return new EnginolaMMU();
    }
}