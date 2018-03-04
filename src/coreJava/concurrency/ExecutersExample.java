package coreJava.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutersExample {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();

		Future result;
		for (int i = 0; i < 5; i++) {
			result = executor.submit(() -> System.out.println(Thread.currentThread().getName()));
			try {
				System.out.println(result.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
	}
}
