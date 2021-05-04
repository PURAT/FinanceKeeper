package com.example.gui.panel;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.MainFrame;
import com.example.gui.table.TransferTableData;
import com.example.gui.toolbar.EditToolbar;

import javax.swing.*;

public class TransferPanel extends RightPanel {

    public TransferPanel(MainFrame frame) {
        super(frame, new TransferTableData(), Text.PANEL_TRANSFERS, Style.PANEL_TRANSFERS,
                new JPanel[] { new EditToolbar(), new FilterPanel(frame) });
    }
}
