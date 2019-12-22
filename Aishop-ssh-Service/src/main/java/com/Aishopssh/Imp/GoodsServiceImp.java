package com.Aishopssh.Imp;

import com.Aishopssh.Entites.Goods;

import java.util.List;

public interface GoodsServiceImp {
    /***
     * 获取首页指定类型商品，并且分页
     * @param idx 类型，“热门”或者“推荐”
     * @return 指定商品列表
     */
    public List<Goods> getWelcomeGoods(int idx, int currpage);

}
