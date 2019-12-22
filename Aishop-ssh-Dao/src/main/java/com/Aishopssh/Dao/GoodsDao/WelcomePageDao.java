package com.Aishopssh.Dao.GoodsDao;

import com.Aishopssh.Entites.Comments;
import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Imp.WelcomePageImp.WelcomePageImp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
            hql = "from Goods where Goods.isRecommend = 1";
        }
        System.out.println(hql);
        List<Goods> list = (List<Goods>) getHibernateTemplate().find(hql);
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
}
