package com.example.gui.table;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.table.model.CurrencyTableModel;
import com.example.gui.table.model.TransferTableModel;
import com.example.gui.table.renderer.TableCellRenderer;
import com.example.model.Currency;

import javax.swing.*;
import java.awt.*;

public class TransferTableData extends TableData {

    private static final String[] columns = new String[] {Text.FROM_ACCOUNT, Text.TO_ACCOUNT, Text.FROM_AMOUNT, Text.TO_AMOUNT, Text.NOTICE, Text.DATE};
    private static final ImageIcon[] icons = new ImageIcon[] {Style.ICON_ACCOUNT, Style.ICON_ACCOUNT, Style.ICON_AMOUNT, Style.ICON_AMOUNT, Style.ICON_NOTICE, Style.ICON_DATE};

    public TransferTableData() {
        super(new TransferTableModel(columns), columns, icons);
        init();
    }

    @Override
    protected final void init() {
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
