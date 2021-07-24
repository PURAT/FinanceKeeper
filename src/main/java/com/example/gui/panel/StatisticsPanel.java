package com.example.gui.panel;

import com.example.constants.Style;
import com.example.gui.Chart;
import com.example.gui.MainFrame;
import com.example.saveload.SaveData;
import com.example.util.BalanceStatistics;
import org.jfree.chart.ChartPanel;

import javax.swing.*;

import static com.example.constants.Text.*;

public class StatisticsPanel extends RightPanel {
    public static final int TYPE_INCOME = 0;
    public static final int TYPE_EXPENSE = 1;
    public static int type = TYPE_INCOME;


    public StatisticsPanel(MainFrame frame) {
        super(frame, null, PANEL_STATISTICS, Style.ICON_MENU_VIEW_STATISTICS, new JPanel[] {
                new FilterPanel(frame),
                new StatisticsTypePanel(frame, CHART_INCOME),
                new Chart(BalanceStatistics.getDataForChartIncome(), CHART_INCOME,
                        SaveData.getInstance().getBaseCurrency().getCode()).getPanel() });
    }

    public void nextType() {
        type = (type == TYPE_INCOME) ? TYPE_EXPENSE : TYPE_INCOME;
    }

    @Override
    public void refresh() {
        Chart chart = null;
        String title;
        String currencyCode = SaveData.getInstance().getBaseCurrency().getCode();
        if (type == TYPE_INCOME) {
            title = CHART_INCOME;
            chart = new Chart(BalanceStatistics.getDataForChartIncome(), title, currencyCode);
        } else {
            title = CHART_EXPENSE;
            chart = new Chart(BalanceStatistics.getDataForChartExpense(), title, currencyCode);
        }
        setPanels(new JPanel[] { new FilterPanel(frame), new StatisticsTypePanel(frame, title), chart.getPanel() });
        super.refresh();
    }
}
