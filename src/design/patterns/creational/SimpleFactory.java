package design.patterns.creational;

/**
 * Consider, in your house you need doors. You can either put on your carpenter clothes, bring some wood,
 * glue, nails and all the tools required to build the door and start building it in your house
 * or you can simply call the factory and get the built door delivered to you.
 * In object-oriented programming (OOP),
 * a factory is an object for creating other objects which is assumed to be "new"
 */
public class SimpleFactory {
    public static void main(String[] args) {
        Door door = DoorFactory.getDoor("Wooden");
        System.out.println(String.format("Door created of type %s", door.getDoorType()));
    }
}

class DoorFactory{
    public static Door getDoor(String type){
        switch (type) {
            case "Wooden":
                return new WoodenDoor();
            case "Iron":
                return new IronDoor();
            default:
                return null;
        }
    }
}
