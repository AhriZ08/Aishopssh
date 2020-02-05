package com.Aishopssh.Dao.ManagerDao;

import com.Aishopssh.Entites.User;
import com.Aishopssh.Imp.ManagerImp.ManageUserDaoImp;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("ManageUserDao")
public class ManageUserDao extends HibernateDaoSupport implements ManageUserDaoImp {

    public  ManageUserDao() {}

    @Autowired
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> GetAllUser() {
        Query query = this.getSessionFactory().getCurrentSession().createQuery("from com.Aishopssh.Entites.User");
        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> GetUser(int id) {
        System.out.println(id);
        Query query = this.getSessionFactory().getCurrentSession().createQuery("from com.Aishopssh.Entites.User where id =" + id);
        return query.list();
    }

    @Override
    @Transactional
    public int DeleteUser(int id) {
        User user = new User();
        user.setId(id);
        this.getHibernateTemplate().setCheckWriteOperations(false);
        this.getHibernateTemplate().delete(user);
        return 0;
    }

    @Override
    @Transactional
    public int FreezeUser(User user) {
        this.getHibernateTemplate().update(user);
        return 0;
    }
}
