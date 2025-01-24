package com.example.pcp;

import java.util.concurrent.BlockingQueue;

public class Consumer  implements Runnable  {

    private final BlockingQueue<Integer> queue;
    private final int id;
    private  int maxItems = 0;
    private static final Object lock = new Object();
    private static final int MAX_ITEMS = 100;

    public Consumer(BlockingQueue<Integer> queue, int id,  int maxItems) {
        this.queue = queue;
        this.id = id;
        this.maxItems = maxItems;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer number = queue.take();
                synchronized (lock) {
                    maxItems++;
                    System.out.println("Consumer " + id + " consumed: " + number);
                    if (maxItems >= MAX_ITEMS) break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
