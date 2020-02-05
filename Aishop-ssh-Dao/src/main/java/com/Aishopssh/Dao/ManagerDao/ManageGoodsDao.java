package com.Aishopssh.Dao.ManagerDao;

import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Entites.Type1;
import com.Aishopssh.Entites.Type2;
import com.Aishopssh.Entites.Type3;
import com.Aishopssh.Imp.ManagerImp.ManageGoodsDaoImp;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("ManageGoodsDao")
public class ManageGoodsDao extends HibernateDaoSupport implements ManageGoodsDaoImp {

    public ManageGoodsDao() {};

    @Autowired
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Goods> GetAllGoods() {
        Query query = this.getSessionFactory().getCurrentSession().createQuery("from com.Aishopssh.Entites.Goods");
        return query.list();
    }

    @Override
    @Transactional
    public int InsertGoods(Goods good) {
        this.getHibernateTemplate().save(good);
        return 0;
    }

    @Override
    @Transactional
    public int DeleteGoods(int id) {
        Goods good = new Goods();
        good.setId(id);
        this.getHibernateTemplate().delete(good);
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Goods> GetGood(int id) {
        Query query = this.getSessionFactory().getCurrentSession().createQuery("from com.Aishopssh.Entites.Goods where id = " + id);
        return query.list();
    }

    @Override
    @Transactional
    public int UpdateGood(Goods good) {
        this.getHibernateTemplate().update(good);
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Type1> GetAllType1() {
        Query query = this.getSessionFactory().getCurrentSession().createQuery("from com.Aishopssh.Entites.Type1");
        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Type2> GetAllType2() {
        Query query = this.getSessionFactory().getCurrentSession().createQuery("from com.Aishopssh.Entites.Type2");
        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Type3> GetAllType3() {
        Query query = this.getSessionFactory().getCurrentSession().createQuery("from com.Aishopssh.Entites.Type3");
        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Type1> GetType1(int id) {
        Query query = this.getSessionFactory().getCurrentSession().createQuery("from com.Aishopssh.Entites.Type1 where id =" + id);
        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Type2> GetType2(int id) {
        Query query = this.getSessionFactory().getCurrentSession().createQuery("from com.Aishopssh.Entites.Type2 where id =" + id);
        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Type3> GetType3(int id) {
        Query query = this.getSessionFactory().getCurrentSession().createQuery("from com.Aishopssh.Entites.Type3 where id =" + id);
        return query.list();
    }
}
