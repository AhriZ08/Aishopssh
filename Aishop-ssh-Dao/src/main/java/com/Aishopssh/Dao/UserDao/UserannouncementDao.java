package com.Aishopssh.Dao.UserDao;


import com.Aishopssh.Entites.Notice;
import com.Aishopssh.Imp.UserImp.UserannouncementImp;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository("UserannouncementDao")
public class UserannouncementDao extends HibernateDaoSupport implements UserannouncementImp {

    public UserannouncementDao(){};

    @Autowired
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    @Override
    @Transactional
    public ArrayList<Notice> getAll() {
        String hql = "";
        hql = "from com.Aishopssh.Entites.Notice";
        ArrayList<Notice> list = (ArrayList<Notice>) this.getHibernateTemplate().find(hql);
        return list;
    }
}
