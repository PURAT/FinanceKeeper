package com.example.gui.panel;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.MainFrame;
import com.example.gui.table.ArticleTableData;
import com.example.gui.toolbar.EditToolbar;

public class ArticlePanel extends RightPanel {
    public ArticlePanel(MainFrame frame) {
        super(frame, new ArticleTableData(), Text.PANEL_ARTICLES, Style.ICON_PANEL_ARTICLES, new EditToolbar());
    }
}
