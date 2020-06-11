package com.jenson.common.mvvm;

import android.util.SparseArray;

/**
 * author: CDJenson
 * date: 2020/5/20 11:13
 * version: 1.0
 * description: One-sentence description
 */
public class DataBindingConfig {

    private int variableId;
    private SparseArray bindingParams = new SparseArray();

    public DataBindingConfig(int variableId) {
        this.variableId = variableId;
    }

    public int getVariableId() {
        return variableId;
    }

    public SparseArray getBindingParams() {
        return bindingParams;
    }

    public DataBindingConfig addBindingParam(int variableId, Object object) {
        if (bindingParams.get(variableId) == null) {
            bindingParams.put(variableId, object);
        }
        return this;
    }
}
