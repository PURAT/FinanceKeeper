package com.example.gui.table.model;

import com.example.gui.Refresh;
import com.example.model.Common;
import com.example.model.Currency;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TableModel extends AbstractTableModel implements Refresh {

    protected List<? extends Common> data;
    protected List<String> columns;

    public TableModel(List<? extends Common> data, String[] columns) {
        this.data = data;
        this.columns = new ArrayList<>(Arrays.asList(columns));
    }

    @Override
    public void refresh() {
        updateData();
        fireTableDataChanged();
        fireTableStructureChanged();
    }

    protected abstract void updateData();

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns.get(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Object object = getValueAt(0, columnIndex);

        if (object == null)
            return Object.class;

        return object.getClass();
    }

    public Object getObjectByRow(int row) {
        return data.get(row);
    }
}
