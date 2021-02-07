package com.example.saveload;

import com.example.exception.ModelException;
import com.example.model.*;
import com.example.util.DateFilter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SaveData {
    private static SaveData instance;

    //fixme
    private List<Account> accounts = new ArrayList<>();
    private List<Article> articles = new ArrayList<>();
    private List<Currency> currencies = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private List<Transfer> transfers = new ArrayList<>();

    private final DateFilter dateFilter;
    private Common oldCommon;
    private boolean isSaved;

    private SaveData() {
        load();
        dateFilter = new DateFilter();
        isSaved = true;
    }

    public void load() {
        SaveLoad.load(this);
        sort();
    }

    public void save() {
        SaveLoad.save(this);
        isSaved = true;
    }

    private void sort() {
        this.articles.sort((a1, a2) -> a1.getTitle().compareToIgnoreCase(a2.getTitle()));
        this.accounts.sort((a1, a2) -> a1.getTitle().compareToIgnoreCase(a2.getTitle()));
        this.transactions.sort(Comparator.comparing(Transaction::getDate));
        this.transfers.sort(Comparator.comparing(Transfer::getDate));
        this.currencies.sort(new Comparator<Currency>() {
            @Override
            public int compare(Currency c1, Currency c2) {
                if (c1.isBase()) return -1;
                if (c2.isBase()) return 1;
                if (c1.isOn()) return -1;
                if (c2.isOn()) return 1;
                return c1.getTitle().compareToIgnoreCase(c2.getTitle());
            }
        });
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Common getOldCommon() {
        return oldCommon;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public Currency getBaseCurrency() {
        for (Currency currency: currencies) {
            if (currency.isBase())
                return currency;
        }
        //fixme
        return null;
    }

    public ArrayList<Currency> getEnableCurrencies() {
        ArrayList<Currency> list = new ArrayList<>();
        for (Currency currency: currencies) {
            if (currency.isOn())
                list.add(currency);
        }
        return list;
    }

    public ArrayList<Transaction> getLastTransactions() {
        ArrayList<Transaction> list = new ArrayList<>();
        for (Transaction transaction: transactions) {
            if (dateFilter.checkDate(transaction.getDate()))
                list.add(transaction);
        }
        return list;
    }

    public ArrayList<Transfer> getLastTransfers() {
        ArrayList<Transfer> list = new ArrayList<>();
        for (Transfer transfer: transfers) {
            if (dateFilter.checkDate(transfer.getDate()))
                list.add(transfer);
        }
        return list;
    }

    public ArrayList<Transaction> getTransactionsByCount(int count) {
        return new ArrayList<>(transactions.subList(0, Math.min(transactions.size(), count)));
    }

    public void add(Common oldCommon) throws ModelException {
        List list = getList(oldCommon);
        if (list.contains(oldCommon))
            throw new ModelException(ModelException.IS_EXISTS);
        list.add(oldCommon);
        oldCommon.postAdd(this);
        sort();
        isSaved = false;
    }

    public void edit(Common oldData, Common newData) throws ModelException {
        List list = getList(oldData);
        if (list.contains(newData) && oldCommon != list.get(list.indexOf(newData)))
            throw new ModelException(ModelException.IS_EXISTS);
        list.set(list.indexOf(oldData), newData);
        oldCommon = oldData;
        newData.postEdit(this);
        sort();
        isSaved = false;
    }

    public void remove(Common oldData) {
        getList(oldData).remove(oldData);
        oldData.postRemove(this);
        isSaved = false;
    }

    private List getList(Common data) {
        if (data instanceof Article) return articles;
        if (data instanceof Account) return accounts;
        if (data instanceof Currency) return currencies;
        if (data instanceof Transaction) return transactions;
        if (data instanceof Transfer) return transfers;
        return null;
    }

    @Override
    public String toString() {
        return "SaveData{" +
                "accounts=" + accounts +
                ", articles=" + articles +
                ", currencies=" + currencies +
                ", transactions=" + transactions +
                ", transfers=" + transfers +
                '}';
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public DateFilter getDateFilter() {
        return dateFilter;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public static SaveData getInstance() {
        if (instance == null)
            instance = new SaveData();
        return instance;
    }
}
