package com.Aishopssh.Entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_cartlist", schema = "e_shopwebsite")
public class TbCartlist {
    private int id;
    private int goodsNum;
    private String goodsAddTime;
    private String orderNum;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "GoodsNum")
    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    @Basic
    @Column(name = "GoodsAddTime")
    public String getGoodsAddTime() {
        return goodsAddTime;
    }

    public void setGoodsAddTime(String goodsAddTime) {
        this.goodsAddTime = goodsAddTime;
    }

    @Basic
    @Column(name = "OrderNum")
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

        TbCartlist that = (TbCartlist) o;

        if (id != that.id) return false;
        if (goodsNum != that.goodsNum) return false;
        if (!Objects.equals(goodsAddTime, that.goodsAddTime)) return false;
        return Objects.equals(orderNum, that.orderNum);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + goodsNum;
        result = 31 * result + (goodsAddTime != null ? goodsAddTime.hashCode() : 0);
        result = 31 * result + (orderNum != null ? orderNum.hashCode() : 0);
        return result;
    }
}
