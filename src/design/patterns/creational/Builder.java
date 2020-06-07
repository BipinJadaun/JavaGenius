package design.patterns.creational;

/**
 * @author vipin
 * Imagine you want a customized pizza deal, e.g which size do you want? what types of toppings would you like?
 * What cheese would you want? etc. In such cases builder pattern comes to the rescue.
 * In object-oriented programming (OOP),
 * Builder pattern allows you to create different flavors of an object while avoiding constructor pollution.
 * Useful when there could be several flavors of an object.
 * Or when there are a lot of steps involved in creation of an object.
 */
public class Builder {
    public static void main(String[] args) {
        Pizza customPizza = new PizzaBuilder("Large")
                .addCapsicum(true)
                .addExtraCheese(true)
                .addCorn(true)
                .addOnion(true)
                .build();

        System.out.println(String.format("your ordered %s Pizza with %s, %s, %s, %s, %s.",
                customPizza.size,
                customPizza.extraCheese ? "extraCheese" : "no extraCheese",
                customPizza.onion ? "onion" : "no onion",
                customPizza.capsicum ? "capsicum" : "no capsicum",
                customPizza.corn ? "corn" : "no corn",
                customPizza.jalapeno ? "and jalapeno" : "and no jalapeno"));
    }
}

class Pizza{
    public String size;
    public boolean extraCheese;
    public boolean onion;
    public boolean capsicum;
    public boolean corn;
    public boolean jalapeno;


    Pizza(PizzaBuilder pizzaBuilder) {
        this.size = pizzaBuilder.size;
        this.extraCheese = pizzaBuilder.extraCheese;
        this.onion = pizzaBuilder.onion;
        this.capsicum = pizzaBuilder.capsicum;
        this.corn = pizzaBuilder.corn;
        this.jalapeno = pizzaBuilder.jalapeno;
    }
}

class PizzaBuilder {
    public String size;
    public boolean extraCheese;
    public boolean onion;
    public boolean capsicum;
    public boolean corn;
    public boolean jalapeno;

    PizzaBuilder(String size) {
        this.size = size;
    }
    PizzaBuilder addExtraCheese(boolean flag){
        this.extraCheese = flag;
        return this;
    }
    PizzaBuilder addCapsicum(boolean flag){
        this.capsicum = flag;
        return this;
    }
    PizzaBuilder addOnion(boolean flag){
        this.onion = flag;
        return this;
    }
    PizzaBuilder addCorn(boolean flag){
        this.corn = flag;
        return this;
    }
    PizzaBuilder addJalapeno(boolean flag){
        this.jalapeno = flag;
        return this;
    }
    Pizza build(){
        return new Pizza(this);
    }
}
