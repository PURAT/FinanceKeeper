package com.example.gui;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.exception.ModelException;
import com.example.gui.dialog.*;
import com.example.gui.menu.MainMenu;
import com.example.gui.panel.AccountPanel;
import com.example.gui.panel.LeftPanel;
import com.example.gui.panel.OverviewPanel;
import com.example.gui.panel.RightPanel;
import com.example.gui.toolbar.MainToolbar;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Refresh {

    private GridBagConstraints constraints;
    private final MainMenu menubar;
    private final MainToolbar toolbar;
    private RightPanel rightPanel;
    private LeftPanel leftPanel;

    public MainFrame() {
        super(Text.PROGRAM_NAME);
        setResizable(false);
        setIconImage(Style.ICON_MAIN.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menubar = new MainMenu(this);
        setJMenuBar(menubar);

        setLayout(new GridBagLayout());

        constraints = new GridBagConstraints();

        // toolbar
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;

        toolbar = new MainToolbar();
        add(toolbar, constraints);

        // left panel
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH;

        leftPanel = new LeftPanel(this);
        add(leftPanel, constraints);

        // right panel
        setRightPanel(new OverviewPanel(this));

        pack();
        setLocationRelativeTo(null);
    }

    private void setRightPanel(RightPanel panel) {
        if (rightPanel != null)
            remove(rightPanel);
        constraints.gridy = 1;
        constraints.gridx = 1;
        constraints.gridwidth = 1;
        rightPanel = panel;
        rightPanel.setBorder(Style.BORDER_PANEL);
        add(rightPanel, constraints);
        pack();
    }

    @Override
    public void refresh() {
        SwingUtilities.updateComponentTreeUI(this);
        menubar.refresh();
        pack();
    }

    public MainMenu getMenu() {
        return menubar;
    }
}
