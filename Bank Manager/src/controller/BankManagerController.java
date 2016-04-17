/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import operations.BankAccount;
import operations.Checking;
import operations.Savings;
import ui.ConsoleIO;

/**
 *
 * @author apprentice
 */
public class BankManagerController {

    BankAccount a = new BankAccount();
    Checking check = new Checking();
    Savings sav = new Savings();
    ConsoleIO io = new ConsoleIO();
    int choice = 0;

    public void run() {

        io.printNewLine("ATM Machine");
        io.printNewLine("-----------");
        int pin = 12345, enteredPin;
        Boolean flag = false;
        int count = 1;

        do {

            if (count == 4) {
                System.exit(0);
            }
            enteredPin = io.getInt("Please enter your pin number: ");
            flag = a.checkPin(pin, enteredPin);
            if (flag == false) {
                io.printNewLine("invalid pin entered");
                io.printNewLine("Attempt " + count + " of 3");
                count++;
            }
        } while (flag == false);

        do {
            io.printNewLine("\n1) Check Balance");
            io.printNewLine("2) Deposit");
            io.printNewLine("3) Withdrawl");
            io.printNewLine("4) Exit");
            choice = io.getInt("\nPlease enter your selection: ", 1, 4);

            switch (choice) {

                case 1:
                    int c = 0;
                    io.printNewLine("\nCheck Balance");
                    io.printNewLine("-------------");
                    io.printNewLine("1) Checking");
                    io.printNewLine("2) Savings");
                    c = io.getInt("Enter your selection: ", 1, 2);

                    switch (c) {

                        case 1:
                            io.printDouble(check.getBalance());
                            break;

                        case 2:
                            io.printDouble(sav.getBalance());
                            break;

                        default:
                            break;
                    }
                    break;

                case 2:
                    c = 0;
                    io.printNewLine("\nDeposit");
                    io.printNewLine("-------");
                    io.printNewLine("1) Checking");
                    io.printNewLine("2) Savings");
                    c = io.getInt("Enter your selection: ", 1, 2);

                    switch (c) {

                        case 1:

                            double depositAmount;
                            io.printNewLine("\nChecking");
                            io.printNewLine("--------");

                            depositAmount = io.getDouble("Enter the amount you"
                                    + " would like to deposit: ");

                            if (depositAmount >= 10000) {
                                io.printNewLine("The  bank manager has been"
                                        + " contacted"
                                        + " to clear your deposited amount."
                                        + " Until deposit amount clears "
                                        + "it is not available.");
                            } else {
                                io.printNewLine("New Balance: " + check.deposit(depositAmount));
                            }
                            break;

                        case 2:
                            io.printNewLine("\nSavings");
                            io.printNewLine("-------");

                            depositAmount = io.getDouble("Enter the amount you"
                                    + " would like to deposit: ");

                            if (depositAmount >= 10000) {
                                io.printNewLine("The bank manager has been"
                                        + " contacted"
                                        + " to clear your deposited amount."
                                        + " Until deposit amount clears "
                                        + "it is not available.");
                            } else {
                                io.printNewLine("New Balance: " + sav.deposit(depositAmount));
                            }
                            break;

                        default:
                            break;
                    }
                    break;

                case 3:
                    c = 0;
                    io.printNewLine("\nWithdrawl");
                    io.printNewLine("---------");
                    io.printNewLine("1) Checking");
                    io.printNewLine("2) Savings");
                    c = io.getInt("Enter your selection: ", 1, 2);

                    switch (c) {

                        case 1:
                            double withdrawlAmount;

                            io.printNewLine("\nChecking");
                            io.printNewLine("--------");

                            withdrawlAmount = io.getDouble("Please enter amount"
                                    + " to withdrawl: ");

                            if (withdrawlAmount > (check.getBalance() + 100)) {
                                io.printNewLine("Overdraft limit exceeded");
                            } else {
                                io.printNewLine("New Balance: " + check.withdrawl(withdrawlAmount));
                            }
                            break;

                        case 2:

                            io.printNewLine("\nSavings");
                            io.printNewLine("-------");

                            withdrawlAmount = io.getDouble("Please enter amount"
                                    + " to withdrawl: ");

                            if (withdrawlAmount > sav.getBalance()) {

                                do {
                                    io.printNewLine("Insufficient funds");
                                    withdrawlAmount = io.getDouble("Please enter"
                                            + " amount to withdrawl: ");
                                } while (withdrawlAmount > sav.getBalance());

                            } else {
                                io.printNewLine("New Balance: " + sav.withdrawl(withdrawlAmount));
                            }
                            break;

                        default:
                            break;
                    }
                    break;

                case 4:
                    System.exit(0);
                    break;
            }
        } while (choice != 4);

    }

}
