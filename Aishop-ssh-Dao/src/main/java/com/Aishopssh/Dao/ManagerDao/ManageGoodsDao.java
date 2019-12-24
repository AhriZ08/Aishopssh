package com.Aishopssh.Dao.ManagerDao;

import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Entites.Type1;
import com.Aishopssh.Entites.Type2;
import com.Aishopssh.Entites.Type3;
import com.Aishopssh.Imp.ManagerImp.ManageGoodsDaoImp;
import org.hibernate.SessionFactory;
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
        return (List<Goods>) this.getHibernateTemplate().find("from com.Aishopssh.Entites.Goods");
    }

    @Override
    public int InsertGoods(Goods good) {
        this.getHibernateTemplate().save("good");
        return 0;
    }

    @Override
    public int DeleteGoods(int id) {
        Goods good = new Goods();
        good.setId(id);
        this.getHibernateTemplate().delete(good);
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Goods> GetGood(int id) {
        return (List<Goods>)this.getHibernateTemplate().find("from com.Aishopssh.Entites.Goods where Goods.id = ?", id);
    }

    @Override
    public int UpdateGood(Goods good) {
        this.getHibernateTemplate().update(good);
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Type1> GetAllType1() {
        return (List<Type1>)this.getHibernateTemplate().find("from com.Aishopssh.Entites.Type1");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Type2> GetAllType2() {
        return (List<Type2>)this.getHibernateTemplate().find("from com.Aishopssh.Entites.Type2");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Type3> GetAllType3() {
        return (List<Type3>)this.getHibernateTemplate().find("from com.Aishopssh.Entites.Type3");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Type1> GetType1(int id) {
        return (List<Type1>)this.getHibernateTemplate().find("from com.Aishopssh.Entites.Type1 where Type1.id = ?", id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Type2> GetType2(int id) {
        return (List<Type2>)this.getHibernateTemplate().find("from com.Aishopssh.Entites.Type2 where Type2.id = ?", id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Type3> GetType3(int id) {
        return (List<Type3>)this.getHibernateTemplate().find("from com.Aishopssh.Entites.Type3 where Type3.id = ?", id);
    }
}
