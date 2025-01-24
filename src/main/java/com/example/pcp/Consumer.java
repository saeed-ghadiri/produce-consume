package com.example.pcp;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer  implements Runnable  {

    private final BlockingQueue<Integer> queue;
    private final int id;
    private final int maxItems;
    private static final AtomicInteger consumedCount = new AtomicInteger(0);

    public Consumer(BlockingQueue<Integer> queue, int id,  int maxItems) {
        this.queue = queue;
        this.id = id;
        this.maxItems = maxItems;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (consumedCount.get() >= maxItems) break;
                int number = queue.take(); // blocks if the queue is empty
                int updatedCount = consumedCount.incrementAndGet();
                System.out.println("Consumer " + id + " consumed: " + number + " (Total consumed count: " + updatedCount + ")");
                if (updatedCount == maxItems) {
                    System.out.println("Consumer is stopped");
                    break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Consumer " + id + " interrupted.");
        }
    }
}
