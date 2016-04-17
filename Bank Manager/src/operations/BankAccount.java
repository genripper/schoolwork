/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import ui.ConsoleIO;

/**
 *
 * @author apprentice
 */
public class BankAccount {

    ConsoleIO io = new ConsoleIO();

    private String name;
    private double balance;

    public BankAccount() {

    }
    //used for testing
    public BankAccount(double balance) {
        this.balance = balance;
    }

    public BankAccount(String name) {
        this.name = name;
    }

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean checkPin(int pin, int enteredPin) {
        if (pin == enteredPin) {
            return true;
        } else {
            return false;
        }

    }

    public double withdrawl(double withdrawlAmount) {
        setBalance(getBalance() - withdrawlAmount);
            return getBalance();

    }

    public double deposit(double depositAmount) {
        setBalance(getBalance() + depositAmount);
            return getBalance();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
