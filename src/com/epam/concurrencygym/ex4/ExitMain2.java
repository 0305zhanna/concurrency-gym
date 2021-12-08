package com.epam.concurrencygym.ex4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Make the corresponding change in the program below to allow the program
 * to terminate even if not all the threads are completed (or if they are completed).
 */
public class ExitMain2 {

  private static final int POOL_SIZE = 50;

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE, runnable -> {
      Thread thread = new Thread(runnable);
      // thread.?
      return thread;
    });
    for (int i = 0; i < POOL_SIZE; i++) {
      executor.submit(() -> System.out.printf("Running %s%n", Thread.currentThread().getName()));
    }
  }
}
