package com.example.gui.panel;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.MainFrame;
import com.example.gui.dialog.AccountAddEditDialog;
import com.example.gui.dialog.CurrencyAddEditDialog;
import com.example.gui.table.CurrencyTableData;
import com.example.gui.table.TransactionTableData;
import com.example.gui.toolbar.EditToolbar;
import com.example.handler.FunctionsHandler;

public class CurrencyPanel extends RightPanel {

    public CurrencyPanel(MainFrame frame) {
        super(frame, new CurrencyTableData(new FunctionsHandler(frame, new CurrencyAddEditDialog(frame))),
                Text.PANEL_CURRENCIES, Style.ICON_PANEL_CURRENCIES,
                new EditToolbar(new FunctionsHandler(frame, new CurrencyAddEditDialog(frame))));
    }
}
