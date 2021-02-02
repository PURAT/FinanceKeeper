package com.example.model;

import com.example.exception.ModelException;

import java.util.List;
import java.util.Objects;

public class Account extends Common {

    private String title;
    private Currency currency;
    private double startAmount;
    private double amount;

    public Account(String title, Currency currency, double startAmount) throws ModelException {
        super();
        this.title = title;
        this.currency = currency;
        this.startAmount = startAmount;
    }

    @Override
    public String getValueForBox() {
        return title;
    }

    @Override
    public void checkOnException() throws ModelException {
        if (title.length() == 0)
            throw new ModelException(ModelException.TITLE_EMPTY);
        if (currency == null)
            throw new ModelException(ModelException.CURRENCY_EMPTY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(title, account.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Account{" +
                "title='" + title + '\'' +
                ", currency=" + currency +
                ", startAmount=" + startAmount +
                ", amount=" + amount +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(double startAmount) {
        this.startAmount = startAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmountFromTransactionsAndTransfers(List<Transaction> transactions, List<Transfer> transfers) {
        this.amount = startAmount;

        for (Transaction transaction: transactions) {
            if (transaction.getAccount().equals(this))
                amount += transaction.getAmount();
        }

        for (Transfer transfer: transfers) {
            if (transfer.getFromAccount().equals(this))
                amount -= transfer.getFromAmount();
            if (transfer.getToAccount().equals(this))
                amount += transfer.getToAmount();
        }


    }
}