package com.Aishopssh.Entites;

import java.util.Objects;

public class Orders {
    private int id;
    private String num;
    private String consigneeName;
    private String consigneeSex;
    private String consigneeAddr;
    private String postcode;
    private String tel;
    private String consigneeRecTime;
    private String paymentType;
    private String purchaserLeaveWord;
    private String purchaseTime;
    private String purchaserName;
    private String status;
    private String amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeSex() {
        return consigneeSex;
    }

    public void setConsigneeSex(String consigneeSex) {
        this.consigneeSex = consigneeSex;
    }

    public String getConsigneeAddr() {
        return consigneeAddr;
    }

    public void setConsigneeAddr(String consigneeAddr) {
        this.consigneeAddr = consigneeAddr;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getConsigneeRecTime() {
        return consigneeRecTime;
    }

    public void setConsigneeRecTime(String consigneeRecTime) {
        this.consigneeRecTime = consigneeRecTime;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPurchaserLeaveWord() {
        return purchaserLeaveWord;
    }

    public void setPurchaserLeaveWord(String purchaserLeaveWord) {
        this.purchaserLeaveWord = purchaserLeaveWord;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (id != orders.id) return false;
        if (!Objects.equals(num, orders.num)) return false;
        if (!Objects.equals(consigneeName, orders.consigneeName))
            return false;
        if (!Objects.equals(consigneeSex, orders.consigneeSex))
            return false;
        if (!Objects.equals(consigneeAddr, orders.consigneeAddr))
            return false;
        if (!Objects.equals(postcode, orders.postcode)) return false;
        if (!Objects.equals(tel, orders.tel)) return false;
        if (!Objects.equals(consigneeRecTime, orders.consigneeRecTime))
            return false;
        if (!Objects.equals(paymentType, orders.paymentType)) return false;
        if (!Objects.equals(purchaserLeaveWord, orders.purchaserLeaveWord))
            return false;
        if (!Objects.equals(purchaseTime, orders.purchaseTime))
            return false;
        if (!Objects.equals(purchaserName, orders.purchaserName))
            return false;
        if (!Objects.equals(status, orders.status)) return false;
        return Objects.equals(amount, orders.amount);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (consigneeName != null ? consigneeName.hashCode() : 0);
        result = 31 * result + (consigneeSex != null ? consigneeSex.hashCode() : 0);
        result = 31 * result + (consigneeAddr != null ? consigneeAddr.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (consigneeRecTime != null ? consigneeRecTime.hashCode() : 0);
        result = 31 * result + (paymentType != null ? paymentType.hashCode() : 0);
        result = 31 * result + (purchaserLeaveWord != null ? purchaserLeaveWord.hashCode() : 0);
        result = 31 * result + (purchaseTime != null ? purchaseTime.hashCode() : 0);
        result = 31 * result + (purchaserName != null ? purchaserName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
