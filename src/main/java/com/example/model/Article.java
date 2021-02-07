package com.example.model;

import com.example.exception.ModelException;
import com.example.saveload.SaveData;

import java.util.Objects;

public class Article extends Common {

    private String title;

    public Article(String title) throws ModelException {
        this.title = title;

        checkOnException();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void postAdd(SaveData data) { }

    @Override
    public void postEdit(SaveData data) {
        for (Transaction transaction: data.getTransactions()) {
            if (transaction.getArticle().equals(data.getOldCommon()))
                transaction.setArticle(this);
        }
    }

    @Override
    public void postRemove(SaveData data) { }

    @Override
    public String getValueForBox() {
        return title;
    }

    @Override
    public void checkOnException() throws ModelException {
        if (title.length() == 0)
            throw new ModelException(ModelException.TITLE_EMPTY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return title.equals(article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Article{" + "title='" + title + '\'' + '}';
    }
}
