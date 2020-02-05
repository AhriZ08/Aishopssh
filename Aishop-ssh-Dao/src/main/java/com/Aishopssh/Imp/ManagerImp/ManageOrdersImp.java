package com.Aishopssh.Imp.ManagerImp;


import com.Aishopssh.Entites.Cartlist;
import com.Aishopssh.Entites.Orders;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单信息层接口
 */

public interface ManageOrdersImp {
    public List<Orders> GetAllOrder(int uid);
    public Orders GetOnedetailOrders(String odNum);
    public ArrayList<Cartlist> GetOrderCarlist(String odNum);
}
