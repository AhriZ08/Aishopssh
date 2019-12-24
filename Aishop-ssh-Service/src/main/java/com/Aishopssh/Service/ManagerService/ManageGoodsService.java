package com.Aishopssh.Service.ManagerService;

import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Entites.Type1;
import com.Aishopssh.Entites.Type2;
import com.Aishopssh.Entites.Type3;
import com.Aishopssh.Imp.ManagerImp.ManageGoodsDaoImp;
import com.Aishopssh.Imp.ManagerServiceImp.ManageGoodsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ManageGoodsService")
public class ManageGoodsService implements ManageGoodsServiceImp {
    @Autowired
    @Qualifier("ManageGoodsDao")
    private ManageGoodsDaoImp manageGoodsDao;

    @Override
    public List<Goods> GetAllGoods() {
        return manageGoodsDao.GetAllGoods();
    }

    @Override
    public int InsertGoods(Goods good) {
        manageGoodsDao.InsertGoods(good);
        return 0;
    }

    @Override
    public int DeleteGoods(int id) {
        manageGoodsDao.DeleteGoods(id);
        return 0;
    }

    @Override
    public List<Goods> GetGood(int id) {
        return manageGoodsDao.GetGood(id);
    }

    @Override
    public int UpdateGood(Goods good) {
        manageGoodsDao.UpdateGood(good);
        return 0;
    }

    @Override
    public List<Type1> GetAllType1() {
        return manageGoodsDao.GetAllType1();
    }

    @Override
    public List<Type2> GetAllType2() {
        return manageGoodsDao.GetAllType2();
    }

    @Override
    public List<Type3> GetAllType3() {
        return manageGoodsDao.GetAllType3();
    }

    @Override
    public List<Type1> GetType1(int id) {
        return manageGoodsDao.GetType1(id);
    }

    @Override
    public List<Type2> GetType2(int id) {
        return manageGoodsDao.GetType2(id);
    }

    @Override
    public List<Type3> GetType3(int id) {
        return manageGoodsDao.GetType3(id);
    }
}
