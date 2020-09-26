package corejava.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueExample {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<>(10);
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		executorService.execute(new Consumer(sharedQueue));
		executorService.execute(new Producer(sharedQueue));

		executorService.shutdown();
	}
}

class Consumer implements Runnable{
	
	BlockingQueue<Integer> sharedQueue;
	
	public Consumer(BlockingQueue<Integer> queue) {
		this.sharedQueue = queue;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			try {
				Integer value = sharedQueue.take();
				System.out.println("consumed " + value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}	
}

class Producer implements Runnable{
	
	BlockingQueue<Integer> sharedQueue;
	
	public Producer(BlockingQueue<Integer> queue) {
		this.sharedQueue = queue;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			try {
				System.out.println("produced " + i);
				sharedQueue.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}	
}
