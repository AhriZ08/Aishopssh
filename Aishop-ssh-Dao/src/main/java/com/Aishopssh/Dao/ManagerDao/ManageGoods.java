package com.Aishopssh.Dao.ManagerDao;


import com.Aishopssh.Entites.Orders;
import com.Aishopssh.Imp.ManagerImp.ManageGoodsImp;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 用于订单提交时向数据库提交订单信息
 * 购物车提交订单信息时使用
 */
@Repository("ManagerDao")
public class ManageGoods extends HibernateDaoSupport implements ManageGoodsImp {

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }


    @Override
    public Integer AddOrder(Orders list) {
        int fg = 0;
        try {
            getHibernateTemplate().save(list);
        }catch(Exception ex){
            fg = 1;
            System.out.println("订单插入失败");

        }
        return fg;
    }
}
