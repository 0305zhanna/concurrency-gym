package com.epam.concurrencygym.ex3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Make the necessary changes to have the counter always set to 50 when it is printed.
 */
public class Counter1 {

  private static final int POOL_SIZE = 50;

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
    AtomicInteger counter = new AtomicInteger(0);
    //final ? ready = new ?(POOL_SIZE);

    for (int i = 0; i < POOL_SIZE; i++) {
      executor.submit(() -> {
        counter.incrementAndGet();
        System.out.printf("Thread %s is completed%n", Thread.currentThread().getName());
        //ready.?
      });

    }
    //ready. ?
    System.out.println(counter.get());
    executor.shutdown();
  }
}
