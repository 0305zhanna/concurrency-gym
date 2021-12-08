package com.epam.concurrencygym.ex5;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

public class Main {

  private static final int POOL_SIZE = 50;
  private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(POOL_SIZE);

  public static void main(String[] args) throws InterruptedException {
    CyclicBarrier barrier = new CyclicBarrier(POOL_SIZE);
    CountDownLatch done = new CountDownLatch(POOL_SIZE);
    Account account = new Account(100);
    Random random = new Random(41);
    for (int i = 0; i < POOL_SIZE; i++) {
      run(random.nextInt() % 3 == 0
              ? account::deposit
              : account::withdraw,
          Math.abs(random.nextInt(100)),
          barrier,
          done);
    }
    done.await();
    System.out.printf("Account balance is %d%n", account.getBalance());
    EXECUTOR.shutdown();
  }

  private static Future<?> run(Consumer<Integer> operation, int amount, CyclicBarrier barrier, CountDownLatch done) {
    return EXECUTOR.submit(() -> {
      try {
        barrier.await();
      } catch (InterruptedException | BrokenBarrierException ex) {
        throw new RuntimeException(ex);
      }
      operation.accept(amount);
      done.countDown();
    });
  }
}
