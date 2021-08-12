package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;

    @Test
    public void customerSummary() {
        Bank bank = new Bank();
        Customer john = new Customer("John");
        john.openAccount(new Account(Account.CHECKING));
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void testCheckingAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.CHECKING);
        Customer bill = new Customer("Bill").openAccount(checkingAccount);
        bank.addCustomer(bill);

        checkingAccount.deposit(100.0);

        assertEquals(0.1, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void TestSavingsAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(1500.0);

        assertEquals(2.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void TestMaxiSavingsAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.MAXI_SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(3000.0);

        assertEquals(170.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }
    
    @Test
    public void TestGetFirstCustomer(){
        // testing function with no customers
        Bank bank = new Bank();
        String noCustomers = bank.getFirstCustomer();
        assertEquals(noCustomers, "Error");
        
        //testing function with single customer
        Account checkingAccount = new Account(Account.MAXI_SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));
        String oneCustomer = bank.getFirstCustomer();
        assertEquals(oneCustomer, "Bill");
        
        //testing function with multipule customer
        Account billsAccount = new Account(Account.MAXI_SAVINGS);
        Account jessicasAccount = new Account(Account.MAXI_SAVINGS);
        Account samAccount = new Account(Account.MAXI_SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(billsAccount));
        bank.addCustomer(new Customer("Jessica").openAccount(jessicasAccount));
        bank.addCustomer(new Customer("Sam").openAccount(samAccount));
        String multipuleCustomer = bank.getFirstCustomer();
        assertEquals(multipuleCustomer, "Bill");
    }

}
