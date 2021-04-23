package com.example.gui.table;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.table.model.AccountTableModel;

import javax.swing.*;

public class ArticleTableData extends TableData {

    private static String[] columns = new String[] {Text.ARTICLE};
    private static final ImageIcon[] icons = new ImageIcon[] {Style.ICON_TITLE};

    public ArticleTableData() {
        super(new AccountTableModel(columns), columns, icons);
    }
}
