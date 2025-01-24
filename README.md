
Producer-Consumer Problem
You are tasked with implementing a system where:
- multiple producers generate data and multiple consumers process the data. 
- The data is shared using a bounded buffer (queue).

Requirements:
1. Use Java's multithreading capabilities (e.g., Thread, ExecutorService, or higher-level
   abstractions like BlockingQueue).
2. Implement synchronization to prevent race conditions.
3. Ensure the system:
   - Producers should not overfill the buffer.
   - Consumers should wait when the buffer is empty.
4. Demonstrate the program with:
   - 3 producer threads that generate numbers between 1 and 100.
   - 5 consumer threads that consume and print the numbers.
5. Stop the system gracefully after processing 100 items.

Deliverables:
   - Java code implementing the solution.
   - Explanation of how you handled synchronization and ensured thread safety.

Solution:
I use java 21 & maven, 
I create produce class for generating data and
consume class for consume data,
each of these class inheritance from Runnable interface and for creating separate threads
and I used executiveService for defining count of threads in Main class,
and because i used BlockingQueue & AtomicInteger, and these class has by default thread-safe
so i don't use any sync.

