package com.Aishopssh.Dao.GoodsDao;

import com.Aishopssh.Entites.Comments;
import com.Aishopssh.Imp.GoodsImp.GoodsCommentsImp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GoodsCommentsDao implements GoodsCommentsImp {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Comments> GetAllCommentBySpId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Comments where Comments.id = :id";
        Query query = session.createQuery(hql).setParameter("id",id);
        List<Comments> commentsList = query.list();
        transaction.commit();
        return commentsList;
    }
}
