package com.abc;

import java.util.Calendar;
import java.util.Date;

public class Transaction {
    public final double amount;

    private Date transactionDate;

    public Transaction(double amount) {
        this.amount = amount;
        this.transactionDate = DateProvider.getInstance().now();
    }
    
    public double getAmount() {
        return amount;
    }
    
    @Override
    public String toString() {
        return "Transaction{" + "amount=" + amount + ", transactionDate=" + transactionDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >>> 32));
        hash = 29 * hash + (this.transactionDate != null ? this.transactionDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transaction other = (Transaction) obj;
        if (Double.doubleToLongBits(this.amount) != Double.doubleToLongBits(other.amount)) {
            return false;
        }
        if (this.transactionDate != other.transactionDate && (this.transactionDate == null || !this.transactionDate.equals(other.transactionDate))) {
            return false;
        }
        return true;
    }
}
