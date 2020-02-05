package com.Aishopssh.Dao.GoodsDao;

import com.Aishopssh.Entites.Cartlist;
import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Imp.GoodsImp.CartlistManageImp;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

/**
 * 该层用于订单的察看以及订单信息的详细解释
 */

@Repository("CartListManageDao")
public class CartListManageDao extends HibernateDaoSupport implements CartlistManageImp {

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }


    @Override
    @Transactional(readOnly = true)
    public ArrayList<Cartlist> getAllCart(int uid) {
            System.out.println("getAllCart().......");
            Query query = getSessionFactory().getCurrentSession().createQuery("from com.Aishopssh.Entites.Cartlist where tbUserByUserId.id ="+uid);
            return (ArrayList<Cartlist>) query.list();
    }

    @Override
    @Transactional
    public int DelOneGouwuche(int id){
        int fg = 0;
        Cartlist cartlist = new Cartlist();
        cartlist.setId(id);
        try {
            getHibernateTemplate().delete(cartlist);
        } catch (Exception ex){
            fg = -1;
        }
        return fg;
    }

    @Override
    @Transactional
    public int ModspNum(int num, int spid, int uid) {
        int fg = 0;
        String hql = "update from com.Aishopssh.Entites.Cartlist set goodsNum=:goodsnum where tbGoodsByGoodsId.id=:spid and tbUserByUserId.id=:uid";
        try{
            Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
            query.setParameter("goodsnum", num);
            query.setParameter("spid", spid);
            query.setParameter("uid", uid);

            query.executeUpdate();
        }catch(Exception ex){
            fg = 1;
        }
        return fg;
    }

    @Override
    @Transactional
    public int DelAllCart(int uid) {
        int fg = 0;
        Cartlist cartlist = new Cartlist();
        cartlist.setId(uid);
        try{
            getHibernateTemplate().delete(uid);
        }catch(Exception ex){
            fg = -1;
            System.out.println("清空购物车失败");
        }
        return fg;
    }

    @Override
    @Transactional
    public int UpdatecartOrderNum(int pgid, String dingdanhao) {
        int fg = 0;
        String hql = "update from com.Aishopssh.Entites.Cartlist set orderNum = ? where tbUserByUserId.id = ? And orderNum is NULL";
        try{
            Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
            query.setParameter("0",dingdanhao);
            query.setParameter("1",pgid);


        }catch(Exception ex){
            System.out.println("更新订单数量失败");
            fg = -1;
        }
        return fg;
    }
}
