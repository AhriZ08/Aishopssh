package com.Aishopssh.Service;

import com.Aishopssh.Entites.Orders;
import com.Aishopssh.Imp.OrderImp.OrderImp;
import com.Aishopssh.Imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Maredb
 * @date 2019-12-24 - 14:36
 */
@Service("OrderService")
public class OrderService implements OrderServiceImp {
    @Autowired
    @Qualifier("OrderDao")
    OrderImp orderDao;

    //获取所有订单
    public List<Orders> getAllOrder() {
        return orderDao.getAllOrder();
    }

    //删除订单
    public int DeleteOrder(int id) {
        return orderDao.DeleteOrder(id);
    }

    //修改订单状态
    public int StatusOrder(Orders order) {
        return orderDao.StatusOrder(order);
    }

    //根据订单号得到订单
    public Orders getOrderByNum(String num) {
        return orderDao.getOrderByNum(num);
    }

    //根据下单人得到订单
    public Orders getOrderByXdr(String Xdr) {
        return orderDao.getOrderByXdr(Xdr);
    }

    //根据下单人和订单号得到订单
    public List<Orders> getOrderByNameAndNum(String Xdr, String num) {
        return orderDao.getOrderByNameAndNum(Xdr,num);
    }
}
