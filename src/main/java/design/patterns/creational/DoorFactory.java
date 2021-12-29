package design.patterns.creational;

import static design.patterns.creational.DoorType.WOODEN;

/**
 * Consider, in your house you need doors. You can either put on your carpenter clothes, bring some wood,
 * glue, nails and all the tools required to build the door and start building it in your house
 * or you can simply call the factory and get the built door delivered to you.
 * In object-oriented programming (OOP),
 * a factory is an object for creating other objects which is assumed to be "new"
 */
public class DoorFactory {

    public static Door getDoor(DoorType type){
        switch (type) {
            case WOODEN:
                return new WoodenDoor();
            case IRON:
                return new IronDoor();
            default:
                return null;
        }
    }
}

enum DoorType{
    WOODEN,
    IRON
}

interface Door {
    DoorType getDoorType();
}
class WoodenDoor implements Door {
    private DoorType type = DoorType.WOODEN;

    @Override
    public DoorType getDoorType() {
        return this.type;
    }
}

class IronDoor implements Door {
    private DoorType type = DoorType.IRON;

    @Override
    public DoorType getDoorType() {
        return this.type;
    }
}

class Test{
    public static void main(String[] args) {
        Door door = DoorFactory.getDoor(WOODEN);
        System.out.println(String.format("Door created of type %s", door.getDoorType()));
    }    }
