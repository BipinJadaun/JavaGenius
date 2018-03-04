package coreJava.java8;

public class ThreadExample {

	public static void main(String[] args) {
		
		Thread myThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world inside a thread");				
			}			
		});
		
		myThread.run();
		
		
		//using lambda		
		Thread myThreadUsingLambda = new Thread (()->System.out.println("Hello world inside a thread using lambda"));
		myThreadUsingLambda.run();

	}

}
