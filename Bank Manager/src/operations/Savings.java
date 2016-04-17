/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

/**
 *
 * @author apprentice
 */
public class Savings extends BankAccount {

    BankAccount b = new BankAccount();
    private double balance;

    public Savings() {
    }

    public Savings(String name, double balance) {
        super(name, balance);

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



