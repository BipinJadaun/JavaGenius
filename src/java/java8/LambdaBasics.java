package java.java8;

interface Greeting{
	public void wishes();
}

class MorningGreeting implements Greeting{
	@Override
	public void wishes() {
		System.out.println("Good Morning!");		
	}	
}


public class LambdaBasics {	
	public void sendWishes(Greeting greetings) {
		greetings.wishes();
	}

	public static void main(String[] args) {
		LambdaBasics basic = new LambdaBasics();
		// 1st way
		MorningGreeting morningGreeting1 = new MorningGreeting();
		basic.sendWishes(morningGreeting1);

		//2nd way
		Greeting morningGreeting2 = new Greeting() {
			@Override
			public void wishes() {
				System.out.println("Good Morning!");				
			}			
		};
		basic.sendWishes(morningGreeting2);

		//3rd way - using lambda expression		
		Greeting morningGreeting3 = ()-> { 
			System.out.println("Good Morning!");
		};
		basic.sendWishes(morningGreeting3);
	}
}
