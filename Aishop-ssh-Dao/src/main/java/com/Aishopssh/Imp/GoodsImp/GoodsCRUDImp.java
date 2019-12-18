package com.Aishopssh.Imp.GoodsImp;

import com.Aishopssh.Entites.Cartlist;
import com.Aishopssh.Entites.Goods;

import java.util.List;

public interface GoodsCRUDImp {
    public Goods getOneGoodsByID(int id);
    public boolean deleteOneGoodsByID(int id);
    public boolean insertOneGoodsByID(Goods goods);
    public boolean updateOneGoods(Goods goods);
    public List<Goods> getGoodsList();

    public Cartlist getOneCartlist();
    public List<Cartlist> getlistOfCartlist();
    public boolean deleteOneCartlist();
}
