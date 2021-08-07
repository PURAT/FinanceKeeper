package com.example.handler;

import com.example.gui.MainFrame;
import com.example.gui.dialog.AboutDialog;
import com.example.gui.panel.*;

import java.awt.event.ActionEvent;

import static com.example.constants.CodeAction.*;

public class MenuHelpHandler extends Handler {

    public MenuHelpHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case MENU_HELP_ABOUT:
                new AboutDialog().setVisible(true);
        }
        super.actionPerformed(e);
    }
}
