package com.Aishopssh.Imp.ManagerServiceImp;

import com.Aishopssh.Entites.Cartlist;
import com.Aishopssh.Entites.Orders;

import java.util.ArrayList;
import java.util.List;

public interface ManagerServiceImp {
    /**
     * 获取订单信息
     * 订单信息接口
     */
    public List<Orders> SGetAllOrder(int uid);
    public Orders SGetOnedetailOrders(String odNum);
    public ArrayList<Cartlist> SGetOrderCarlist(String odNum);
    public Integer SAddOrder(Orders list);
}
