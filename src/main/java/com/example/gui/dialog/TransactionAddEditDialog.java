package com.example.gui.dialog;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.exception.ModelException;
import com.example.gui.MainDatePicker;
import com.example.gui.MainFrame;
import com.example.model.Account;
import com.example.model.Article;
import com.example.model.Common;
import com.example.model.Transaction;
import com.example.saveload.SaveData;
import com.example.util.Formatter;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.util.Date;

public class TransactionAddEditDialog extends AbstractAddEditDialog {

    public TransactionAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        components.put(Text.ARTICLE, new CommonComboBox(SaveData.getInstance().getArticles().toArray()));
        components.put(Text.ACCOUNT, new CommonComboBox(SaveData.getInstance().getAccounts().toArray()));
        components.put(Text.AMOUNT, new JTextField());
        components.put(Text.NOTICE, new JTextField());
        components.put(Text.DATE, new MainDatePicker().getDatePicker());

        icons.put(Text.ARTICLE, Style.ICON_ARTICLE);
        icons.put(Text.ACCOUNT, Style.ICON_ACCOUNT);
        icons.put(Text.AMOUNT, Style.ICON_AMOUNT);
        icons.put(Text.NOTICE, Style.ICON_NOTICE);
        icons.put(Text.DATE, Style.ICON_DATE);

        values.put(Text.DATE, new Date());
        values.put(Text.AMOUNT, Formatter.formatAmountToString(0));
    }

    @Override
    protected void setValues() {
        Transaction transaction = (Transaction) c;
        values.put(Text.ARTICLE, transaction.getArticle());
        values.put(Text.ACCOUNT, transaction.getAccount());
        values.put(Text.AMOUNT, transaction.getAmount());
        values.put(Text.NOTICE, transaction.getNotice());
        values.put(Text.DATE, transaction.getDate());
    }

    @Override
    protected Common getCommonFromForm() throws ModelException {
        try {
            Account account = (Account) ((CommonComboBox) components.get(Text.ACCOUNT)).getSelectedItem();
            Article article = (Article) ((CommonComboBox) components.get(Text.ARTICLE)).getSelectedItem();
            String notice = ((JTextField) components.get(Text.NOTICE)).getText();
            String amount = ((JTextField) components.get(Text.AMOUNT)).getText();
            Date date = (Date) ((JDatePickerImpl) components.get(Text.DATE)).getModel().getValue();
            return new Transaction(account, article, Formatter.formatAmountToNumber(amount), notice, date);
        } catch (NumberFormatException e) {
            throw new ModelException(ModelException.AMOUNT_FORMAT);
    }
    }
}
