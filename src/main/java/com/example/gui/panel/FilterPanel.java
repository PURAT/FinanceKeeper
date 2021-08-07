package com.example.gui.panel;

import com.example.constants.CodeAction;
import com.example.constants.Style;
import com.example.gui.MainButton;
import com.example.gui.MainFrame;
import com.example.handler.FilterHandler;
import com.example.saveload.SaveData;
import com.example.util.Formatter;

import java.awt.*;

public final class FilterPanel extends AbstractPanel {


    public FilterPanel(MainFrame frame) {
        super(frame);
        init();
    }

    @Override
    protected void init() {
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setVgap(0);
        setLayout(flowLayout);

        MainButton left = new MainButton(Style.ICON_BUTTON_LEFT, new FilterHandler(frame), CodeAction.BUTTON_LEFT);
        MainButton step = new MainButton(Formatter.formatDateFromTitle(SaveData.getInstance().getDateFilter()),
                new FilterHandler(frame), CodeAction.BUTTON_STEP);
        MainButton right = new MainButton(Style.ICON_BUTTON_RIGHT, new FilterHandler(frame), CodeAction.BUTTON_RIGHT);

        setBorder(Style.BORDER_FILTER_PANEL);
        step.setFont(Style.FONT_BUTTON_FILTER);
        step.setPreferredSize(new Dimension(Style.WIDTH_BUTTON_FILTER, left.getPreferredSize().height));

        add(left);
        add(step);
        add(right);
    }
}
