package com.example.handler;

import com.example.exception.ModelException;
import com.example.gui.MainFrame;
import com.example.gui.dialog.AbstractAddEditDialog;
import com.example.gui.dialog.ErrorDialog;
import com.example.saveload.SaveData;

import java.awt.event.*;

import static com.example.constants.CodeAction.*;

public class AddEditDialogHandler extends Handler implements WindowListener, KeyListener {

    private final AbstractAddEditDialog dialog;

    public AddEditDialogHandler(MainFrame frame, AbstractAddEditDialog dialog) {
        super(frame);
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case BUTTON_ADD:
                addEdit(true);
                break;
            case BUTTON_EDIT:
                addEdit(false);
                break;
            case BUTTON_CANCEL:
                closeDialog();
        }
        super.actionPerformed(e);
    }

   private void addEdit(boolean add) {
       try {
           if (add)
               SaveData.getInstance().add(dialog.getCommonFromForm());
           else
               SaveData.getInstance().edit(dialog.getCommon(), dialog.getCommonFromForm());
           closeDialog();
       } catch (ModelException ex) {
           ErrorDialog.show(frame, ex.getMessage());
       }
   }

    private void closeDialog() {
        dialog.closeDialog();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
            addEdit(dialog.isAdd());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
