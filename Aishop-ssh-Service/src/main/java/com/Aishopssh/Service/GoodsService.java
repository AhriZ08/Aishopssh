package com.Aishopssh.Service;

import com.Aishopssh.Dao.GoodsDao.WelcomePageDao;
import com.Aishopssh.Entites.*;
import com.Aishopssh.Imp.GoodsImp.CartlistManageImp;
import com.Aishopssh.Imp.GoodsImp.GoodsCommentsImp;
import com.Aishopssh.Imp.GoodsImp.GoodsSearchImp;
import com.Aishopssh.Imp.GoodsServiceImp;
import com.Aishopssh.Imp.WelcomePageImp.WelcomePageImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("GoodsService")
public class GoodsService implements GoodsServiceImp {

    @Autowired
    @Qualifier("WelcomePageDao")
    WelcomePageImp welcomePageDao;

    @Autowired
    @Qualifier("GoodsSearchDao")
    GoodsSearchImp goodsSearchDao;

    @Autowired
    @Qualifier("GoodsCommentsDao")
    GoodsCommentsImp goodsCommentsDao;


    public List<Goods> getWelcomeGoods(int idx, int currpage) {
        return welcomePageDao.GetAllSpSimpleInfo(idx, currpage);
    }

    @Override
    public String getUserName(int uid) {
        return welcomePageDao.getUsername(uid);
    }

    @Override
    public List<Goods> getPublicSearch(String data) {
        return goodsSearchDao.getSearchResult(data);
    }

    @Override
    public List<Goods> getHighSearch(HighShInfo highShInfo) {
        return goodsSearchDao.getHighSearchRs(highShInfo);
    }

    @Override
    public int cartListIsExist(int uid, int gid) {
        return welcomePageDao.cartListIsExist(uid, gid);
    }

    @Override
    public int addToCartLis(int uid, int gid, String currDate) {
        return welcomePageDao.addToCartLst(uid, gid, currDate);
    }

    @Override
    public List<Advertisements> getAdv() {
        return welcomePageDao.getAdv();
    }

    @Override
    public Goods getOneGoods(int gid) {
        return goodsSearchDao.getOneGoods(gid);
    }

    @Override
    public List<Comments> getAllComments(int gid, int curr) {
        return goodsCommentsDao.GetAllCommentBySpId(gid, curr);
    }

    @Override
    public int addComments(int uid, int gid, String Title, String Content, String currDate) {
        return goodsCommentsDao.addComments(uid, gid, Title, Content,currDate);
    }
    @Autowired
    @Qualifier("CartListManageDao")
    CartlistManageImp CarListManageDao;
    public ArrayList<Cartlist> SgetallCart(int uid) {
        return CarListManageDao.getAllCart(uid);
    }

    public int SdelOneGouwuche(int id) {
        return CarListManageDao.DelOneGouwuche(id);

    }

    public int SmodspNum(int num, int spid, int uid) {
        return CarListManageDao.ModspNum(num, spid, uid);
    }

    public int SdelAllCart(int uid) {
        return CarListManageDao.DelAllCart(uid);
    }

    public int SupdatecartOrderNum(int pgid, String dingdanhao) {
        return CarListManageDao.UpdatecartOrderNum(pgid, dingdanhao);
    }
}
