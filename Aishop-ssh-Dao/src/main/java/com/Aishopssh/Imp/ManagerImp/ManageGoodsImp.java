package com.Aishopssh.Imp.ManagerImp;

import com.Aishopssh.Entites.Orders;
import org.hibernate.criterion.Order;

public interface ManageGoodsImp {
    /**
     * 订单信息管理
     * 根据当前用户的id进行信息管理
     */
    public Integer AddOrder(Orders list);
}

