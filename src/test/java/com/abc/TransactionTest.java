package com.abc;

import java.util.Date;
import org.junit.Test;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class TransactionTest {
    
    /*
    ** Test Plan
    **Create a new instance with a test amount
    ** The instance should store the amount and transcaction date
    ** Check that an instanace was created
    ** check the amount is correct
    ** Check the transaction date
    */
    
    
    
    
    @Test
    public void testTransaction() {
        
        // test amount
        double testAmount = 100.00;
        
        // create a new instance of the class
        Transaction test = new Transaction(testAmount);
        
        
        // Check if instance was created
        assertTrue(test instanceof Transaction);
        
        
        
    }
    
    @Test
    public void testTransactionAmount(){
        
     
        
        
         // test amount
        double testAmount = 100.00;
        
        // create a new instance of the class
        Transaction test = new Transaction(testAmount);
        
        // check if the amounts match
        assertEquals(testAmount, test.getAmount(),testAmount);

    
    }
    
    
    @Test
    public void testTransactionDate(){
        
     
         // test amount
        double testAmount = 100.00;
        
         // test date
        Date transactionDate = DateProvider.getInstance().now();
        
        // create a new instance of the class
        Transaction test = new Transaction(testAmount);
        
        // check if the amounts match
        assertEquals(transactionDate, test.getDate());

    
    }
    
    
}
