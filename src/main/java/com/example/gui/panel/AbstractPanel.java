package com.example.gui.panel;

import com.example.gui.MainFrame;
import com.example.gui.Refresh;

import javax.swing.*;

public abstract class AbstractPanel extends JPanel implements Refresh {

    protected final MainFrame frame;

    public AbstractPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    protected abstract void init();

    @Override
    public void refresh() {
        removeAll();
        init();
    }

}
