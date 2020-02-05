package com.Aishopssh.Entites;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Goods implements Serializable {
    private int id;
    private String name;
    private String introduction;
    private String addtime;
    private String level;
    private String model;
    private String picture;
    private int num;
    private int purchaseTime;
    private int isRecommend;
    private Type1 type1;
    private Type2 type2;
    private Type3 type3;
    public Type1 getType1() {
        return type1;
    }
    public void setType1(Type1 type1) {
        this.type1 = type1;
    }
    public Type2 getType2() {
        return type2;
    }
    public void setType2(Type2 type2) {
        this.type2 = type2;
    }
    public Type3 getType3() {
        return type3;
    }
    public void setType3(Type3 type3) {
        this.type3 = type3;
    }

    private String memberPrice;
    private String marketPirce;
    private String brand;
    private int isSpecialPrice;

    public Goods(){ }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(int purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public int getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(int isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(String memberPrice) {
        this.memberPrice = memberPrice;
    }

    public String getMarketPirce() {
        return marketPirce;
    }

    public void setMarketPirce(String marketPirce) {
        this.marketPirce = marketPirce;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getIsSpecialPrice() {
        return isSpecialPrice;
    }

    public void setIsSpecialPrice(int isSpecialPrice) {
        this.isSpecialPrice = isSpecialPrice;
    }

}
