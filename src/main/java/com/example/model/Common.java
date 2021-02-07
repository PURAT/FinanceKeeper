package com.example.model;

import com.example.exception.ModelException;
import com.example.saveload.SaveData;

public abstract class Common {

    public abstract void postAdd(SaveData data);

    public abstract void postEdit(SaveData data);

    public abstract void postRemove(SaveData data);

    public abstract String getValueForBox();

    public abstract void checkOnException() throws ModelException;
}
