package com.example.gui.dialog;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.exception.ModelException;
import com.example.gui.MainFrame;
import com.example.model.Common;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

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

        getContentPane().removeAll();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        ((JPanel) getContentPane()).setBorder(Style.BORDER_DIALOG);
        for (Map.Entry<String, JComponent> entry: components.entrySet()) {
            String key = entry.getKey();
            JLabel label = new JLabel(key);
            label.setIcon(icons.get(key));
            label.setFont(Style.FONT_DIALOG_LABEL);

            JComponent component = entry.getValue();
            if (component instanceof JTextField) {
                component.setPreferredSize(Style.DIMENSION_DIALOG_TEXTFIELD_SIZE);
                if (values.containsKey(key))
                    ((JTextField) component).setText("" + values.get(key));
            } else if (component instanceof JComboBox) {
                if (values.containsKey(key))
                    ((JComboBox) component).setSelectedItem(values.get(key));
            } else if (component instanceof JDatePickerImpl) {
                if (values.containsKey(key))
                    ((UtilDateModel) ((JDatePickerImpl) component).getModel()).setValue((Date) values.get(key));
            }

            add(label);
            add(Box.createVerticalStrut(Style.PADDING_DIALOG));
            add(component);
            add(Box.createVerticalStrut(Style.PADDING_DIALOG));
        }

        //TODO buttons
    }

    protected abstract void init();

    protected abstract void setValues();

    protected abstract Common getCommonFromForm() throws ModelException;
}
