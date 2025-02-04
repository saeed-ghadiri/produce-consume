package com.example.pcp;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

    private final BlockingQueue<Integer> queue; // has: built-in synchronization, thread safety
    private final int id;
    private final int maxItems;
    private static final AtomicInteger producedCount  = new AtomicInteger(0); //thread-safe without explicit locks

    public Producer(BlockingQueue<Integer> queue, int id, int maxItems) {
        this.queue = queue;
        this.id = id;
        this.maxItems = maxItems;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (producedCount.get() >= maxItems) break;
                int number = ThreadLocalRandom.current().nextInt(1, 101); //thread-safe random number generator
                queue.put(number);
                int updatedCount = producedCount.incrementAndGet();
                System.out.println("Producer " + id + " produced: " + number + " (Total produced count: " + updatedCount + ")");
                if (updatedCount == maxItems) {
                    System.out.println("Producer is stopped");
                    break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve interrupt status
            System.err.println("Producer " + id + " interrupted.");
        }
    }
}
