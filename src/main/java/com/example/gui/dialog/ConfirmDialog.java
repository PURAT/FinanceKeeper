package com.example.gui.dialog;

import com.example.gui.MainFrame;

import javax.swing.*;
import java.util.Locale;

import static com.example.constants.Text.NO;
import static com.example.constants.Text.YES;

public class ConfirmDialog {

    public static int show(MainFrame frame, String title, String message) {
        installStrings();
        return JOptionPane.showConfirmDialog(frame, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    private static void installStrings() {
        UIManager.put("OptionPane.yesButtonText", YES);
        UIManager.put("OptionPane.noButtonText", NO);
    }
}
