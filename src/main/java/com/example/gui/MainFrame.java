package com.example.gui;

import com.example.constants.Style;
import com.example.constants.Text;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Refresh {

    private GridBagConstraints constraints;

    public MainFrame() {
        super(Text.PROGRAM_NAME);
        setResizable(false);
        setIconImage(Style.ICON_MAIN.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());

        constraints = new GridBagConstraints();

        // toolbar
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;

        // left panel
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH;

        setLocationRelativeTo(null);

        pack();
    }

    @Override
    public void refresh() {
        SwingUtilities.updateComponentTreeUI(this);
        pack();
    }
}
