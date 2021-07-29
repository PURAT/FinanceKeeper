package com.example.gui.toolbar;

import com.example.gui.MainButton;
import com.example.gui.Refresh;
import com.example.handler.Handler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public abstract class AbstractToolbar extends JPanel implements Refresh {
    private final Handler handler;

    public AbstractToolbar(EmptyBorder border, Handler handler) {
        super();
        setBorder(border);
        this.handler = handler;
        init();
    }

    MainButton addButton(String title, ImageIcon icon, String action, boolean topIcon) {
        MainButton button = new MainButton(title, icon, handler, action);
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
