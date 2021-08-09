package com.example.gui.table;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.table.model.AccountTableModel;
import com.example.gui.table.model.ArticleTableModel;
import com.example.handler.FunctionsHandler;

import javax.swing.*;

public class ArticleTableData extends TableData {

    private static String[] columns = new String[] {Text.ARTICLE};
    private static final ImageIcon[] icons = new ImageIcon[] {Style.ICON_ARTICLE};

    public ArticleTableData(FunctionsHandler handler) {
        super(new ArticleTableModel(columns), handler, columns, icons);
    }
}
