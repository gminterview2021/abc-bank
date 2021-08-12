package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TransactionTest {

    public TransactionTest() {
    }
    @Test
    public void transaction() {
        Transaction t = new Transaction(5);
        assertTrue(t instanceof Transaction);
    }
    
    @Test
    public void test1(){
        Transaction t = new Transaction(1000);
        assertTrue(t.amount == 1000);
    }
    
    @Test
    public void test2(){
        Transaction t = new Transaction(3000);
        assertTrue(t.amount == 3000);
    }
    
    @Test
    public void test3(){
        Transaction t = new Transaction(1);
        assertTrue(t.amount == 1);
    }
    
}
