package com.Aishop.TestPackage;

import com.Aishopssh.Dao.GoodsDao.WelcomePageDao;
import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Imp.WelcomePageImp.WelcomePageImp;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext_Dao.xml" })
public class Test {

    @Autowired
    @Qualifier("WelcomePageDao")
    WelcomePageImp welcomePageDao;

    @org.junit.Test
    public void Test01(){
        List<Goods> list = welcomePageDao.GetAllSpSimpleInfo(1,1);
        for(Goods g:list) {
                System.out.println(g.getName());
        }
    }
}
