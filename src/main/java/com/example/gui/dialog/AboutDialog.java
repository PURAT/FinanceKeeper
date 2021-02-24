package com.example.gui.dialog;

import com.example.constants.Style;
import com.example.constants.Text;

import javax.swing.*;

public class AboutDialog extends JDialog {

    public AboutDialog() {
        super();
        init();
        setResizable(false);
        setTitle(Text.DIALOG_ABOUT_TITLE);
        setIconImage(Style.ICON_DIALOG_ABOUT.getImage());
    }

    private void init() {
        JEditorPane pane = new JEditorPane("text/html", Text.ABOUT);
        pane.setEditable(false);
        pane.setOpaque(false);

        add(pane);
        pack();
        setLocationRelativeTo(null);
    }
}
