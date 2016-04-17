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
public class Checking extends BankAccount {

    BankAccount b = new BankAccount();
    private double balance;

    public Checking() {
    }
    //used for testing
    public Checking(double balance) {
        this.balance = balance;
    }

    public Checking(String name, double balance) {
        super(name);
        this.balance = balance;
    }

    public double withdrawl(double withdrawlAmount) {

        if (getBalance() - withdrawlAmount < 0) {
            setBalance(getBalance() - withdrawlAmount - 10);
            return getBalance();
        } else {
            setBalance(getBalance() - withdrawlAmount);
            return getBalance();
        }

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
