package com.example.gui.panel;

import com.example.constants.CodeAction;
import com.example.gui.MainButton;
import com.example.gui.MainFrame;

public class StatisticsTypePanel extends AbstractPanel {

    private final String title;

    public StatisticsTypePanel(MainFrame frame, String title) {
        super(frame);
        this.title = title;
        init();
    }

    @Override
    protected void init() {
        MainButton buttonType = new MainButton(title, null, CodeAction.BUTTON_TYPE);
        add(buttonType);
    }
}


