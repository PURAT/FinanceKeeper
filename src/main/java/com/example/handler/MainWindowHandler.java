package com.example.handler;

import com.example.gui.MainFrame;
import com.example.gui.dialog.ConfirmDialog;
import com.example.saveload.SaveData;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.example.constants.Text.CONFIRM_EXIT_TEXT;
import static com.example.constants.Text.CONFIRM_EXIT_TITLE;

public class MainWindowHandler extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        if (SaveData.getInstance().isSaved())
            System.exit(0);
        else {
            int result = ConfirmDialog.show((MainFrame) e.getWindow(), CONFIRM_EXIT_TITLE, CONFIRM_EXIT_TEXT);
            if (result == JOptionPane.YES_OPTION)
                System.exit(0);
        }
    }
}
