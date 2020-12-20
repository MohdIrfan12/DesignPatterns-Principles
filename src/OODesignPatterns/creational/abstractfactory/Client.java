package OODesignPatterns.creational.abstractfactory;

import OODesignPatterns.creational.abstractfactory.abf.Architecture;
import OODesignPatterns.creational.abstractfactory.abf.CPU;
import OODesignPatterns.creational.abstractfactory.abf.MMU;

/**
 * Intent ---- The abstract factory pattern provides a way to encapsulate a group of individual factories that have a common theme
 * without specifying their concrete classes.
 * <p>
 * <p>
 * Applicability
 * 1. a system should be independent of how its products are created, composed, and represented.
 * 2. a system should be configured with one of multiple families of products.
 * 3. a family of related product objects is designed to be used together, and you need to enforce this constraint.
 * 4.  you want to provide a class library of products, and you want to reveal just their interfaces, not their implementations.
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("===EMBER Architecture config===:");
        AbstractFactory factory = AbstractFactory.getFactory(Architecture.EMBER);
        CPU cpu = factory.createCPU();
        System.out.println("===CPU===" + cpu.getCPUName());
        cpu.executeInstructionSet();

        System.out.println("===ENGINOLA Architecture config===:");
        factory = AbstractFactory.getFactory(Architecture.ENGINOLA);
        MMU mmu = factory.createMMU();
        System.out.println("===MMU===" + mmu.getName());
        mmu.perform();
    }
}
