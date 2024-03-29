package com.example.saveload;

import com.example.exception.ModelException;
import com.example.model.*;
import com.example.model.Currency;
import com.example.util.DateFilter;

import java.util.*;

public class SaveData {
    private static SaveData instance;

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

    public void clear() {
        this.accounts.clear();
        this.articles.clear();
        this.currencies.clear();
        this.transfers.clear();
        this.transactions.clear();
    }

    public void load() {
        SaveLoad.load(this);
        sort();

        for (Account account: accounts)
            account.setAmountFromTransactionsAndTransfers(transactions, transfers);
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
        this.currencies.sort((c1, c2) -> {
            if (c1.isBase()) return -1;
            if (c2.isBase()) return 1;
            if (c1.isOn()) return -1;
            if (c2.isOn()) return 1;
            return c1.getTitle().compareToIgnoreCase(c2.getTitle());
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
        return new Currency();
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
        //fixme
//        if (list.contains(newData) && oldCommon != list.get(list.indexOf(newData)))
//            throw new ModelException(ModelException.IS_EXISTS);
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

    public void updateCurrencies() throws Exception {
        HashMap<String, Double> rates = RateCurrency.loadRates(this.getBaseCurrency());
        for (Currency currency: currencies) {
            currency.setRate(rates.get(currency.getCode()));
        }

        for (Account account: accounts) {
            account.getCurrency().setRate(rates.get(account.getCurrency().getCode()));
        }
        isSaved = false;
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
        if (accounts != null)
            this.accounts = accounts;
    }

    public void setArticles(List<Article> articles) {
        if (articles != null)
            this.articles = articles;
    }

    public void setCurrencies(List<Currency> currencies) {
        if (currencies != null)
            this.currencies = currencies;
    }

    public void setTransactions(List<Transaction> transactions) {
        if (transactions != null)
            this.transactions = transactions;
    }

    public void setTransfers(List<Transfer> transfers) {
        if (transfers != null)
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
