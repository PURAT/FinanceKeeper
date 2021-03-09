package com.example.gui.dialog;

import com.example.constants.CodeAction;
import com.example.constants.Style;
import com.example.constants.Text;
import com.example.exception.ModelException;
import com.example.gui.MainButton;
import com.example.gui.MainFrame;
import com.example.model.Common;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractAddEditDialog extends JDialog {

    protected LinkedHashMap<String, JComponent> components = new LinkedHashMap<>();
    protected LinkedHashMap<String, ImageIcon> icons = new LinkedHashMap<>();
    protected LinkedHashMap<String, Object> values = new LinkedHashMap<>();
    protected Common c;

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
        if (isAdd()) {
            setTitle(Text.ADD);
            setIconImage(Style.ICON_DIALOG_ADD.getImage());
        } else {
            setTitle(Text.EDIT);
            setIconImage(Style.ICON_DIALOG_EDIT.getImage());
            setValues();
        }

        getContentPane().removeAll();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        ((JPanel) getContentPane()).setBorder(Style.BORDER_DIALOG);
        for (Map.Entry<String, JComponent> entry : components.entrySet()) {
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
            component.setAlignmentX(JComponent.LEFT_ALIGNMENT);

            add(label);
            add(Box.createVerticalStrut(Style.PADDING_DIALOG_LABEL));
            add(component);
            add(Box.createVerticalStrut(Style.PADDING_DIALOG));
        }

        MainButton ok = new MainButton(Text.ADD, Style.ICON_BUTTON_OK, null, CodeAction.BUTTON_ADD);
        if (!isAdd()) {
            ok.setText(Text.EDIT);
            ok.setActionCommand(CodeAction.BUTTON_EDIT);
        }

        MainButton cancel = new MainButton(Text.CANCEL, Style.ICON_BUTTON_CANCEL, null, CodeAction.BUTTON_CANCEL);

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new BorderLayout());
        panelButtons.add(ok, BorderLayout.EAST);
        panelButtons.add(Box.createRigidArea(Style.DIMENSION_DIALOG_PADDING_BUTTON));
        panelButtons.add(cancel, BorderLayout.WEST);
        panelButtons.setAlignmentX(JPanel.LEFT_ALIGNMENT);

        add(panelButtons);

        pack();
        setLocationRelativeTo(null);
    }

    protected abstract void init();

    protected abstract void setValues();

    protected abstract Common getCommonFromForm() throws ModelException;


    static class CommonComboBox extends JComboBox<Object> {

        CommonComboBox(Object[] objs) {
            super(objs);
            setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    DefaultListCellRenderer renderer = (DefaultListCellRenderer) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    Common c = (Common) value;
                    if (c != null)
                        renderer.setText(c.getValueForBox());
                    return renderer;
                }
            });
        }
    }
}
