package com.Aishopssh.Entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_goods", schema = "e_shopwebsite")
public class Goods {
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
    private Integer typeIdLevel2;
    private Integer typeIdLevel3;
    private String memberPrice;
    private String marketPirce;
    private String brand;
    private Integer isSpecialPrice;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Introduction")
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Basic
    @Column(name = "Addtime")
    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    @Basic
    @Column(name = "Level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Basic
    @Column(name = "Model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "Picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name = "Num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Basic
    @Column(name = "PurchaseTime")
    public int getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(int purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    @Basic
    @Column(name = "Is_Recommend")
    public int getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(int isRecommend) {
        this.isRecommend = isRecommend;
    }

    @Basic
    @Column(name = "TypeID_Level_1")
    public int getTypeIdLevel1() {
        return typeIdLevel1;
    }

    public void setTypeIdLevel1(int typeIdLevel1) {
        this.typeIdLevel1 = typeIdLevel1;
    }

    @Basic
    @Column(name = "TypeID_Level_2")
    public Integer getTypeIdLevel2() {
        return typeIdLevel2;
    }

    public void setTypeIdLevel2(Integer typeIdLevel2) {
        this.typeIdLevel2 = typeIdLevel2;
    }

    @Basic
    @Column(name = "TypeID_Level_3")
    public Integer getTypeIdLevel3() {
        return typeIdLevel3;
    }

    public void setTypeIdLevel3(Integer typeIdLevel3) {
        this.typeIdLevel3 = typeIdLevel3;
    }

    @Basic
    @Column(name = "MemberPrice")
    public String getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(String memberPrice) {
        this.memberPrice = memberPrice;
    }

    @Basic
    @Column(name = "MarketPirce")
    public String getMarketPirce() {
        return marketPirce;
    }

    public void setMarketPirce(String marketPirce) {
        this.marketPirce = marketPirce;
    }

    @Basic
    @Column(name = "Brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "Is_SpecialPrice")
    public Integer getIsSpecialPrice() {
        return isSpecialPrice;
    }

    public void setIsSpecialPrice(Integer isSpecialPrice) {
        this.isSpecialPrice = isSpecialPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (id != goods.id) return false;
        if (num != goods.num) return false;
        if (purchaseTime != goods.purchaseTime) return false;
        if (isRecommend != goods.isRecommend) return false;
        if (typeIdLevel1 != goods.typeIdLevel1) return false;
        if (!Objects.equals(name, goods.name)) return false;
        if (!Objects.equals(introduction, goods.introduction))
            return false;
        if (!Objects.equals(addtime, goods.addtime)) return false;
        if (!Objects.equals(level, goods.level)) return false;
        if (!Objects.equals(model, goods.model)) return false;
        if (!Objects.equals(picture, goods.picture)) return false;
        if (!Objects.equals(typeIdLevel2, goods.typeIdLevel2))
            return false;
        if (!Objects.equals(typeIdLevel3, goods.typeIdLevel3))
            return false;
        if (!Objects.equals(memberPrice, goods.memberPrice)) return false;
        if (!Objects.equals(marketPirce, goods.marketPirce)) return false;
        if (!Objects.equals(brand, goods.brand)) return false;
        return Objects.equals(isSpecialPrice, goods.isSpecialPrice);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (addtime != null ? addtime.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + num;
        result = 31 * result + purchaseTime;
        result = 31 * result + isRecommend;
        result = 31 * result + typeIdLevel1;
        result = 31 * result + (typeIdLevel2 != null ? typeIdLevel2.hashCode() : 0);
        result = 31 * result + (typeIdLevel3 != null ? typeIdLevel3.hashCode() : 0);
        result = 31 * result + (memberPrice != null ? memberPrice.hashCode() : 0);
        result = 31 * result + (marketPirce != null ? marketPirce.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (isSpecialPrice != null ? isSpecialPrice.hashCode() : 0);
        return result;
    }
}
