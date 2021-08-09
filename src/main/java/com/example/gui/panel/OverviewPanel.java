package com.example.gui.panel;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.MainFrame;
import com.example.gui.dialog.TransactionAddEditDialog;
import com.example.gui.dialog.TransferAddEditDialog;
import com.example.gui.table.TransactionTableData;
import com.example.handler.FunctionsHandler;
import com.example.settings.Settings;

public class OverviewPanel extends RightPanel {

    public OverviewPanel(MainFrame frame) {
        super(frame, new TransactionTableData(new FunctionsHandler(frame, new TransactionAddEditDialog(frame)),
                        Settings.COUNT_OVERVIEW_ROWS), Text.PANEL_LAST_TRANSACTIONS, Style.ICON_PANEL_OVERVIEW);
    }
}