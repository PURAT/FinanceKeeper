package com.example.gui.panel;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.MainFrame;
import com.example.gui.table.CurrencyTableData;
import com.example.gui.table.TransactionTableData;
import com.example.gui.toolbar.EditToolbar;

public class CurrencyPanel extends RightPanel {

    public CurrencyPanel(MainFrame frame) {
        super(frame, new CurrencyTableData(), Text.PANEL_CURRENCIES, Style.ICON_PANEL_CURRENCIES, new EditToolbar());
    }
}
