package com.Aishopssh.Dao.LeavewordDao;

import com.Aishopssh.Entites.AdminReply;
import com.Aishopssh.Entites.Leaveword;
import com.Aishopssh.Imp.LeavewordImp.LeaveWordImp;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Maredb
 * @date 2019-12-23 - 11:07
 */
@Repository("LeaveWordDao")
public class LeaveWordDao extends HibernateDaoSupport implements LeaveWordImp {

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }


    @Override
    @Transactional(readOnly = true)
    //根据用户ID获得留言信息
    public List<Leaveword> GetAllLeaveWordByUid(int id) {
        return (List<Leaveword>)getHibernateTemplate()
                        .find("from com.Aishopssh.Entites.Leaveword where tbUserByUserId.id = ?",id);
    }

    @Override
    @Transactional(readOnly = true)
    //根据留言ID获取留言信息
    public Leaveword getLeaveWordByLid(int id) {
        return getHibernateTemplate().get(Leaveword.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    //根据留言ID获取回复信息
    public AdminReply getReplyById(int id) {
        return getHibernateTemplate().get(AdminReply.class,id);
    }
}
