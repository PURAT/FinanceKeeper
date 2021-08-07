package com.example.handler;

import com.example.gui.MainFrame;
import com.example.saveload.SaveData;
import com.example.util.DateFilter;

import java.awt.event.ActionEvent;

import static com.example.constants.CodeAction.*;

public class FilterHandler extends Handler {

    public FilterHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DateFilter filter = SaveData.getInstance().getDateFilter();
        switch (e.getActionCommand()) {
            case BUTTON_LEFT:
                filter.previous();
                break;
            case BUTTON_RIGHT:
                filter.next();
                break;
            case BUTTON_STEP:
                filter.nextStep();
        }
        super.actionPerformed(e);
    }
}
