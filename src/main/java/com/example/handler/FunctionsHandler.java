package com.example.handler;

import com.example.gui.MainFrame;
import com.example.gui.dialog.AbstractAddEditDialog;
import com.example.gui.dialog.ConfirmDialog;
import com.example.gui.table.TableData;
import com.example.gui.table.model.TableModel;
import com.example.model.Common;
import com.example.saveload.SaveData;

import javax.swing.*;
import java.awt.event.*;

import static com.example.constants.CodeAction.*;
import static com.example.constants.Text.CONFIRM_DELETE_TEXT;
import static com.example.constants.Text.CONFIRM_DELETE_TITLE;

public class FunctionsHandler extends Handler implements MouseListener, KeyListener {

    private final AbstractAddEditDialog dialog;

    public FunctionsHandler(MainFrame frame, AbstractAddEditDialog dialog) {
        super(frame);
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case BUTTON_ADD:
                add();
                break;
            case BUTTON_EDIT:
                edit();
                break;
            case BUTTON_DELETE:
                delete();
        }
        super.actionPerformed(e);
    }

    private Common getSelectedCommon() {
        TableData tableData = frame.getRightPanel().getTableData();
        Common c = ((TableModel) tableData.getModel()).getCommonByRow(tableData.getSelectedRow());
        return c;
    }

    private void showAddEditDialog(Common c) {
        dialog.setCommon(c);
        dialog.showDialog();
    }

    private void add() {
        showAddEditDialog(null);
    }

    private void edit() {
        showAddEditDialog(getSelectedCommon());
    }

    private void delete() {
        Common c = getSelectedCommon();
        if (c != null) {
            int result = ConfirmDialog.show(frame, CONFIRM_DELETE_TITLE, CONFIRM_DELETE_TEXT);
            if (result == JOptionPane.YES_OPTION)
                SaveData.getInstance().remove(c);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DELETE) {
            delete();
            frame.refresh();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof TableData) {
            if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1)
                edit();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() instanceof TableData) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                TableData tableData = frame.getRightPanel().getTableData();
                int row = tableData.rowAtPoint(e.getPoint());
                tableData.setRowSelectionInterval(row, row);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
