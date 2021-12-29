package design.patterns.creational;

/*
    this factory class is similar to DoorFactory
 */
public class ExpertFactory {

    public static FittingExpert getFittingExpert(DoorType type){
        switch (type){
            case WOODEN:
                return new Carpenter();
            case IRON:
                return new Welder();
            default:
                return null;
        }
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

class Test1{
    public static void main(String[] args) {
        FittingExpert fittingExpert = ExpertFactory.getFittingExpert(DoorType.WOODEN);
        System.out.println(String.format("expert created with expertise %s", fittingExpert.getExpertise()));
    }
}
