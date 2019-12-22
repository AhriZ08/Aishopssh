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
    private int typeIdLevel1;
    private int typeIdLevel2;
    private int typeIdLevel3;
    private String memberPrice;
    private String marketPirce;
    private String brand;
    private int isSpecialPrice;
    private Set<Cartlist> tbCartlistsById = new HashSet<>();
    private Set<Comments> tbCommentsById = new HashSet<>();

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

    public int getTypeIdLevel1() {
        return typeIdLevel1;
    }

    public void setTypeIdLevel1(int typeIdLevel1) {
        this.typeIdLevel1 = typeIdLevel1;
    }

    public Integer getTypeIdLevel2() {
        return typeIdLevel2;
    }

    public void setTypeIdLevel2(Integer typeIdLevel2) {
        this.typeIdLevel2 = typeIdLevel2;
    }

    public Integer getTypeIdLevel3() {
        return typeIdLevel3;
    }

    public void setTypeIdLevel3(Integer typeIdLevel3) {
        this.typeIdLevel3 = typeIdLevel3;
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

    public Set<Cartlist> getTbCartlistsById() {
        return tbCartlistsById;
    }

    public void setTbCartlistsById(Set<Cartlist> tbCartlistsById) {
        this.tbCartlistsById = tbCartlistsById;
    }

    public Set<Comments> getTbCommentsById() {
        return tbCommentsById;
    }

    public void setTbCommentsById(Set<Comments> tbCommentsById) {
        this.tbCommentsById = tbCommentsById;
    }
}
