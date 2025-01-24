package com.example.pcp;


import java.util.concurrent.*;

public class Main {

	private static final int QUEUE_CAPACITY = 10;
	private static final int MAX_ITEMS = 100;

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
		ExecutorService executor = Executors.newFixedThreadPool(8);
		try {
			// Submit 3 producer tasks
			for (int i = 1; i <= 3; i++) {
				executor.submit(new Producer(queue, i, MAX_ITEMS));
			}

			// Submit 5 consumer tasks
			for (int i = 1; i <= 5; i++) {
				executor.submit(new Consumer(queue, i, MAX_ITEMS));
			}
		} finally {
			// Shutdown after execution
			executor.shutdown();
			try {
				if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
					System.err.println("Forcing shutdown...");
					executor.shutdownNow();
				}
			} catch (InterruptedException e) {
				executor.shutdownNow();
				Thread.currentThread().interrupt();
			}

			System.out.println("All producer and consumer threads have completed execution.");
		}
	}

}

