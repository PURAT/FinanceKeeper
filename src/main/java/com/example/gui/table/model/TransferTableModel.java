package com.example.gui.table.model;

import com.example.model.Transfer;
import com.example.saveload.SaveData;
import com.example.util.Formatter;

public class TransferTableModel extends TableModel {

    private static final int FROM_ACCOUNT = 0;
    private static final int TO_ACCOUNT = 1;
    private static final int FROM_AMOUNT = 2;
    private static final int TO_AMOUNT = 3;
    private static final int NOTICE = 4;
    private static final int DATE = 5;

    public TransferTableModel(String[] columns) {
        super(SaveData.getInstance().getLastTransfers(), columns);
    }

    @Override
    protected void updateData() {
        data = SaveData.getInstance().getLastTransfers();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (data.isEmpty())
            return  null;
        Transfer transfer = (Transfer) data.get(rowIndex);
        switch (columnIndex) {
            case FROM_ACCOUNT:
                return transfer.getFromAccount().getTitle();
            case TO_ACCOUNT:
                return transfer.getToAccount().getTitle();
            case FROM_AMOUNT:
                return Formatter.formatAmountWithCurrencyToString(transfer.getFromAmount(), transfer.getFromAccount().getCurrency());
            case TO_AMOUNT:
                return Formatter.formatAmountWithCurrencyToString(transfer.getToAmount(), transfer.getToAccount().getCurrency());
            case NOTICE:
                return transfer.getNotice();
            case DATE:
                return Formatter.formatDateToString(transfer.getDate());
        }
        return null;
    }
}
