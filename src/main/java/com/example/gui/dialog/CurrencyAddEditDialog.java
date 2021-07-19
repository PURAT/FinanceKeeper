package com.example.gui.dialog;

import com.example.constants.CodeAction;
import com.example.constants.Style;
import com.example.constants.Text;
import com.example.exception.ModelException;
import com.example.gui.MainFrame;
import com.example.model.Common;
import com.example.model.Currency;
import com.example.saveload.SaveData;
import com.example.settings.Settings;
import com.example.util.Formatter;

import javax.swing.*;

public class CurrencyAddEditDialog extends AbstractAddEditDialog {

    public CurrencyAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        components.put(Text.TITLE, new JTextField());
        components.put(Text.CODE, new JComboBox<>(Settings.CURRENCIES_CODES));
        components.put(Text.RATE, new JTextField());
        components.put(Text.ON, new JComboBox<>(new String[] {Text.YES, Text.NO}));
        components.put(Text.BASE, new JComboBox<>(new String[] {Text.YES, Text.NO}));

        icons.put(Text.TITLE, Style.ICON_TITLE);
        icons.put(Text.CODE, Style.ICON_CODE);
        icons.put(Text.RATE, Style.ICON_RATE);
        icons.put(Text.ON, Style.ICON_ON);
        icons.put(Text.BASE, Style.ICON_BASE);

        values.put(Text.RATE, 1);
    }

    @Override
    protected void setValues() {
        Currency currency = (Currency) c;
        values.put(Text.TITLE, currency.getTitle());
        values.put(Text.CODE, currency.getCode());
        values.put(Text.RATE, currency.getRate());
        values.put(Text.ON, currency.isOn() ? Text.YES: Text.NO);
        values.put(Text.BASE, currency.isBase() ? Text.YES: Text.NO);
    }

    @Override
    protected Common getCommonFromForm() throws ModelException {
        try {
            String title = ((JTextField) components.get(Text.TITLE)).getText();
            String rate = ((JTextField) components.get(Text.RATE)).getText();
            String code = (String) ((JComboBox) components.get(Text.CODE)).getSelectedItem();
            boolean isOn = false;
            boolean isBase = false;
            if (((JComboBox) components.get(Text.ON)).getSelectedItem().equals(Text.YES))
                isOn = true;
            if (((JComboBox) components.get(Text.BASE)).getSelectedItem().equals(Text.YES))
                isBase = true;
            if (!isBase && c != null && ((Currency) c).isBase())
                throw new ModelException(ModelException.NO_BASE_CURRENCY);
            return new Currency(title, code, Formatter.formatAmountToNumber(rate), isOn, isBase);
        } catch (NumberFormatException e) {
            throw new ModelException(ModelException.AMOUNT_FORMAT);
        }
    }
}
