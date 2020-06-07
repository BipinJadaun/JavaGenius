package design.patterns.creational;

public class FactoryModelClasses {
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

enum Expertise{
    CARPENTER,
    WELDER
}

interface FittingExpert{
    Expertise getExpertise();
}

class Carpenter implements FittingExpert {
    private Expertise expertise = Expertise.CARPENTER;
    @Override
    public Expertise getExpertise() {
        return this.expertise;
    }
}

class Welder implements FittingExpert {

    private Expertise expertise = Expertise.WELDER;
    @Override
    public Expertise getExpertise() {
        return this.expertise;
    }
}

