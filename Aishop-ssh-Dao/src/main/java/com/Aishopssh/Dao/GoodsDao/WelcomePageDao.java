package com.Aishopssh.Dao.GoodsDao;

import com.Aishopssh.Entites.Advertisements;
import com.Aishopssh.Entites.Cartlist;
import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Entites.User;
import com.Aishopssh.Imp.WelcomePageImp.WelcomePageImp;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository("WelcomePageDao")
public class WelcomePageDao extends HibernateDaoSupport implements WelcomePageImp {

    public WelcomePageDao(){}

    @Autowired
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Goods> GetAllSpSimpleInfo(int idx, int currpage) {
        List<Goods> CurrpageList = new ArrayList<>();
        int f = 0;
        String hql = "";
        if(idx == 1) {
            hql = "from com.Aishopssh.Entites.Goods where purchaseTime >= 100";
        }else if(idx == 2) {
            hql = "from com.Aishopssh.Entites.Goods where isRecommend = 1";
        }
        System.out.println(hql);

        List<Goods> list = (List<Goods>) this.getHibernateTemplate().find(hql);
        for(int i = 0; i < list.size(); i++) {
            if(i%6 == 0) {
                f++;
            }
            if(f == currpage) {
                CurrpageList.add(list.get(i));
            }
        }
        return CurrpageList;
    }

    @Override
    @Transactional(readOnly = true)
    public String getUsername(int uid) {
        User user = getHibernateTemplate().get(User.class, uid);
        return user.getName();
    }

    @Override
    @Transactional(readOnly = true)
    public int cartListIsExist(int uid, int gid) {
        int fg = 1;
        String hql = "from com.Aishopssh.Entites.Cartlist where tbUserByUserId.id = "+uid+" and tbGoodsByGoodsId.id = "+gid;
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        System.out.println(hql);
        List<Cartlist> cartlist = query.list();
        if(!cartlist.isEmpty()){
            fg = 0;
        }
        return fg;
    }

    @Override
    @Transactional
    public int addToCartLst(int uid, int gid, String currDate) {
        int fg = 1;
        Cartlist cartlist = new Cartlist();
        Goods goods = getSessionFactory().getCurrentSession().get(Goods.class, gid);
        cartlist.setTbGoodsByGoodsId(goods);
        User user = getSessionFactory().getCurrentSession().get(User.class, uid);
        cartlist.setTbUserByUserId(user);
        cartlist.setGoodsAddTime(currDate);
        cartlist.setGoodsNum(1);
        try {
            getSessionFactory().getCurrentSession().save(cartlist);
        } catch (Exception ex){
            fg = 0;
        }
        return fg;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Advertisements> getAdv() {
        Query query = getSessionFactory().getCurrentSession().createQuery("from com.Aishopssh.Entites.Advertisements");
        return query.list();
    }
}
