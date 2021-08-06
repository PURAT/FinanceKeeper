package com.example.handler;

import com.example.gui.MainFrame;

import java.awt.event.ActionEvent;

import static com.example.constants.CodeAction.*;

public class MenuEditHandler extends Handler {

    public MenuEditHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FunctionsHandler handler = frame.getRightPanel().getTableData().getFunctionsHandler();
        switch (e.getActionCommand()) {
            case MENU_EDIT_ADD:
                handler.add();
                break;
            case MENU_EDIT_EDIT:
                handler.edit();
                break;
            case MENU_EDIT_DELETE:
                handler.delete();
        }
        super.actionPerformed(e);
    }
}
