package com.example.gui.panel;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.MainFrame;
import com.example.model.Currency;
import com.example.saveload.SaveData;
import com.example.util.BalanceStatistics;
import com.example.util.Formatter;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends AbstractPanel {

    public LeftPanel(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(Style.BORDER_LEFT_PANEL);

        JLabel header = new JLabel(Text.BALANCE_CURRENCIES);
        header.setFont(Style.FONT_HEADER);
        header.setIcon(Style.ICON_LEFT_PANEL_BALANCE_CURRENCIES);
        header.setAlignmentX(JComponent.RIGHT_ALIGNMENT);

        JLabel header2 = new JLabel(Text.FULL_BALANCE);
        header2.setFont(Style.FONT_HEADER);
        header2.setIcon(Style.ICON_LEFT_PANEL_FULL_BALANCE);
        header2.setAlignmentX(JComponent.RIGHT_ALIGNMENT);

        // fixme
//        header2.setHorizontalTextPosition(SwingConstants.LEFT);
//        header2.setHorizontalAlignment(SwingConstants.LEFT);

        add(header);

        addBalanceCurrency();
        add(Box.createVerticalStrut(Style.PADDING_LEFT_PANEL));

        add(header2);

        addFullBalance();
        add(Box.createVerticalStrut(Style.PADDING_LEFT_PANEL));
    }

    private void addFullBalance() {
        for (Currency currency: SaveData.getInstance().getCurrencies()) {
            add(Box.createVerticalStrut(Style.PADDING_BALANCE_PANEL));
            add(new PanelBalance(currency, BalanceStatistics.getBalance(currency)));
        }
    }

    private void addBalanceCurrency() {
        for (Currency currency: SaveData.getInstance().getCurrencies()) {
            add(Box.createVerticalStrut(Style.PADDING_BALANCE_PANEL));
            add(new PanelBalance(currency, BalanceStatistics.getBalanceByCurrency(currency)));
        }
    }


    private static class PanelBalance extends JPanel {

        PanelBalance(Currency currency, double amount) {
            super();

            setLayout(new BorderLayout());
            setBackground(Style.COLOR_BALANCE_PANEL);
            setBorder(Style.BORDER_BALANCE_PANEL);

            JLabel currencyLabel = new JLabel(currency.getTitle());
            JLabel amountLabel = new JLabel(Formatter.formatAmountWithCurrencyToString(amount, currency));
            amountLabel.setFont(Style.FONT_AMOUNT);

            add(currencyLabel, BorderLayout.WEST);
            add(Box.createRigidArea(Style.DIMENSION_BALANCE_PANEL));
            add(amountLabel, BorderLayout.EAST);
        }
    }
}
