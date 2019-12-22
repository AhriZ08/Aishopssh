package com.Aishopssh.Entites;

public class PageInfo <T>{
    private int total;
    T data;
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
