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