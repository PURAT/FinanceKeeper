package com.example.gui.dialog;

import com.example.constants.Style;
import com.example.constants.Text;
import com.example.exception.ModelException;
import com.example.gui.MainFrame;
import com.example.model.Article;
import com.example.model.Common;

import javax.swing.*;

public class ArticleAddEditDialog extends AbstractAddEditDialog {

    public ArticleAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        components.put(Text.TITLE, new JTextField());
        icons.put(Text.TITLE, Style.ICON_TITLE);
    }

    @Override
    protected void setValues() {
        Article article = (Article) c;
        values.put(Text.TITLE, article.getTitle());
    }

    @Override
    protected Common getCommonFromForm() throws ModelException {
        String title = ((JTextField) components.get(Text.TITLE)).getText();
        return new Article(title);
    }
}
