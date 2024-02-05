package com.hexaware.bankmgmtsys.Task_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankAccountChecker {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    boolean isValidAccount = false;

    Map<Integer, Double> balance = new HashMap<>();
    balance.put(101, 25000.23);
    balance.put(102, 50000.34);
    balance.put(103, 2570.33);
    balance.put(104, 25700.73);

    while (!isValidAccount) {
      System.out.print("Enter your account number: ");
      int userIn = scanner.nextInt();

      if (balance.containsKey(userIn)) {
        isValidAccount = true;
        double accBal = balance.get(userIn);
        System.out.println("Your Account Balance is: " + accBal);
      } else {
        System.out.println("Please enter a valid Acc. No.! \n");
      }
    }

    scanner.close();
  }
}
