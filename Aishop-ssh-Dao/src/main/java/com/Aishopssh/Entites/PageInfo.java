package com.Aishopssh.Entites;

import java.io.Serializable;

public class PageInfo <T> implements Serializable {
    private int total;
    private T data;
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
