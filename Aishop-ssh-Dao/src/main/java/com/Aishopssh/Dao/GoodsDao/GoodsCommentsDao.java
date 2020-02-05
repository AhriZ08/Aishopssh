package com.Aishopssh.Dao.GoodsDao;

import com.Aishopssh.Entites.Comments;
import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Entites.User;
import com.Aishopssh.Imp.GoodsImp.GoodsCommentsImp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.net.CookieManager;
import java.util.ArrayList;
import java.util.List;

@Repository("GoodsCommentsDao")
public class GoodsCommentsDao implements GoodsCommentsImp {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Comments> GetAllCommentBySpId(int gid, int curr) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from com.Aishopssh.Entites.Comments where tbGoodsByGoodsId.id =" + gid;
        Query query = session.createQuery(hql);
        List<Comments> commentsList = query.list();
        List<Comments> currPageList = new ArrayList<>();
        int f = 0;
        for(int i = 0; i < commentsList.size(); i++) {
            if(i%3 == 0) {
                f++;
            }
            if(f == curr) {
                currPageList.add(commentsList.get(i));
            }
        }
        return currPageList;
    }

    @Override
    @Transactional
    public int addComments(int uid, int gid, String Title, String Content, String currDate) {
        int fg = 0;
        try {
            Comments comments = new Comments();
            User user = new User();
            user.setId(uid);
            Goods goods = new Goods();
            goods.setId(gid);
            comments.setTbUserByUserId(user);
            comments.setTbGoodsByGoodsId(goods);
            comments.setTitle(Title);
            comments.setContent(Content);
            comments.setTime(currDate);
            sessionFactory.getCurrentSession().save(comments);
        } catch (Exception ex){
            ex.printStackTrace();
            fg = -1;
        }
        return fg;
    }
}
