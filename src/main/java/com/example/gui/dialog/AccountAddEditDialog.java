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
        components.put(Text.TITLE, new JTextField());
        components.put(Text.CURRENCY, new CommonComboBox(SaveData.getInstance().getEnableCurrencies().toArray()));
        components.put(Text.START_AMOUNT, new JTextField());

        icons.put(Text.TITLE, Style.ICON_TITLE);
        icons.put(Text.CURRENCY, Style.ICON_CURRENCY);
        icons.put(Text.START_AMOUNT, Style.ICON_START_AMOUNT);
        

        values.put(Text.START_AMOUNT, Formatter.formatAmountToString(0));
    }

    @Override
    protected void setValues() {
        Account account = (Account) c;
        values.put(Text.TITLE, account.getTitle());
        values.put(Text.CURRENCY, account.getCurrency());
        values.put(Text.START_AMOUNT, account.getStartAmount());
    }

    @Override
    public Common getCommonFromForm() throws ModelException {
        try {
            String title = ((JTextField) components.get(Text.TITLE)).getText();
            String startAmount = ((JTextField) components.get(Text.START_AMOUNT)).getText();
            Currency currency = (Currency) ((CommonComboBox) components.get(Text.CURRENCY)).getSelectedItem();
            return new Account(title, currency, Formatter.formatAmountToNumber(startAmount));
        } catch (NumberFormatException e) {
            throw new ModelException(ModelException.AMOUNT_FORMAT);
        }
    }
}
