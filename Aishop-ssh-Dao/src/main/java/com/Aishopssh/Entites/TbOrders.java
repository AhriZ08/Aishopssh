package com.Aishopssh.Entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_orders", schema = "e_shopwebsite")
public class TbOrders {
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

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Num")
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Basic
    @Column(name = "Consignee_Name")
    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    @Basic
    @Column(name = "Consignee_Sex")
    public String getConsigneeSex() {
        return consigneeSex;
    }

    public void setConsigneeSex(String consigneeSex) {
        this.consigneeSex = consigneeSex;
    }

    @Basic
    @Column(name = "Consignee_Addr")
    public String getConsigneeAddr() {
        return consigneeAddr;
    }

    public void setConsigneeAddr(String consigneeAddr) {
        this.consigneeAddr = consigneeAddr;
    }

    @Basic
    @Column(name = "Postcode")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Basic
    @Column(name = "Tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "Consignee_RecTime")
    public String getConsigneeRecTime() {
        return consigneeRecTime;
    }

    public void setConsigneeRecTime(String consigneeRecTime) {
        this.consigneeRecTime = consigneeRecTime;
    }

    @Basic
    @Column(name = "Payment_Type")
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Basic
    @Column(name = "Purchaser_LeaveWord")
    public String getPurchaserLeaveWord() {
        return purchaserLeaveWord;
    }

    public void setPurchaserLeaveWord(String purchaserLeaveWord) {
        this.purchaserLeaveWord = purchaserLeaveWord;
    }

    @Basic
    @Column(name = "PurchaseTime")
    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    @Basic
    @Column(name = "PurchaserName")
    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    @Basic
    @Column(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "Amount")
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

        TbOrders tbOrders = (TbOrders) o;

        if (id != tbOrders.id) return false;
        if (!Objects.equals(num, tbOrders.num)) return false;
        if (!Objects.equals(consigneeName, tbOrders.consigneeName))
            return false;
        if (!Objects.equals(consigneeSex, tbOrders.consigneeSex))
            return false;
        if (!Objects.equals(consigneeAddr, tbOrders.consigneeAddr))
            return false;
        if (!Objects.equals(postcode, tbOrders.postcode)) return false;
        if (!Objects.equals(tel, tbOrders.tel)) return false;
        if (!Objects.equals(consigneeRecTime, tbOrders.consigneeRecTime))
            return false;
        if (!Objects.equals(paymentType, tbOrders.paymentType))
            return false;
        if (!Objects.equals(purchaserLeaveWord, tbOrders.purchaserLeaveWord))
            return false;
        if (!Objects.equals(purchaseTime, tbOrders.purchaseTime))
            return false;
        if (!Objects.equals(purchaserName, tbOrders.purchaserName))
            return false;
        if (!Objects.equals(status, tbOrders.status)) return false;
        return Objects.equals(amount, tbOrders.amount);
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
