package coreJava.concurrency;

import java.util.concurrent.CountDownLatch;

class MyRunnable implements Runnable{
	
	private final CountDownLatch latch;	

	public MyRunnable(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("inside MyRunnable Thread "+ Thread.currentThread().getName());
		latch.countDown();
	}
	
}

public class CountDownLatchExample {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		
		Thread t1 = new Thread(new MyRunnable(latch));
		Thread t2 = new Thread(new MyRunnable(latch));
		Thread t3 = new Thread(new MyRunnable(latch));
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			latch.await();
			System.out.println("main thread starting..");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
