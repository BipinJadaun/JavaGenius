package corejava.java8;

/*
 * Lambda expressions works only for the interfaces which haves only one abstract method
 * so to avoid any addition of new methods in an interface which is being used for lambda expressions
 * annotation FunctionalInterface is used, which prevents any new methods addtion
 */

@FunctionalInterface
interface Greetings{
	public void wishes();	
}

public class FunctionalInterfaces {
	
	public void sendWishes(Greetings greeting) {
		greeting.wishes();
	}

	public static void main(String[] args) {		
		FunctionalInterfaces obj = new FunctionalInterfaces();
		obj.sendWishes(()-> System.out.println("Hello World"));

	}

}
