package com.example.gui.table.model;

import com.example.model.Transaction;
import com.example.saveload.SaveData;
import com.example.util.Formatter;

public class TransactionTableModel extends TableModel {

    private static final int ARTICLE = 0;
    private static final int ACCOUNT = 1;
    private static final int AMOUNT = 2;
    private static final int NOTICE = 3;
    private static final int DATE = 4;


    private int count = -1;

    public TransactionTableModel(String[] columns) {
        super(SaveData.getInstance().getLastTransactions(), columns);
    }

    public TransactionTableModel(String[] columns, int count) {
        super(SaveData.getInstance().getTransactionsByCount(count), columns);
        this.count = count;
    }

    @Override
    protected void updateData() {
        if (count == -1)
            data = SaveData.getInstance().getLastTransactions();
        else
            data = SaveData.getInstance().getTransactionsByCount(count);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (data.isEmpty())
            return  null;
        Transaction transaction = (Transaction) data.get(rowIndex);
        switch (columnIndex) {
            case ARTICLE:
                return transaction.getArticle().getTitle();
            case ACCOUNT:
                return transaction.getAccount().getTitle();
            case AMOUNT:
                return transaction.getAmount();
            case NOTICE:
                return transaction.getNotice();
            case DATE:
                return Formatter.formatDateToString(transaction.getDate());
        }
        return null;
    }
}
