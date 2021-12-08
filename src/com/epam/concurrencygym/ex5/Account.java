package com.epam.concurrencygym.ex5;

/**
 * Make the following code below thread safe.
 * 1. Using synchronized keyword
 * 2. Using a synchronizer from java.util.concurrent.*
 */
public class Account {

  private int balance;

  public Account(int balance) {
    this.balance = balance;
  }

  public void withdraw(int amount) {

    System.out.printf("Withdraw %d%n", amount);
    if (balance >= amount) {
      balance -= amount;
    }
  }

  public void deposit(int amount) {

    System.out.printf("Deposit %d%n", amount);
    balance += amount;
  }

  public int getBalance() {

    return balance;
  }
}
