package com.example.handler;

import com.example.gui.MainFrame;
import com.example.gui.panel.*;

import java.awt.event.ActionEvent;

import static com.example.constants.CodeAction.*;

public class MenuViewHandler extends Handler {

    public MenuViewHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case MENU_VIEW_ACCOUNTS:
                showAccountPanel();
                break;
            case MENU_VIEW_ARTICLES:
                showArticlePanel();
                break;
            case MENU_VIEW_CURRENCIES:
                showCurrencyPanel();
                break;
            case MENU_VIEW_OVERVIEW:
                showOverviewPanel();
                break;
            case MENU_VIEW_STATISTICS:
                showStatisticsPanel();
                break;
            case MENU_VIEW_TRANSACTIONS:
                showTransactionPanel();
                break;
            case  MENU_VIEW_TRANSFERS:
                showTransferPanel();
        }
        super.actionPerformed(e);
    }

    protected void showAccountPanel() {
        frame.setRightPanel(new AccountPanel(frame));
    }

    protected void showArticlePanel() {
        frame.setRightPanel(new ArticlePanel(frame));
    }

    protected void showCurrencyPanel() {
        frame.setRightPanel(new CurrencyPanel(frame));
    }

    protected void showOverviewPanel() {
        frame.setRightPanel(new OverviewPanel(frame));
    }

    protected void showStatisticsPanel() {
        frame.setRightPanel(new StatisticsPanel(frame));
    }

    protected void showTransactionPanel() {
        frame.setRightPanel(new TransactionPanel(frame));
    }

    protected void showTransferPanel() {
        frame.setRightPanel(new TransferPanel(frame));
    }
}
