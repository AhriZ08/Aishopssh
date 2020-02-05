package com.Aishopssh.Imp;

import com.Aishopssh.Entites.Orders;

import java.util.List;

/**
 * @author Maredb
 * @date 2019-12-24 - 14:35
 */
public interface OrderServiceImp {
    /**
     * 根据订单号查询订单
     * @return 订单列表
     */
    public List<Orders> getAllOrder();

    /**
     * 删除订单
     * @param id 订单id
     */
    public int DeleteOrder(int id);

    /**
     * 修改订单状态
     * @param order 订单
     */
    public int StatusOrder(Orders order);

    /**
     * 根据订单号查询订单
     * @param num 订单号
     * @return 订单列表
     */
    public Orders getOrderByNum(String num);

    /**
     * 根据下单人查询订单
     * @param Xdr 下单人
     * @return 订单列表
     */
    public Orders getOrderByXdr(String Xdr);

    /**
     * 根据下单人和订单号查询订单
     * @param Xdr 下单人
     * @param num 订单号
     * @return 订单列表
     */
    public List<Orders> getOrderByNameAndNum(String Xdr, String num);
}
