package com.Aishopssh.Entites;

import java.util.Objects;

public class Cartlist {
    private int id;
    private int goodsId;
    private int userId;
    private int goodsNum;
    private String goodsAddTime;
    private String orderNum;
    private Goods tbGoodsByGoodsId;
    private User tbUserByUserId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsAddTime() {
        return goodsAddTime;
    }

    public void setGoodsAddTime(String goodsAddTime) {
        this.goodsAddTime = goodsAddTime;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cartlist cartlist = (Cartlist) o;

        if (id != cartlist.id) return false;
        if (goodsId != cartlist.goodsId) return false;
        if (userId != cartlist.userId) return false;
        if (goodsNum != cartlist.goodsNum) return false;
        if (!Objects.equals(goodsAddTime, cartlist.goodsAddTime))
            return false;
        return Objects.equals(orderNum, cartlist.orderNum);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + goodsId;
        result = 31 * result + userId;
        result = 31 * result + goodsNum;
        result = 31 * result + (goodsAddTime != null ? goodsAddTime.hashCode() : 0);
        result = 31 * result + (orderNum != null ? orderNum.hashCode() : 0);
        return result;
    }

    public Goods getTbGoodsByGoodsId() {
        return tbGoodsByGoodsId;
    }

    public void setTbGoodsByGoodsId(Goods tbGoodsByGoodsId) {
        this.tbGoodsByGoodsId = tbGoodsByGoodsId;
    }

    public User getTbUserByUserId() {
        return tbUserByUserId;
    }

    public void setTbUserByUserId(User tbUserByUserId) {
        this.tbUserByUserId = tbUserByUserId;
    }
}
