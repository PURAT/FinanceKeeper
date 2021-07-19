package com.example.gui.table;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.table.model.AccountTableModel;
import com.example.gui.table.renderer.TableCellRenderer;

import javax.swing.*;
import java.awt.*;

public class AccountTableData extends TableData {

    private static String[] columns = new String[] {Text.TITLE, Text.AMOUNT};
    private static final ImageIcon[] icons = new ImageIcon[] {Style.ICON_TITLE, Style.ICON_AMOUNT};

    public AccountTableData() {
        super(new AccountTableModel(columns), columns, icons);
    }
}
