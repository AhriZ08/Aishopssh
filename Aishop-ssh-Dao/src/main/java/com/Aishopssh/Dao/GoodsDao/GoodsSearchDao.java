package com.Aishopssh.Dao.GoodsDao;

import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Entites.HighShInfo;
import com.Aishopssh.Imp.GoodsImp.GoodsSearchImp;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("GoodsSearchDao")
public class GoodsSearchDao implements GoodsSearchImp {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<Goods> getSearchResult(String data) {
        String hql = "from com.Aishopssh.Entites.Goods where name like '%"+data+"%' or type1.typeName like '%"+data+"%'" +
                "or type2.typeName like '%"+data+"%' or type3.typeName like '%"+data+"%'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Goods> getHighSearchRs(HighShInfo highShInfo) {
        String hql = "";
        if(highShInfo.getShopDim().equals("0")){
            hql ="from com.Aishopssh.Entites.Goods where name like '%"+highShInfo.getShopName()+"%' and (memberPrice >= "+highShInfo.getPriceMin()+" and memberPrice <= "+highShInfo.getPriceMax()+") and type2.id="+highShInfo.getShopType();

        }else{
            hql ="from com.Aishopssh.Entites.Goods where name = "+highShInfo.getShopName()+ " and (memberPrice >= "+highShInfo.getPriceMin()+" and memberPrice <= "+highShInfo.getPriceMax()+ ") and type2.id="+highShInfo.getShopType();
        }
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public Goods getOneGoods(int gid) {
        return sessionFactory.getCurrentSession().get(Goods.class, gid);
    }
}
