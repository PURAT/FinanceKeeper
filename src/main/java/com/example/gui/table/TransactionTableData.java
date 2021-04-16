package com.example.gui.table;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.table.model.TransactionTableModel;
import com.example.gui.table.renderer.TableCellRenderer;

import javax.swing.*;
import java.awt.*;

public class TransactionTableData extends TableData {

    private static String[] columns = new String[] {Text.ARTICLE, Text.ACCOUNT, Text.AMOUNT, Text.NOTICE, Text.DATE};
    private static final ImageIcon[] icons = new ImageIcon[] {Style.ICON_ARTICLE, Style.ICON_ACCOUNT, Style.ICON_AMOUNT, Style.ICON_NOTICE, Style.ICON_DATE};

    public TransactionTableData() {
        super(new TransactionTableModel(columns), columns, icons);
        init();
    }

    public TransactionTableData(int count) {
        super(new TransactionTableModel(columns, count), columns, icons);
        init();
    }

    private void init() {
        getColumn(Text.AMOUNT).setCellRenderer(new TableCellAmountRenderer());
    }

    private class TableCellAmountRenderer extends TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if ((value.toString().contains("-")))
                renderer.setForeground(Style.COLOR_AMOUNT_EXPENSE);
            else
                renderer.setForeground(Style.COLOR_AMOUNT_INCOME);
            return renderer;
        }
    }
}
