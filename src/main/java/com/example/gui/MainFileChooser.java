package com.example.gui;

import com.example.constants.Text;
import com.example.settings.Settings;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class MainFileChooser extends JFileChooser {

    private final Frame frame;

    public MainFileChooser(Frame frame) {
        super();
        this.frame = frame;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Файлы FinanceKeeper (*.fkp)", Settings.SAVE_FILE_EXT);
        this.setFileFilter(filter);
        this.setCurrentDirectory(Settings.SAVE_DIR);
        this.setAcceptAllFileFilterUsed(false);

        installStrings();
        updateUI();
    }

    private static void installStrings() {
        UIManager.put("FileChooser.saveDialogTitleText", Text.FC_SAVE);
        UIManager.put("FileChooser.openDialogTitleText", Text.FC_OPEN);

        UIManager.put("FileChooser.saveButtonText", Text.FC_SAVE);
        UIManager.put("FileChooser.openButtonText", Text.FC_OPEN);
        UIManager.put("FileChooser.cancelButtonText", Text.FC_CANCEL);
        UIManager.put("FileChooser.updateButtonText", Text.FC_UPDATE);
        UIManager.put("FileChooser.helpButtonText", Text.FC_HELP);
        UIManager.put("FileChooser.directoryOpenButtonText", Text.FC_OPEN_DIRECTORY);

        UIManager.put("FileChooser.saveButtonToolTipText", Text.FC_SAVE);
        UIManager.put("FileChooser.openButtonToolTipText", Text.FC_OPEN);
        UIManager.put("FileChooser.cancelButtonToolTipText", Text.FC_CANCEL);
        UIManager.put("FileChooser.updateButtonToolTipText", Text.FC_UPDATE);
        UIManager.put("FileChooser.helpButtonToolTipText", Text.FC_HELP);
        UIManager.put("FileChooser.directoryOpenButtonToolTipText", Text.FC_OPEN_DIRECTORY);

        UIManager.put("FileChooser.viewMenuLabelText", Text.FC_VIEW);
        UIManager.put("FileChooser.refreshActionLabelText", Text.FC_UPDATE);
        UIManager.put("FileChooser.newFolderActionLabelText", Text.FC_NEW_DIRECTORY);
        UIManager.put("FileChooser.detailsViewActionLabelText", Text.FC_ATTR);
        UIManager.put("FileChooser.listViewActionLabelText", Text.FC_LIST);

        UIManager.put("FileChooser.fileNameLabelText", Text.FC_NAME_FILE);
        UIManager.put("FileChooser.saveDialogTitleText", Text.FC_SAVE);
        UIManager.put("FileChooser.lookInLabelText", Text.FC_FOLDER);
        UIManager.put("FileChooser.saveInLabelText", Text.FC_FOLDER);
        UIManager.put("FileChooser.openDialogTitleText", Text.FC_OPEN);

        UIManager.put("FileChooser.fileNameLabelText", Text.FC_NAME_FILE);
        UIManager.put("FileChooser.filesOfTypeLabelText", Text.FC_TYPE_FILE);

        UIManager.put("FileChooser.homeFolderToolTipText", Text.FC_HOME);
        UIManager.put("FileChooser.upFolderToolTipText", Text.FC_UP);
        UIManager.put("FileChooser.newFolderToolTipText", Text.FC_NEW_DIRECTORY);
        UIManager.put("FileChooser.listViewButtonToolTipText", Text.FC_LIST);
        UIManager.put("FileChooser.detailsViewButtonToolTipText", Text.FC_TABLE);
        UIManager.put("FileChooser.fileNameHeaderText", Text.FC_NAME);
        UIManager.put("FileChooser.fileSizeHeaderText", Text.FC_SIZE);
        UIManager.put("FileChooser.fileTypeHeaderText", Text.FC_TYPE);
        UIManager.put("FileChooser.fileDateHeaderText", Text.FC_DATE);
        UIManager.put("FileChooser.fileAttrHeaderText", Text.FC_ATTR);

        UIManager.put("FileChooser.acceptAllFileFilterText", Text.FC_ALL_FILTER);
    }

    public int open() {
        return super.showOpenDialog(frame);
    }

    public int save() {
        return super.showSaveDialog(frame);
    }
}
