package com.example.gui.panel;

import com.example.constants.Style;
import com.example.gui.EnableEditDelete;
import com.example.gui.MainFrame;
import com.example.gui.Refresh;
import com.example.gui.table.TableData;
import com.example.gui.toolbar.AbstractToolbar;

import javax.swing.*;

public class RightPanel extends AbstractPanel {

    protected TableData tableData;
    private String title;
    private ImageIcon icon;
    private JPanel[] panels;

    public RightPanel(MainFrame frame, String title, ImageIcon icon, TableData tableData, JPanel[] panels) {
        super(frame);
        this.title = title;
        this.icon = icon;
        this.tableData = tableData;
        this.panels = panels;
    }

    public RightPanel(MainFrame frame, TableData tableData, String title, ImageIcon icon) {
        this(frame, title, icon, tableData, new JPanel[] { });
    }

    public RightPanel(MainFrame frame, TableData tableData, String title, ImageIcon icon, AbstractToolbar toolbar) {
        this(frame, title, icon, tableData, new JPanel[] {toolbar});
    }

    private void enableEditDelete() {
        if (tableData != null && tableData.getSelectedRow() != -1) {
            for (JPanel panel : panels) {
                if (panel instanceof EnableEditDelete)
                    ((EnableEditDelete) panel).setEnableEditDelete(true);
            }
            frame.getMenu().setEnableEditDelete(true);
            return;
        }

        for (JPanel panel : panels) {
            if (panel instanceof EnableEditDelete)
                ((EnableEditDelete) panel).setEnableEditDelete(true);
        }
        frame.getMenu().setEnableEditDelete(true);
    }

    @Override
    protected void init() {
        enableEditDelete();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel label = new JLabel(title);
        label.setIcon(icon);
        label.setFont(Style.FONT_HEADER);
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(label);

        for (JPanel panel: panels) {
            add(Box.createVerticalStrut(Style.PADDING_PANEL));
            add(panel);
        }

        add(Box.createVerticalStrut(Style.PADDING_EMPTY_PANEL));

        JScrollPane scrollPane = new JScrollPane(tableData);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);

        ListSelectionModel selectionModel = tableData.getSelectionModel();
        selectionModel.addListSelectionListener((event) -> enableEditDelete());
    }

    @Override
    public void refresh() {
        super.refresh();

        if (tableData != null)
            tableData.refresh();

        for (JPanel panel: panels) {
            if (panel instanceof Refresh)
                ((Refresh) panel).refresh();
        }
    }
}
