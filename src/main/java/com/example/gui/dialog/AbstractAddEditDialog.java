package com.example.gui.dialog;

import com.example.constants.Text;
import com.example.exception.ModelException;
import com.example.gui.MainFrame;
import com.example.model.Common;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public abstract class AbstractAddEditDialog extends JDialog {

    protected LinkedHashMap<String, JComponent> components = new LinkedHashMap<>();
    protected LinkedHashMap<String, ImageIcon> icons = new LinkedHashMap<>();
    protected LinkedHashMap<String, Object> values = new LinkedHashMap<>();
    private Common c;

    public AbstractAddEditDialog(MainFrame frame) {
        super(frame, Text.ADD, true);
        setResizable(false);
    }

    public Common getCommon() {
        return c;
    }

    public void setCommon(Common c) {
        this.c = c;
    }

    public boolean isAdd() {
        return c == null;
    }

    public final void closeDialog() {
        setVisible(false);
        c = null;
        components.clear();
        icons.clear();
        values.clear();

        dispose();
    }

    public final void showDialog() {
        setDialog();
        setVisible(true);
    }

    private void setDialog() {
        init();
        if (isAdd())
            setTitle(Text.ADD);
        else {
            setTitle(Text.EDIT);
            setValues();
        }

        //TODO
        getContentPane().removeAll();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    protected abstract void init();

    protected abstract void setValues();

    protected abstract Common getCommonFromForm() throws ModelException;
}
