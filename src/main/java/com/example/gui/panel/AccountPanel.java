package com.example.gui.panel;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.MainFrame;
import com.example.gui.table.AccountTableData;
import com.example.gui.table.TransactionTableData;
import com.example.gui.toolbar.EditToolbar;
import com.example.settings.Settings;

public class AccountPanel extends RightPanel {

    public AccountPanel(MainFrame frame) {
        super(frame, new AccountTableData(), Text.PANEL_ACCOUNTS, Style.ICON_PANEL_ACCOUNTS, new EditToolbar());
    }
}