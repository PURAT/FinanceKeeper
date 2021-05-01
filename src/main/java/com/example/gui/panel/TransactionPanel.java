package com.example.gui.panel;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.MainFrame;
import com.example.gui.table.TransactionTableData;
import com.example.gui.toolbar.EditToolbar;

public class TransactionPanel extends RightPanel {

    public TransactionPanel(MainFrame frame) {
        super(frame, new TransactionTableData(), Text.PANEL_TRANSACTIONS, Style.ICON_PANEL_TRANSACTION, new EditToolbar());
    }
}
