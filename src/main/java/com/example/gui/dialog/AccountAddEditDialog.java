package com.example.gui.dialog;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.exception.ModelException;
import com.example.gui.MainFrame;
import com.example.model.Account;
import com.example.model.Common;
import com.example.model.Currency;
import com.example.saveload.SaveData;
import com.example.util.Formatter;

import javax.swing.*;

public class AccountAddEditDialog extends AbstractAddEditDialog {

    public AccountAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        components.put(Text.ACCOUNT_TITLE, new JTextField());
        components.put(Text.ACCOUNT_CURRENCY, new CommonComboBox(SaveData.getInstance().getEnableCurrencies().toArray()));
        components.put(Text.ACCOUNT_START_AMOUNT, new JTextField());

        icons.put(Text.ACCOUNT_TITLE, Style.ICON_TITLE);
        icons.put(Text.ACCOUNT_CURRENCY, Style.ICON_CURRENCY);
        icons.put(Text.ACCOUNT_START_AMOUNT, Style.ICON_START_AMOUNT);

        values.put(Text.ACCOUNT_START_AMOUNT, Formatter.formatAmountToString(0));
    }

    @Override
    protected void setValues() {
        Account account = (Account) c;
        values.put(Text.ACCOUNT_TITLE, account.getTitle());
        values.put(Text.ACCOUNT_CURRENCY, account.getCurrency());
        values.put(Text.ACCOUNT_START_AMOUNT, account.getStartAmount());
    }

    @Override
    protected Common getCommonFromForm() throws ModelException {
        try {
            String title = ((JTextField) components.get(Text.ACCOUNT_TITLE)).getText();
            String startAmount = ((JTextField) components.get(Text.ACCOUNT_CURRENCY)).getText();
            Currency currency = (Currency) ((CommonComboBox) components.get(Text.ACCOUNT_CURRENCY)).getSelectedItem();
            return new Account(title, currency, Formatter.formatAmountToNumber(startAmount));
        } catch (NumberFormatException e) {
            throw new ModelException(ModelException.AMOUNT_FORMAT);
        }
    }
}
