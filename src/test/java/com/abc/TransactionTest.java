package com.abc;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransactionTest {


    Transaction t = new Transaction(5.0);
    Account account = new Account(1);

    @BeforeEach
    public void setUp(){
   

    }

    @AfterEach
    public void tearDown() {



    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public void tearDownClass() {

    account.clearTransactions();
    }

    @Test
    public void transactionDeposit() {

        account.deposit(t);
        List<Transaction> transactions = account.getTransactions();
        // Check the data is equal
        assertEquals(5.0,
                t.getAmount(),0);
        assertEquals(transactions.get(0).getAmount(),t.getAmount(),0);
    }

    @Test
    public void transactionWithDraw(){

        account.withdraw(2.0);
        List<Transaction> transactions = account.getTransactions();


        assertEquals(-2.0,transactions.get(0).getAmount(),0);
    }


}
