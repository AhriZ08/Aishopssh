package com.Aishopssh.Dao.ManagerDao;

import com.Aishopssh.Entites.Admin;
import com.Aishopssh.Imp.ManagerImp.ManageSelfDaoImp;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

    @Repository("ManageSelfDao")
public class ManageSelfDao extends HibernateDaoSupport implements ManageSelfDaoImp {

    public ManageSelfDao() {}

    @Autowired
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Admin> GetManager(int id) {
        Query query = this.getSessionFactory().getCurrentSession().createQuery("from com.Aishopssh.Entites.Admin where id =" + id);
        return query.list();
    }

    @Override
    @Transactional
    public int UpdateManager(Admin mgr) {
        this.getHibernateTemplate().update(mgr);
        return 0;
    }
}
