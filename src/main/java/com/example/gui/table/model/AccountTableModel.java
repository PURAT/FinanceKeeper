package com.example.gui.table.model;

import com.example.model.Account;
import com.example.saveload.SaveData;
import com.example.util.Formatter;

public class AccountTableModel extends TableModel {

    private static final int TITLE = 0;
    private static final int AMOUNT = 1;

    public AccountTableModel(String[] columns) {
        super(SaveData.getInstance().getAccounts(), columns);
    }

    @Override
    protected void updateData() {
        data = SaveData.getInstance().getAccounts();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (data.isEmpty())
            return  null;
        Account account = (Account) data.get(rowIndex);
        switch (columnIndex) {
            case TITLE:
                return account.getTitle();
            case AMOUNT:
                return Formatter.formatAmountWithCurrencyToString(account.getAmount(), account.getCurrency());
        }
        return null;
    }
}
