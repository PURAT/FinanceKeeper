package com.example.util;

import com.example.model.Account;
import com.example.model.Currency;
import com.example.model.Transaction;
import com.example.saveload.SaveData;

import java.util.HashMap;
import java.util.List;

public class BalanceStatistics {

    public static double getBalanceByCurrency(Currency currency) {
        SaveData data = SaveData.getInstance();
        double amount = 0;
        for (Account account: data.getAccounts()) {
            if (currency.equals(account.getCurrency()))
                amount += account.getAmount();
        }
        return amount;
    }

    public static double getBalance(Currency currency) {
        SaveData data = SaveData.getInstance();
        double amount = 0;
        for (Account account: data.getAccounts()) {
                amount += account.getAmount() * account.getCurrency().getRateByCurrency(currency);
        }
        return amount;
    }

    public static HashMap<String, Double> getDataForChartIncome() {
        return getDataForChart(true);
    }

    public static HashMap<String, Double> getDataFroChartExpense() {
        return getDataForChart(false);
    }

    private static HashMap<String, Double> getDataForChart(boolean income) {
        HashMap<String, Double> data = new HashMap<>();
        List<Transaction> transactions = SaveData.getInstance().getTransactions();
        for (Transaction transaction: transactions) {
            if ((income && transaction.getAmount() > 0) || (!income && transaction.getAmount() < 0)) {
                String key = transaction.getArticle().getTitle();
                double amount = income ? transaction.getAmount() : -transaction.getAmount();
                double sum = data.containsKey(key) ? data.get(key) : 0;
                sum += amount * transaction.getAccount().getCurrency().getRateByCurrency(SaveData.getInstance().getBaseCurrency());
                data.put(key, round(sum));
            }
        }
        return data;
    }

    private static double round(double value) {
        return (double) Math.round(value * 100) / 100;
    }
}
