package com.Aishop.TestPackage;

import com.Aishopssh.Dao.GoodsDao.WelcomePageDao;
import com.Aishopssh.Entites.*;
import com.Aishopssh.Imp.GoodsImp.GoodsCommentsImp;
import com.Aishopssh.Imp.GoodsImp.GoodsSearchImp;
import com.Aishopssh.Imp.LeavewordImp.LeaveWordImp;
import com.Aishopssh.Imp.ManagerImp.ManageGoodsDaoImp;
import com.Aishopssh.Imp.UserImp.UserLoginImp;
import com.Aishopssh.Imp.WelcomePageImp.WelcomePageImp;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext_Dao.xml" })
public class Test {

    @Autowired
    @Qualifier("GoodsSearchDao")
    GoodsSearchImp goodsSearchdao;

    @Autowired
    @Qualifier("WelcomePageDao")
    WelcomePageImp welcomePagedao;

    @Autowired
    @Qualifier("GoodsCommentsDao")
    GoodsCommentsImp goodsCommentsdao;

    @Autowired
    @Qualifier("LeaveWordDao")
    LeaveWordImp leaveWord;

    @Autowired
    @Qualifier("ManageGoodsDao")
    private ManageGoodsDaoImp ManageGoodsDao;

    @org.junit.Test
    public void Test01(){
        System.out.println(goodsCommentsdao.addComments(1,1,"hahahah","hahahahh","2019-12-25"));
    }

    @org.junit.Test
    public void Test02(){
/*        List<Type2> list = ManageGoodsDao.GetAllType2();
        for (Type2 type2:list){
            System.out.println(type2.getTbType1ByTypeIdLevel1().getTypeName());
        }*/
        System.out.println(welcomePagedao.cartListIsExist(1,5));
    }
}
