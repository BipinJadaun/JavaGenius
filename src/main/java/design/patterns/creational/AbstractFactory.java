package design.patterns.creational;

/**
 * Extending the door example from Simple Factory.
 * Based on your needs you might need a wooden door or an iron door.
 * Plus you might need a different fitting expert to fit the door like carpenter or welder.
 * As you can see there is a dependency between the doors and fitting expert.
 * In object-oriented programming (OOP),
 * The abstract factory pattern provides a way to encapsulate a group of individual but related/dependent factories.
 */
public class AbstractFactory {
    public static void main(String[] args) {
        AllDoorFactory ironDoor = FactoryMaker.getFactory("Iron");
        System.out.println(String.format("Door created of type %s with %s",
                ironDoor.getDoor().getDoorType(), ironDoor.getDoorExpert().getExpertise()));
    }
}

//this is the abstract factory which provides factory objects
class FactoryMaker{
    public static AllDoorFactory getFactory(String type){
        switch (type) {
            case "Wooden":
                return new WoodenDoorFactory();
            case "Iron":
                return new IronDoorFactory();
            default:
                return null;
        }
    }
}
interface AllDoorFactory {
    Door getDoor();
    FittingExpert getDoorExpert();
}

class WoodenDoorFactory implements AllDoorFactory {
    @Override
    public Door getDoor() {
        return new WoodenDoor();
    }
    @Override
    public FittingExpert getDoorExpert() {
        return new Carpenter();
    }
}

class IronDoorFactory implements AllDoorFactory {
    @Override
    public Door getDoor() {
        return new IronDoor();
    }
    @Override
    public FittingExpert getDoorExpert() {
        return new Welder();
    }
}
