package com.example.handler;

import com.example.gui.MainFrame;
import com.example.gui.panel.StatisticsPanel;
import com.example.saveload.SaveData;
import com.example.util.DateFilter;

import java.awt.event.ActionEvent;

import static com.example.constants.CodeAction.*;

public class ChartHandler extends Handler {

    public ChartHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case BUTTON_TYPE:
                ((StatisticsPanel) frame.getRightPanel()).nextType();
        }
        super.actionPerformed(e);
    }
}
