package com.Aishopssh.Imp.GoodsImp;

import com.Aishopssh.Entites.Cartlist;
import com.Aishopssh.Entites.Goods;

import java.util.ArrayList;

public interface CartlistManageImp {
    /**
     * 根据当用户id查询此用户的购物车
     * @param uid 用户id
     * @return 用户购物车列表
     */
    public ArrayList<Cartlist> getAllCart(int uid);
    public int DelOneGouwuche(int id);
    public int ModspNum(int num, int spid, int uid);
    public int DelAllCart(int uid);
    public int UpdatecartOrderNum(int pgid, String dingdanhao);

}
