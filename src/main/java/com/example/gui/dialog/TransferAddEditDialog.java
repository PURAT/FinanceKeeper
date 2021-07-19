package com.example.gui.dialog;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.exception.ModelException;
import com.example.gui.MainDatePicker;
import com.example.gui.MainFrame;
import com.example.model.Account;
import com.example.model.Article;
import com.example.model.Common;
import com.example.model.Transfer;
import com.example.saveload.SaveData;
import com.example.util.Formatter;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.util.Date;

public class TransferAddEditDialog extends AbstractAddEditDialog {

    public TransferAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        components.put(Text.FROM_ACCOUNT, new CommonComboBox(SaveData.getInstance().getAccounts().toArray()));
        components.put(Text.TO_ACCOUNT, new CommonComboBox(SaveData.getInstance().getAccounts().toArray()));
        components.put(Text.FROM_AMOUNT, new JTextField());
        components.put(Text.TO_AMOUNT, new JTextField());
        components.put(Text.NOTICE, new JTextField());
        components.put(Text.DATE, new MainDatePicker().getDatePicker());

        icons.put(Text.FROM_ACCOUNT, Style.ICON_ACCOUNT);
        icons.put(Text.TO_ACCOUNT, Style.ICON_ACCOUNT);
        icons.put(Text.FROM_AMOUNT, Style.ICON_AMOUNT);
        icons.put(Text.TO_AMOUNT, Style.ICON_AMOUNT);
        icons.put(Text.NOTICE, Style.ICON_NOTICE);
        icons.put(Text.DATE, Style.ICON_DATE);

        values.put(Text.DATE, new Date());
        values.put(Text.FROM_AMOUNT, Formatter.formatAmountToString(0));
        values.put(Text.TO_AMOUNT, Formatter.formatAmountToString(0));
    }

    @Override
    protected void setValues() {
        Transfer transfer = (Transfer) c;
        values.put(Text.FROM_ACCOUNT, transfer.getFromAccount());
        values.put(Text.TO_ACCOUNT, transfer.getToAccount());
        values.put(Text.FROM_AMOUNT, transfer.getFromAmount());
        values.put(Text.TO_AMOUNT, transfer.getToAmount());
        values.put(Text.NOTICE, transfer.getNotice());
        values.put(Text.DATE, transfer.getDate());
    }

    @Override
    protected Common getCommonFromForm() throws ModelException {
        try {
            Account fromAccount = (Account) ((CommonComboBox) components.get(Text.FROM_ACCOUNT)).getSelectedItem();
            Account toAccount = (Account) ((CommonComboBox) components.get(Text.TO_ACCOUNT)).getSelectedItem();
            String fromAmount = ((JTextField) components.get(Text.FROM_AMOUNT)).getText();
            String toAmount = ((JTextField) components.get(Text.TO_AMOUNT)).getText();
            String notice = ((JTextField) components.get(Text.NOTICE)).getText();
            Date date = (Date) ((JDatePickerImpl) components.get(Text.DATE)).getModel().getValue();
            return new Transfer(fromAccount, toAccount, Formatter.formatAmountToNumber(fromAmount),
                    Formatter.formatAmountToNumber(toAmount), notice, date);
        } catch (NumberFormatException e) {
            throw new ModelException(ModelException.AMOUNT_FORMAT);
        }
    }
}
