package com.example.gui;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.menu.MainMenu;
import com.example.gui.toolbar.EditToolbar;
import com.example.gui.toolbar.MainToolbar;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Refresh {

    private GridBagConstraints constraints;
    private final MainMenu menubar;
    private final MainToolbar toolbar;

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

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void refresh() {
        SwingUtilities.updateComponentTreeUI(this);
        menubar.refresh();
        pack();
    }
}
