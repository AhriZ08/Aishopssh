package com.Aishopssh.Imp.ManagerServiceImp;

import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Entites.Type1;
import com.Aishopssh.Entites.Type2;
import com.Aishopssh.Entites.Type3;

import java.util.List;

public interface ManageGoodsServiceImp {
    public List<Goods> GetAllGoods();
    public int InsertGoods(Goods good);
    public int DeleteGoods(int id);
    public List<Goods> GetGood(int id);
    public int UpdateGood(Goods good);
    public List<Type1> GetAllType1();
    public List<Type2> GetAllType2();
    public List<Type3> GetAllType3();
    public List<Type1> GetType1(int id);
    public List<Type2> GetType2(int id);
    public List<Type3> GetType3(int id);


}

