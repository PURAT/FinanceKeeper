package com.example.gui.table.model;

import com.example.model.Article;
import com.example.model.Currency;
import com.example.saveload.SaveData;
import com.example.util.Formatter;

public class CurrencyTableModel extends TableModel {

    private static final int TITLE = 0;
    private static final int CODE = 1;
    private static final int RATE = 2;
    private static final int ON = 3;
    private static final int BASE = 4;

    public CurrencyTableModel(String[] columns) {
        super(SaveData.getInstance().getCurrencies(), columns);
    }

    @Override
    protected void updateData() {
        data = SaveData.getInstance().getCurrencies();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (data.isEmpty())
            return  null;
        Currency currency = (Currency) data.get(rowIndex);
        switch (columnIndex) {
            case TITLE:
                return currency.getTitle();
            case CODE:
                return currency.getCode();
            case RATE:
                return Formatter.formatRateToString(currency.getRate());
            case ON:
                return Formatter.formatYesNo(currency.isOn());
            case BASE:
                return Formatter.formatYesNo(currency.isBase());
        }
        return null;
    }
}
