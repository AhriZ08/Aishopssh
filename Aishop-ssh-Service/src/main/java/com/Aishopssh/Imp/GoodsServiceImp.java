package com.Aishopssh.Imp;

import com.Aishopssh.Entites.*;

import java.util.ArrayList;
import java.util.List;

public interface GoodsServiceImp {
    /***
     * 获取首页指定类型商品，并且分页
     * @param idx 类型，“热门”或者“推荐”
     * @return 指定商品列表
     */
    public List<Goods> getWelcomeGoods(int idx, int currpage);
    public String getUserName(int uid);
    public List<Goods> getPublicSearch(String data);
    public List<Goods> getHighSearch(HighShInfo highShInfo);
    public int cartListIsExist(int uid, int gid);
    public int addToCartLis(int uid, int gid, String currDate);
    public List<Advertisements> getAdv();
    public Goods getOneGoods(int gid);
    public List<Comments> getAllComments(int gid, int curr);
    public int addComments(int uid, int gid, String Title, String Content, String currDate);

    public ArrayList<Cartlist> SgetallCart(int uid);

    public int SdelOneGouwuche(int id);

    public int SmodspNum(int num,int spid,int uid);

    public int SdelAllCart(int uid);

    public int SupdatecartOrderNum(int pgid,String dingdanhao);
}
