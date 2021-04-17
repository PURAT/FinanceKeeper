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

    public RightPanel(MainFrame frame, TableData tableData, String title, ImageIcon icon, JPanel[] panels) {
        super(frame);
        this.title = title;
        this.icon = icon;
        this.tableData = tableData;
        this.panels = panels;
        init();
    }

    public RightPanel(MainFrame frame, TableData tableData, String title, ImageIcon icon) {
        this(frame, tableData, title, icon, new JPanel[] { });
    }

    public RightPanel(MainFrame frame, TableData tableData, String title, ImageIcon icon, AbstractToolbar toolbar) {
        this(frame, tableData, title, icon, new JPanel[] {toolbar});
    }

    private void enableEditDelete() {
        for (JPanel panel : panels) {
            if (panel instanceof EnableEditDelete)
                ((EnableEditDelete) panel).setEnableEditDelete(false);
        }
        frame.getMenu().setEnableEditDelete(false);

        if (tableData != null && tableData.getSelectedRow() != -1) {
            for (JPanel panel : panels) {
                if (panel instanceof EnableEditDelete)
                    ((EnableEditDelete) panel).setEnableEditDelete(true);
            }
            frame.getMenu().setEnableEditDelete(true);
        }
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

        if (panels.length == 0) {
            add(Box.createVerticalStrut(Style.PADDING_EMPTY_PANEL));
        }

        for (JPanel panel: panels) {
            add(panel);
            add(Box.createVerticalStrut(Style.PADDING_PANEL));
        }

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
