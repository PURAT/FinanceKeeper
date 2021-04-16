package com.example.gui.panel;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.MainFrame;
import com.example.gui.table.TransactionTableData;
import com.example.settings.Settings;

public class OverviewPanel extends RightPanel {

    public OverviewPanel(MainFrame frame) {
        super(frame, new TransactionTableData(Settings.COUNT_OVERVIEW_ROWS), Text.PANEL_TRANSACTIONS, Style.ICON_PANEL_OVERVIEW);
    }
}