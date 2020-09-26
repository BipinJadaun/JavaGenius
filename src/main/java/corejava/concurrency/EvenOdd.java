package corejava.concurrency;

public class EvenOdd {

	public static void main(String[] args) {
		Object obj = new Object();
		int maxLimit = 20;
		
		Thread t1 = new Thread(new PrintEvenOdd(obj, maxLimit));
		Thread t2 = new Thread(new PrintEvenOdd(obj, maxLimit));
		t1.setName("even");
		t2.setName("odd");
		t1.start();
		t2.start();		
	}
}

class PrintEvenOdd implements Runnable{
	
	Object lock;
	int maxLimit;
	volatile static int i = 1;
	
	public PrintEvenOdd(Object lock, int maxLimit) {
		this.lock = lock;
		this.maxLimit = maxLimit;
	}
	
	@Override
	public void run() {
		while(i <= maxLimit) {
			if(i%2 == 1 && Thread.currentThread().getName().equals("odd")) {
				synchronized(lock) {
					System.out.println(Thread.currentThread().getName() + " " + i);
					i++;					
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(i%2 == 0 && Thread.currentThread().getName().equals("even")) {
				synchronized(lock) {
					System.out.println(Thread.currentThread().getName() + " " + i);
					i++;
					lock.notify();
				}
			}			
		}
	}	
}
