package com.example.model;

import com.example.exception.ModelException;

public abstract class Common {

    public Common() throws ModelException {
        checkOnException();
    }

    public void postAdd() { }

    public void postEdit() { }

    public void postRemove() { }

    public abstract String getValueForBox();

    public abstract void checkOnException() throws ModelException;
}
