package com.example.model;

import com.example.exception.ModelException;
import com.example.saveload.SaveData;

import java.util.Objects;

public class Currency extends Common {
    private String title;
    private String code;
    private double rate;
    private boolean isOn;
    private boolean isBase;

    public Currency() { }

    public Currency(String title, String code, double rate, boolean isOn, boolean isBase) throws ModelException {
        this.title = title;
        this.code = code;
        this.rate = rate;
        this.isOn = isOn;
        this.isBase = isBase;
        if (this.isBase)
            this.isOn = true;

        checkOnException();
    }

    public double getRateByCurrency(Currency currency) {
        return rate / currency.rate;
    }

    @Override
    public void postAdd(SaveData data) {
        clearBaseCurrency(data);
    }

    @Override
    public void postEdit(SaveData data) {
        clearBaseCurrency(data);
        for (Account a: data.getAccounts()) {
            if (a.getCurrency().equals(data.getOldCommon()))
                a.setCurrency(this);
            for (Transaction t: data.getTransactions())
                if (t.getAccount().getCurrency().equals(data.getOldCommon()))
                    t.getAccount().setCurrency(this);
            for (Transfer t: data.getTransfers()) {
                if (t.getFromAccount().getCurrency().equals(data.getOldCommon()))
                    t.getFromAccount().setCurrency(this);
                if (t.getToAccount().getCurrency().equals(data.getOldCommon()))
                    t.getToAccount().setCurrency(this);
            }
        }
    }

    @Override
    public void postRemove(SaveData data) {

    }

    private void clearBaseCurrency(SaveData data) {
        if (this.isBase) {
            this.rate = 1; // this.rate and oldCurrency.rate are equal
            Currency oldCurrency = (Currency) data.getOldCommon();
            for (Currency currency: data.getCurrencies()) {
                if (!this.equals(currency)) {
                    currency.setBase(false);
                    if (oldCurrency != null)
                        currency.setRate(currency.rate / oldCurrency.rate);
                }
            }
        }
    }

    @Override
    public String getValueForBox() {
        return title;
    }

    @Override
    public void checkOnException() throws ModelException {
        if (title.length() == 0)
            throw new ModelException(ModelException.TITLE_EMPTY);
        if (code.length() == 0)
            throw new ModelException(ModelException.CODE_EMPTY);
        if (rate <= 0)
            throw new ModelException(ModelException.RATE_INCORRECT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return code.equals(currency.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", rate=" + rate +
                ", isOn=" + isOn +
                ", isBase=" + isBase +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public boolean isBase() {
        return isBase;
    }

    public void setBase(boolean base) {
        isBase = base;
    }
}
