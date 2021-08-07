package com.example.handler;

import com.example.gui.MainFrame;
import com.example.gui.panel.*;

import java.awt.event.ActionEvent;

import static com.example.constants.CodeAction.*;

public class MainToolbarHandler extends MenuViewHandler {

    public MainToolbarHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case TOOLBAR_ACCOUNTS:
                showAccountPanel();
                break;
            case TOOLBAR_ARTICLES:
                showArticlePanel();
                break;
            case TOOLBAR_CURRENCIES:
                showCurrencyPanel();
                break;
            case TOOLBAR_OVERVIEW:
                showOverviewPanel();
                break;
            case TOOLBAR_STATISTICS:
                showStatisticsPanel();
                break;
            case TOOLBAR_TRANSACTIONS:
                showTransactionPanel();
                break;
            case  TOOLBAR_TRANSFERS:
                showTransferPanel();
        }
        super.actionPerformed(e);
    }
}
