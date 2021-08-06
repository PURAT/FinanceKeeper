package com.example.gui.panel;

import com.example.constants.CodeAction;
import com.example.constants.Style;
import com.example.gui.MainButton;
import com.example.gui.MainFrame;

import java.awt.*;

public class StatisticsTypePanel extends AbstractPanel {

    private final String title;

    public StatisticsTypePanel(MainFrame frame, String title) {
        super(frame);
        this.title = title;
        init();
    }

    @Override
    protected void init() {
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setVgap(0);
        setLayout(flowLayout);
        setBorder(Style.BORDER_FILTER_PANEL);
        MainButton buttonType = new MainButton(title, null, CodeAction.BUTTON_TYPE);
        setBorder(Style.BORDER_FILTER_PANEL);
        add(buttonType);
    }
}


