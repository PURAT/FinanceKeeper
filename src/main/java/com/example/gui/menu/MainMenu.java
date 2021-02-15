package com.example.gui.menu;

import com.example.gui.EnableEditDelete;
import com.example.gui.MainFrame;
import com.example.gui.Refresh;

import javax.swing.*;

public class MainMenu extends JMenuBar implements Refresh, EnableEditDelete {

    private JMenuItem menuEdit;
    private JMenuItem menuDelete;
    private final MainFrame frame;

    public MainMenu(MainFrame frame) {
        super();
        this.frame = frame;
        init();
    }

    private void init() {

    }

    @Override
    public void setEnableEditDelete(boolean enable) {

    }

    @Override
    public void refresh() {

    }
}
