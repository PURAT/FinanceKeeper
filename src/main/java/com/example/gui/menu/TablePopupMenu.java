package com.example.gui.menu;

import com.example.constants.CodeAction;
import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.Refresh;
import com.example.handler.FunctionsHandler;

import javax.swing.*;

public class TablePopupMenu extends JPopupMenu implements Refresh {

    private final FunctionsHandler handler;

    public TablePopupMenu(FunctionsHandler handler) {
        super();
        this.handler = handler;
        init();
    }

    private void init() {
        JMenuItem editItem = new JMenuItem(Text.EDIT);
        JMenuItem deleteEdit = new JMenuItem(Text.DELETE);

        editItem.setActionCommand(CodeAction.BUTTON_EDIT);
        deleteEdit.setActionCommand(CodeAction.BUTTON_DELETE);

        editItem.addActionListener(handler);
        deleteEdit.addActionListener(handler);

        editItem.setIcon(Style.BUTTON_EDIT);
        deleteEdit.setIcon(Style.BUTTON_DELETE);

        add(editItem);
        add(deleteEdit);
    }

    @Override
    public void refresh() {

    }
}
