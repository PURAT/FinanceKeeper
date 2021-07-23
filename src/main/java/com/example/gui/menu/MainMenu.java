package com.example.gui.menu;

import com.example.constants.CodeAction;
import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.EnableEditDelete;
import com.example.gui.MainFrame;
import com.example.gui.Refresh;
import com.example.handler.Handler;
import com.example.handler.MenuFileHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MainMenu extends JMenuBar implements Refresh, EnableEditDelete {

    private JMenuItem menuEdit;
    private JMenuItem menuDelete;
    private final MainFrame frame;

    public MainMenu(MainFrame frame) {
        super();
        this.frame = frame;
        init();
    }

    private void init() {
        JMenu file = new JMenu(Text.MENU_FILE);
        JMenu edit = new JMenu(Text.MENU_EDIT);
        JMenu view = new JMenu(Text.MENU_VIEW);
        JMenu help = new JMenu(Text.MENU_HELP);

        file.setIcon(Style.ICON_MENU_FILE);
        edit.setIcon(Style.ICON_MENU_EDIT);
        view.setIcon(Style.ICON_MENU_VIEW);
        help.setIcon(Style.ICON_MENU_HELP);

        this.add(file);
        this.add(edit);
        this.add(view);
        this.add(help);

        MenuFileHandler fileHandler = new MenuFileHandler(frame);
        MenuFileHandler editHandler = new MenuFileHandler(frame);
        MenuFileHandler viewHandler = new MenuFileHandler(frame);
        MenuFileHandler helpHandler = new MenuFileHandler(frame);

        addMenuItem(file, fileHandler, Text.MENU_FILE_NEW, Style.ICON_MENU_FILE_NEW, CodeAction.MENU_FILE_NEW, KeyEvent.VK_N);
        addMenuItem(file, fileHandler,Text.MENU_FILE_OPEN, Style.ICON_MENU_FILE_OPEN, CodeAction.MENU_FILE_OPEN, KeyEvent.VK_O);
        addMenuItem(file, fileHandler,Text.MENU_FILE_SAVE, Style.ICON_MENU_FILE_SAVE, CodeAction.MENU_FILE_SAVE, KeyEvent.VK_S);
        addMenuItem(file, fileHandler,Text.MENU_FILE_UPDATE_CURRENCIES, Style.ICON_MENU_FILE_UPDATE_CURRENCIES, CodeAction.MENU_FILE_UPDATE_CURRENCIES);
        addMenuItem(file, fileHandler,Text.MENU_FILE_EXIT, Style.ICON_MENU_FILE_EXIT, CodeAction.MENU_FILE_EXIT);

        addMenuItem(edit, editHandler, Text.MENU_EDIT_ADD, Style.ICON_MENU_EDIT_ADD, CodeAction.MENU_EDIT_ADD);
        menuEdit = addMenuItem(edit, editHandler, Text.MENU_EDIT_EDIT, Style.ICON_MENU_EDIT_EDIT, CodeAction.MENU_EDIT_EDIT);
        menuDelete = addMenuItem(edit, editHandler, Text.MENU_EDIT_DELETE, Style.ICON_MENU_EDIT_DELETE, CodeAction.MENU_EDIT_DELETE);

        addMenuItem(view, viewHandler, Text.MENU_VIEW_OVERVIEW, Style.ICON_MENU_VIEW_OVERVIEW, CodeAction.MENU_VIEW_OVERVIEW);
        addMenuItem(view, viewHandler, Text.MENU_VIEW_ARTICLES, Style.ICON_MENU_VIEW_ARTICLES, CodeAction.MENU_VIEW_ARTICLES);
        addMenuItem(view, viewHandler, Text.MENU_VIEW_ACCOUNTS, Style.ICON_MENU_VIEW_ACCOUNTS, CodeAction.MENU_VIEW_ACCOUNTS);
        addMenuItem(view, viewHandler, Text.MENU_VIEW_CURRENCIES, Style.ICON_MENU_VIEW_CURRENCIES, CodeAction.MENU_VIEW_CURRENCIES);
        addMenuItem(view, viewHandler, Text.MENU_VIEW_STATISTICS, Style.ICON_MENU_VIEW_STATISTICS, CodeAction.MENU_VIEW_STATISTICS);
        addMenuItem(view, viewHandler, Text.MENU_VIEW_TRANSFERS, Style.ICON_MENU_VIEW_TRANSFERS, CodeAction.MENU_VIEW_TRANSFERS);
        addMenuItem(view, viewHandler, Text.MENU_VIEW_TRANSACTIONS, Style.ICON_MENU_VIEW_TRANSACTIONS, CodeAction.MENU_VIEW_TRANSACTIONS);

        addMenuItem(help, helpHandler, Text.MENU_HELP_ABOUT, Style.ICON_MENU_HELP_ABOUT, CodeAction.MENU_HELP_ABOUT);

    }

    private JMenuItem addMenuItem(JMenu menu, Handler listener, String title, ImageIcon icon, String action, int key) {
        JMenuItem item = new JMenuItem(title);
        item.setIcon(icon);
        item.setActionCommand(action);
        item.addActionListener(listener);
        if (key != 0) {
            KeyStroke shortKey = KeyStroke.getKeyStroke(key, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
            item.setAccelerator(shortKey);
        }
        menu.add(item);

        return item;
    }

    private JMenuItem addMenuItem(JMenu menu, Handler listener, String title, ImageIcon icon, String action) {
        return addMenuItem(menu, listener, title, icon, action, 0);
    }

    @Override
    public void setEnableEditDelete(boolean enable) {
        menuEdit.setEnabled(enable);
        menuDelete.setEnabled(enable);
    }

    @Override
    public void refresh() {
        removeAll();
        init();
    }
}
