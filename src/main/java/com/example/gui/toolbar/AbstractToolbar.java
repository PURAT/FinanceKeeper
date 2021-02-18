package com.example.gui.toolbar;

import com.example.gui.MainButton;
import com.example.gui.Refresh;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public abstract class AbstractToolbar extends JPanel implements Refresh {

    public AbstractToolbar(EmptyBorder border) {
        super();
        setBorder(border);
        init();

    }

    MainButton addButton(String title, ImageIcon icon, String action, boolean topIcon) {
        MainButton button = new MainButton(title, icon, null, action);
        if (topIcon) {
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
        } else {
            button.setHorizontalTextPosition(SwingConstants.RIGHT);
            button.setVerticalTextPosition(SwingConstants.CENTER);
        }
        add(button);

        return button;
    }

    abstract void init();

    @Override
    public void refresh() {
        removeAll();
        init();
    }
}
