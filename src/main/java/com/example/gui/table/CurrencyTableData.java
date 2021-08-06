package com.example.gui.table;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.table.model.CurrencyTableModel;
import com.example.gui.table.model.TransactionTableModel;
import com.example.gui.table.renderer.TableCellRenderer;
import com.example.handler.FunctionsHandler;
import com.example.model.Currency;

import javax.swing.*;
import java.awt.*;

public class CurrencyTableData extends TableData {

    private static final String[] columns = new String[] {Text.TITLE, Text.CODE, Text.RATE, Text.ON, Text.BASE};
    private static final ImageIcon[] icons = new ImageIcon[] {Style.ICON_TITLE, Style.ICON_CODE, Style.ICON_RATE, Style.ICON_ON, Style.ICON_BASE};

    public CurrencyTableData(FunctionsHandler handler) {
        super(new CurrencyTableModel(columns), handler, columns, icons);
        init();
    }

    @Override
    protected final void init() {
        for (String column: columns) {
            getColumn(column).setCellRenderer(new TableCellOnOffRenderer());
        }
    }

    private class TableCellOnOffRenderer extends TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            CurrencyTableModel currencyModel = (CurrencyTableModel) table.getModel();
            Currency currency = (Currency) currencyModel.getCommonByRow(row);
            if (currency.isOn()) {
                renderer.setForeground(Style.COLOR_ON);
            } else {
                renderer.setForeground(Style.COLOR_OFF);
            }
            return renderer;
        }
    }
}
