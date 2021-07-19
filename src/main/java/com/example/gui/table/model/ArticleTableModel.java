package com.example.gui.table.model;

import com.example.model.Article;
import com.example.saveload.SaveData;
import com.example.util.Formatter;

public class ArticleTableModel extends TableModel {

    private static final int TITLE = 0;

    public ArticleTableModel(String[] columns) {
        super(SaveData.getInstance().getArticles(), columns);
    }

    @Override
    protected void updateData() {
        data = SaveData.getInstance().getArticles();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (data.isEmpty())
            return  null;
        Article article = (Article) data.get(rowIndex);
        if (columnIndex == TITLE) {
            return article.getTitle();
        }
        return null;
    }
}
