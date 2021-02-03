package com.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.settings.Settings.PATH_ROBOTO_LIGHT;


public class FinanceKeeper {
    public static void main(String[] args) {
        init();
    }

    private static void init() {
        try {
            GraphicsEnvironment graphEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            graphEnv.registerFont(Font.createFont(Font.TRUETYPE_FONT, PATH_ROBOTO_LIGHT));
        } catch (FontFormatException | IOException e) {
            Logger.getLogger(FinanceKeeper.class.getName()).log(Level.SEVERE, "Problems with fonts...", e);
        }
    }
}
