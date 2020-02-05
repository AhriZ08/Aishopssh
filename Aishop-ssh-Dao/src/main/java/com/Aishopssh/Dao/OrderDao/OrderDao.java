package com.Aishopssh.Dao.OrderDao;

import com.Aishopssh.Entites.Orders;
import com.Aishopssh.Imp.OrderImp.OrderImp;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Maredb
 * @date 2019-12-23 - 13:38
 */
@Repository("OrderDao")
public class OrderDao extends HibernateDaoSupport implements OrderImp {

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    @Override
    @Transactional(readOnly = true)
    //获取所有订单
    public List<Orders> getAllOrder() {
        return (List<Orders>)getHibernateTemplate().find("from com.Aishopssh.Entites.Orders");
    }

    @Override
    @Transactional
    //删除订单
    public int DeleteOrder(int id) {
        int flag = 0;
        Orders orders = new Orders();
        orders.setId(id);
        try{
            getHibernateTemplate().delete(orders);
            flag = 1;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("删除订单失败！");
        }
        return flag;
    }

    @Override
    @Transactional
    //修改订单状态
    public int StatusOrder(Orders order) {
        int flag = 0;
        try{
            getHibernateTemplate().saveOrUpdate(order);
            flag = 1;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("修改订单失败！");
        }
        return flag;
    }

    @Override
    @Transactional(readOnly = true)
    //根据订单号得到订单
    public Orders getOrderByNum(String num) {
        return getHibernateTemplate().get(Orders.class,num);
    }

    @Override
    @Transactional(readOnly = true)
    //根据下单人得到订单
    public Orders getOrderByXdr(String Xdr) {
        return getHibernateTemplate().get(Orders.class,Xdr);
    }

    @Override
    @Transactional(readOnly = true)
    //根据下单人和订单号得到订单
    public List<Orders> getOrderByNameAndNum(String Xdr,String num) {
        String hql = "from com.Aishopssh.Entites.Orders where purchaserName = "+Xdr +" and num="+num;
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        return query.list();
    }

}
