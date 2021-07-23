package com.example.gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.editor.DefaultChartEditorFactory;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static com.example.constants.Style.DIMENSION_CHART;
import static com.example.constants.Style.FONT_HEADER;
import static com.example.constants.Text.CHART_NO_DATA;

public class Chart {

    private DefaultPieDataset dataset;
    private String title;
    private String currencyTitle;

    public Chart(HashMap<String, Double> data, String title, String currencyTitle) {
        setData(data);
        this.title = title;
        this.currencyTitle = currencyTitle;
    }

    private void setData(HashMap<String, Double> data) {
        dataset = new DefaultPieDataset();
        for (Map.Entry<String, Double> entry: data.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
    }

    public JPanel getPanel() {
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setToolTipGenerator(new StandardPieToolTipGenerator("{0}: {1} " + currencyTitle + " ({2})"));
        JPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(DIMENSION_CHART);
        if (dataset.getItemCount() == 0) {
            panel.setLayout(new GridLayout());
            JLabel label = new JLabel(CHART_NO_DATA);
            label.setFont(FONT_HEADER);
            panel.add(label);
        }
        return panel;
    }


}
