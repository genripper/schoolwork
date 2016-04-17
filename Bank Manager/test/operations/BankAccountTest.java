/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class BankAccountTest {
    
    public BankAccountTest() {
    }
 
    @Test
    public void testCheckPin() {
        System.out.println("checkPin");
        int pin = 123;
        int enteredPin = 123;
        BankAccount instance = new BankAccount();
        boolean expResult = true;
        boolean result = instance.checkPin(pin, enteredPin);
        assertEquals(expResult, result);
    }
    
        public void testCheckPin1() {
        System.out.println("checkPin 1");
        int pin = 123;
        int enteredPin = 13;
        BankAccount instance = new BankAccount();
        boolean expResult = false;
        boolean result = instance.checkPin(pin, enteredPin);
        assertEquals(expResult, result);
    }

    @Test
    public void testWithdrawl() {
        System.out.println("withdrawl");
        double withdrawlAmount = 50.0;
        BankAccount instance = new BankAccount(1000.00);
        double expResult = 950.0;
        double result = instance.withdrawl(withdrawlAmount);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testDeposit() {
        System.out.println("deposit");
        double depositAmount = 100.0;
        BankAccount instance = new BankAccount(500.00);
        double expResult = 600.0;
        double result = instance.deposit(depositAmount);
        assertEquals(expResult, result, 0.0);
    }

    
}
