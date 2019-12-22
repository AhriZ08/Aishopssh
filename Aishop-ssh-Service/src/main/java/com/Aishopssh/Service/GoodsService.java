package com.Aishopssh.Service;

import com.Aishopssh.Dao.GoodsDao.WelcomePageDao;
import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Imp.GoodsServiceImp;
import com.Aishopssh.Imp.WelcomePageImp.WelcomePageImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("GoodsService")
public class GoodsService implements GoodsServiceImp {

    @Autowired
    @Qualifier("WelcomePageDao")
    WelcomePageImp welcomePageDao;

    public List<Goods> getWelcomeGoods(int idx, int currpage) {
        return welcomePageDao.GetAllSpSimpleInfo(idx, currpage);
    }

}
