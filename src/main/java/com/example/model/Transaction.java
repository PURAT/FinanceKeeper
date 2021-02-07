package com.example.model;

import com.example.exception.ModelException;
import com.example.saveload.SaveData;

import java.util.Date;

public class Transaction extends Common {

    private Account account;
    private Article article;
    private double amount;
    private String notice;
    private Date date;

    public Transaction(Account account, Article article, double amount) throws ModelException {
        this(account, article, amount, "", new Date());
    }

    public Transaction(Account account, Article article, double amount, Date date) throws ModelException {
        this(account, article, amount, "", date);
    }

    public Transaction(Account account, Article article, double amount, String notice) throws ModelException {
        this(account, article, amount, notice, new Date());
    }

    public Transaction(Account account, Article article, double amount, String notice, Date date) throws ModelException {
        this.account = account;
        this.article = article;
        this.amount = amount;
        this.notice = notice;
        this.date = date;

        checkOnException();
    }

    @Override
    public void postAdd(SaveData data) {
        setAmounts(data);
    }

    @Override
    public void postEdit(SaveData data) {
        setAmounts(data);
    }

    @Override
    public void postRemove(SaveData data) {
        setAmounts(data);
    }

    private void setAmounts(SaveData data) {
        for (Account account: data.getAccounts()) {
            account.setAmountFromTransactionsAndTransfers(data.getTransactions(), data.getTransfers());
        }
    }

    @Override
    public String getValueForBox() {
        return null;
    }

    @Override
    public void checkOnException() throws ModelException {
        if (article == null)
            throw new ModelException(ModelException.ARTICLE_EMPTY);
        if (account == null)
            throw new ModelException(ModelException.ACCOUNT_EMPTY);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "account=" + account +
                ", article=" + article +
                ", amount=" + amount +
                ", notice='" + notice + '\'' +
                ", date=" + date +
                '}';
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
