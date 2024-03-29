package com.example.settings;

import org.ini4j.Ini;
import org.ini4j.IniPreferences;
import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

public final class Settings {

    public static final File SAVE_DIR = new File("saves/");
    public static final String SAVE_FILE_EXT = "fkp";

    public static final File FILE_SETTINGS = new File("saves/settings.ini");
    private static File FILE_SAVE = new File("saves/default.fkp");
    public static final File PATH_ROBOTO_LIGHT = new File("fonts/roboto/Roboto-Light.ttf");

    public static final String[] CURRENCIES_CODES = new String[]{"RUB", "USD", "EUR", "BYN", "UAH"};
    public static final int COUNT_OVERVIEW_ROWS = 10;

    public static void init() {
        try {
            setLocale();
            Ini ini = new Ini(FILE_SETTINGS);
            Preferences pref = new IniPreferences(ini);
            String file = pref.node("Settings").get("FILE_SAVE", null);
            if (file != null) {
                FILE_SAVE = new File(file);
            }
        } catch (IOException e) {
            try {
                if (FILE_SETTINGS.createNewFile()) save();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
    }

    public static File getFileSave() {
        return FILE_SAVE;
    }

    public static void setFileSave(File file) {
        FILE_SAVE = file;
        save();
    }

    private static void save() {
        try {
            Wini ini = new Wini(FILE_SETTINGS);
            if (FILE_SAVE != null)
                ini.put("Settings", "FILE_SAVE", FILE_SAVE.getAbsolutePath().replace("\\", "\\\\"));
            ini.store();
        } catch (IOException e) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private static void setLocale() {
        Locale.setDefault(new Locale("ru"));
    }
}
