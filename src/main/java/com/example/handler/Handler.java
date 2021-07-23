package com.example.handler;

import com.example.gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Handler implements ActionListener {
    protected MainFrame frame;

    public Handler(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.refresh();
    }
}
