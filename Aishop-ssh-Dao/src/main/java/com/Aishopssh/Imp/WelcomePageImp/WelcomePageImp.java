package com.Aishopssh.Imp.WelcomePageImp;

import com.Aishopssh.Entites.Advertisements;
import com.Aishopssh.Entites.Goods;

import java.util.List;

public interface WelcomePageImp {
    /**
     * 获取首页商品，并且分页
     * @param idx “热门”或者“推荐”标志
     * @return 分页后的商品列表
     */
    public List<Goods> GetAllSpSimpleInfo(int idx, int currpage);

    /**
     * 获取用户名
     * @return 用户名
     */
    public String getUsername(int uid);
    public int cartListIsExist(int uid, int gid);
    public int addToCartLst(int uid, int gid, String currDate);
    public List<Advertisements> getAdv();
}
