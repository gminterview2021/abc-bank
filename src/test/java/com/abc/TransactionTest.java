package com.abc;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TransactionTest {
    @Test
    public void transaction() {
        Transaction t = new Transaction(5);
        assertTrue(t instanceof Transaction);
    }
    
    @Test
    public void testGetAmount(){
        Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        
        Double getCheckingAccountTransaction = checkingAccount.transactions.get(0).getAmount();
        Double checkingAccountTransaction = 100.00;
        Double checkingAccountTransactionFalse = 200.00;
        
        Double getSavingsAccountTransaction = savingsAccount.transactions.get(0).getAmount();
        Double savingsAccountTransaction = 4000.00;
        Double savingsAccountTransactionFalse = 3000.00;
        
        assertEquals(checkingAccountTransaction, getCheckingAccountTransaction);
        assertEquals(savingsAccountTransaction, getSavingsAccountTransaction);
        assertNotEquals(checkingAccountTransactionFalse, getCheckingAccountTransaction);
        assertNotEquals(savingsAccountTransactionFalse, getSavingsAccountTransaction);
       
    }    
}
