package com.example.handler;

import com.example.constants.Text;
import com.example.gui.MainFileChooser;
import com.example.gui.MainFrame;
import com.example.gui.dialog.ConfirmDialog;
import com.example.gui.dialog.ErrorDialog;
import com.example.saveload.SaveData;
import com.example.settings.Settings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

import static com.example.constants.CodeAction.MENU_FILE_EXIT;
import static com.example.constants.CodeAction.MENU_FILE_NEW;
import static com.example.constants.CodeAction.MENU_FILE_OPEN;
import static com.example.constants.CodeAction.MENU_FILE_SAVE;
import static com.example.constants.CodeAction.MENU_FILE_UPDATE_CURRENCIES;
import static com.example.constants.Text.*;

public class MenuFileHandler extends Handler {

    private final MainFileChooser fc;

    public MenuFileHandler(MainFrame frame) {
        super(frame);
        fc = new MainFileChooser(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case MENU_FILE_NEW: {
                // TODO
                Settings.setFileSave(null);
                SaveData.getInstance().clear();
            }
                break;
            case MENU_FILE_OPEN: {
                int result = fc.open();
                if (result == JFileChooser.APPROVE_OPTION) {
                    Settings.setFileSave(fc.getSelectedFile());
                    SaveData.getInstance().clear();
                    SaveData.getInstance().load();
                }
            }
                break;
            case MENU_FILE_SAVE: {
                if (Settings.getFileSave() == null) {
                    int result = fc.save();
                    if (result == JFileChooser.APPROVE_OPTION) {
                        String path = fc.getSelectedFile().getAbsolutePath();
                        if (path.endsWith("." + Settings.SAVE_FILE_EXT))
                            Settings.setFileSave(new File(path));
                        else
                            Settings.setFileSave(new File(path + "." + Settings.SAVE_FILE_EXT));
                    }
                }
                if (Settings.getFileSave() != null) {
                    SaveData.getInstance().save();
                }

            }  break;
            case MENU_FILE_UPDATE_CURRENCIES: {
                try {
                    SaveData.getInstance().updateCurrencies();
                } catch (Exception exception) {
                    ErrorDialog.show(frame, ERROR_UPDATE_CURRENCIES);
                }
            }
                break;
            case MENU_FILE_EXIT: {
                if (SaveData.getInstance().isSaved())
                    System.exit(0);
                else {
                    int result = ConfirmDialog.show(frame, CONFIRM_EXIT_TITLE, CONFIRM_EXIT_TEXT);
                    if (result == JOptionPane.YES_OPTION)
                        System.exit(0);
                }
            }
        }
        super.actionPerformed(e);
    }
}
