package com.epam.concurrencygym.ex2;

import java.util.concurrent.TimeUnit;

public class Waiter {

  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      try {
        TimeUnit.SECONDS.sleep(5);
      } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
      System.out.println("Exiting");
    });

    thread.start();

//  thread.?(TimeUnit.SECONDS.toMillis(10));

    System.out.println("Done");
  }
}
