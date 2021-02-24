package com.example.gui;

import com.example.constants.Style;
import com.example.constants.Text;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.util.Date;
import java.util.Properties;

public class MainDatePicker {

    private final JDatePickerImpl datePicker;

    public MainDatePicker() {
        UtilDateModel model = new UtilDateModel();
        model.setValue(new Date());
        Properties props = new Properties();
        props.put("text.today", Text.DATE);
        JDatePanelImpl panel = new JDatePanelImpl(model, props);

        datePicker = new JDatePickerImpl(panel, new DateComponentFormatter());

        JButton button = (JButton) datePicker.getComponent(1);
        button.setIcon(Style.ICON_CALENDAR);
        button.setText("");
    }

    public JDatePickerImpl getDatePicker() {
        return datePicker;
    }

    public void setDate(Date date) {
        ((UtilDateModel) datePicker.getModel()).setValue(date);
    }
}
