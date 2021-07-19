package com.example.gui.dialog;

import com.example.constants.Text;
import com.example.gui.MainFrame;

import javax.swing.*;

public class ErrorDialog {

    public static void show(MainFrame frame, String message) {
        JOptionPane.showMessageDialog(frame, message, Text.ERROR, JOptionPane.ERROR_MESSAGE);
    }
}
