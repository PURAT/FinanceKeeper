package com.example.gui.panel;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.MainFrame;
import com.example.gui.dialog.TransferAddEditDialog;
import com.example.gui.table.TransferTableData;
import com.example.gui.toolbar.EditToolbar;
import com.example.handler.FunctionsHandler;

import javax.swing.*;

public class TransferPanel extends RightPanel {

    public TransferPanel(MainFrame frame) {
        super(frame, new TransferTableData(new FunctionsHandler(frame, new TransferAddEditDialog(frame))),
                Text.PANEL_TRANSFERS, Style.PANEL_TRANSFERS,
                new JPanel[] { new EditToolbar(new FunctionsHandler(frame, new TransferAddEditDialog(frame))),
                        new FilterPanel(frame) });
    }
}
