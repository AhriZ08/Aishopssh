package com.Aishopssh.Dao.GoodsDao;

import com.Aishopssh.Entites.Cartlist;
import com.Aishopssh.Entites.Orders;
import com.Aishopssh.Imp.ManagerImp.ManageOrdersImp;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository("OrderlistDao")
public class OrderlistDao extends HibernateDaoSupport implements ManageOrdersImp {


    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Orders> GetAllOrder(int uid) {
        System.out.println("you have succeed reporting the information");
        Query query = getSessionFactory().getCurrentSession().createQuery("from com.Aishopssh.Entites.Orders where id = "+uid);
        List<Orders> order = query.list();
        return order;
    }

    @Override
    @Transactional(readOnly = true)
    public Orders GetOnedetailOrders(String odNum) {
        System.out.println("you have succeed reporting the information");
        Query query = getSessionFactory().getCurrentSession().createQuery("from com.Aishopssh.Entites.Orders where num ="+odNum);
        return (Orders) query.uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Cartlist> GetOrderCarlist(String odNum) {
        System.out.println("you have succeed reporting the information");
        Query query = getSessionFactory().getCurrentSession().createQuery("from com.Aishopssh.Entites.Cartlist where orderNum="+odNum);
        ArrayList<Cartlist> cartlists = (ArrayList<Cartlist>) query.list();
        if(cartlists.isEmpty()){
            System.out.println("yes");
        }
        System.out.println();
        for(Cartlist cartlist : cartlists){
            System.out.println(cartlist.getTbGoodsByGoodsId().getName());
            System.out.println(cartlist.getTbUserByUserId().getName());
            System.out.println("next.....");
        }
        return (ArrayList<Cartlist>) query.list();
    }
}

