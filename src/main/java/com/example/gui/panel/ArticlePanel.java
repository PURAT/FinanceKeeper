package com.example.gui.panel;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.MainFrame;
import com.example.gui.dialog.AccountAddEditDialog;
import com.example.gui.dialog.ArticleAddEditDialog;
import com.example.gui.table.ArticleTableData;
import com.example.gui.toolbar.EditToolbar;
import com.example.handler.FunctionsHandler;

public class ArticlePanel extends RightPanel {
    public ArticlePanel(MainFrame frame) {
        super(frame, new ArticleTableData(new FunctionsHandler(frame, new ArticleAddEditDialog(frame))),
                Text.PANEL_ARTICLES, Style.ICON_PANEL_ARTICLES,
                new EditToolbar(new FunctionsHandler(frame, new ArticleAddEditDialog(frame))));
    }
}
