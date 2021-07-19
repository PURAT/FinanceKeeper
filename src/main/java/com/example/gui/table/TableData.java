package com.example.gui.table;

import com.example.constants.Style;
import com.example.gui.Refresh;
import com.example.gui.menu.TablePopupMenu;
import com.example.gui.table.model.TableModel;
import com.example.gui.table.renderer.TableCellRenderer;
import com.example.gui.table.renderer.TableHeaderIconRenderer;

import javax.swing.*;
import java.awt.*;

public abstract class TableData extends JTable implements Refresh {

    private final TablePopupMenu popupMenu;
    private final String[] columns;
    private final ImageIcon[] icons;

    public TableData(TableModel model, String[] columns, ImageIcon[] icons) {
        super(model);
        this.popupMenu = new TablePopupMenu();
        this.columns = columns;
        this.icons = icons;

        getTableHeader().setFont(Style.FONT_TABLE_HEADER);
        setFont(Style.FONT_TABLE);
        setRowHeight(getRowHeight() + Style.TABLE_ROW_HEIGHT);
        setAutoCreateRowSorter(true);
        setPreferredScrollableViewportSize(Style.DIMENSION_TABLE_SIZE);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        for (int i = 0; i < columns.length; i++) {
            getColumn(columns[i]).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
        }

        TableCellRenderer cellRenderer = new TableCellRenderer();
        setDefaultRenderer(String.class, cellRenderer);
        setComponentPopupMenu(popupMenu);
    }

    @Override
    public JPopupMenu getComponentPopupMenu() {
        Point point = getMousePosition();
        int row = rowAtPoint(point);
        if (row != -1) {
            setRowSelectionInterval(row, row);
        }
        return super.getComponentPopupMenu();
    }

    @Override
    public void refresh() {
        int selectedRow = getSelectedRow();
        ((TableModel) getModel()).refresh();

        for (int i = 0; i < columns.length; i++) {
            getColumn(columns[i]).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
        }

        if (selectedRow != -1 && selectedRow < getRowCount())
            setRowSelectionInterval(selectedRow, selectedRow);

        init();
    }

    protected void init() { }
}
