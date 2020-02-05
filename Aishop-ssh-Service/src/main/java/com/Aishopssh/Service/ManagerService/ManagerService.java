package com.Aishopssh.Service.ManagerService;

import com.Aishopssh.Entites.Cartlist;
import com.Aishopssh.Entites.Orders;
import com.Aishopssh.Imp.ManagerImp.ManageGoodsImp;
import com.Aishopssh.Imp.ManagerImp.ManageOrdersImp;
import com.Aishopssh.Imp.ManagerServiceImp.ManagerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ManagerService")
public class ManagerService implements ManagerServiceImp {
    /**
     * 获取订单信息
     * 订单信息接口
     *
     * @param uid
     */
    @Autowired
    @Qualifier("OrderlistDao")
    ManageOrdersImp OrderlistDao;

    public List<Orders> SGetAllOrder(int uid) {
        return OrderlistDao.GetAllOrder(uid);
    }

    public Orders SGetOnedetailOrders(String odNum) {
        return OrderlistDao.GetOnedetailOrders(odNum);

    }

    public ArrayList<Cartlist> SGetOrderCarlist(String odNum) {
        return OrderlistDao.GetOrderCarlist(odNum);
    }

    @Autowired
    @Qualifier("ManagerDao")
    ManageGoodsImp ManageGoods;

    public Integer SAddOrder(Orders list) {
        return ManageGoods.AddOrder(list);
    }
}
