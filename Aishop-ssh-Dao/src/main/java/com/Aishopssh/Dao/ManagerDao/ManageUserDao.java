package com.Aishopssh.Dao.ManagerDao;

import com.Aishopssh.Entites.User;
import com.Aishopssh.Imp.ManagerImp.ManageUserDaoImp;
import org.hibernate.SessionFactory;
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
        return (List<User>)this.getHibernateTemplate().find("from com.Aishopssh.Entites.User");
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> GetUser(int id) {
        return (List<User>)this.getHibernateTemplate().find("from com.Aishopssh.Entites.User where User.id = ?", id);
    }

    @Override
    public int DeleteUser(int id) {
        User user = new User();
        user.setId(id);
        this.getHibernateTemplate().delete(user);
        return 0;
    }

    @Override
    public int FreezeUser(User user) {
        this.getHibernateTemplate().save(user);
        return 0;
    }
}
