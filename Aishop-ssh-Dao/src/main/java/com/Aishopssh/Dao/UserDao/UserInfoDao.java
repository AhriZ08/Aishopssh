package com.Aishopssh.Dao.UserDao;


import com.Aishopssh.Entites.Admin;
import com.Aishopssh.Entites.User;
import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Imp.UserImp.UserLoginImp;
import com.Aishopssh.Imp.WelcomePageImp.WelcomePageImp;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

@Repository("UserInfoDao")
public class UserInfoDao extends HibernateDaoSupport implements UserLoginImp {

    public UserInfoDao(){};

    @Autowired
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    @Override
    @Transactional(readOnly = true)
    //根据用户姓名查找用户信息
    public User GetUserbyName(String userName) {
        User user = new User();
        String hql= "from com.Aishopssh.Entites.User u where u.name ="+userName;
            List<User> list = (List<User>) this.getHibernateTemplate().find(hql);
            user = list.get(0);
            //Query query = session.createQuery(hql);

        return user;
    }

    @Override
    @Transactional
    //添加用户信息
    public void insert(User user) {
        this.getHibernateTemplate().getSessionFactory().getCurrentSession().save(user);
    }

    @Override
    @Transactional
    //根据用户信息更新相应用户信息
    public int update(User user) {
        int count=1;
        this.getHibernateTemplate().saveOrUpdate(user);
        return count;
    }

    @Override
    @Transactional
    //返回用户人数
    public int getNo() {
        String hql = "";
         hql = "select count(*) from User as user";
        Number count = (Number)getHibernateTemplate().find(hql).listIterator().next();
        return count.intValue();
    }

    @Override
    @Transactional
    //返回管理员信息
    public Admin getadmin() {
        String hql = "";
        Admin admin = new Admin();
        admin.setId(1);
        admin.setPwd("admin");
        admin.setName("admin");
        return admin;
    }

    @Override
    @Transactional(readOnly = true)
    //根据用户姓名查找用户信息
    public User GetUserbyId(int id) {
        User user = new User();
        String hql = "";
        hql = "from com.Aishopssh.Entites.User where id ="+id;
        List<User> list = (List<User>)this.getHibernateTemplate().find(hql);
        user =  list.get(0);
        return user;
    }


}
