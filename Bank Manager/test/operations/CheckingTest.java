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
public class CheckingTest {
    
    public CheckingTest() {
    }


    @Test
    public void testWithdrawl() {
        System.out.println("withdrawl");
        double withdrawlAmount = 20.0;
        Checking instance = new Checking(50);
        double expResult = 30.0;
        double result = instance.withdrawl(withdrawlAmount);
        assertEquals(expResult, result, 0.0);
    }
    
        @Test
    public void testWithdrawl1() {
        System.out.println("withdrawl1");
        double withdrawlAmount = 60.0;
        Checking instance = new Checking(50);
        double expResult = -20.0;
        double result = instance.withdrawl(withdrawlAmount);
        assertEquals(expResult, result, 0.0);
    }
    
}
