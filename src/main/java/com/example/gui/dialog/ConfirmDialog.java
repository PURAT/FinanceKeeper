package com.example.gui.dialog;

import com.example.gui.MainFrame;

import javax.swing.*;

public class ConfirmDialog {

    public static int show(MainFrame frame, String title, String message) {
        return JOptionPane.showConfirmDialog(frame, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
}
