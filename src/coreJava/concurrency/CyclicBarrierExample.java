package coreJava.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

class MyRunnable1 implements Runnable{
	
	private final CyclicBarrier barrier;	

	public MyRunnable1(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		System.out.println("inside MyRunnable Thread "+ Thread.currentThread().getName());
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
}

public class CyclicBarrierExample {
	
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3, ()-> {
			System.out.println("barrier has been breached, lets play..");
		});
		
		Thread t1 = new Thread(new MyRunnable1(barrier));
		Thread t2 = new Thread(new MyRunnable1(barrier));
		Thread t3 = new Thread(new MyRunnable1(barrier));
		
		t1.start();
		t2.start();
		t3.start();		
	}
}
