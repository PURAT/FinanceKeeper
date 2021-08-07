package com.example.gui.toolbar;

import com.example.constants.CodeAction;
import com.example.constants.Style;
import com.example.constants.Text;
import com.example.handler.MainToolbarHandler;

public class MainToolbar extends AbstractToolbar {

    public MainToolbar(MainToolbarHandler handler) {
        super(Style.BORDER_TOOLBAR, handler);
    }

    @Override
    void init() {
        addButton(Text.TOOLBAR_OVERVIEW, Style.ICON_TOOLBAR_OVERVIEW, CodeAction.TOOLBAR_OVERVIEW, true);
        addButton(Text.TOOLBAR_ACCOUNTS, Style.ICON_TOOLBAR_ACCOUNTS, CodeAction.TOOLBAR_ACCOUNTS, true);
        addButton(Text.TOOLBAR_ARTICLES, Style.ICON_TOOLBAR_ARTICLES, CodeAction.TOOLBAR_ARTICLES, true);
        addButton(Text.TOOLBAR_CURRENCIES, Style.ICON_TOOLBAR_CURRENCIES, CodeAction.TOOLBAR_CURRENCIES, true);
        addButton(Text.TOOLBAR_STATISTICS, Style.ICON_TOOLBAR_STATISTICS, CodeAction.TOOLBAR_STATISTICS, true);
        addButton(Text.TOOLBAR_TRANSFERS, Style.ICON_TOOLBAR_TRANSFERS, CodeAction.TOOLBAR_TRANSFERS, true);
        addButton(Text.TOOLBAR_TRANSACTIONS, Style.ICON_TOOLBAR_TRANSACTIONS, CodeAction.TOOLBAR_TRANSACTIONS, true);
    }
}
