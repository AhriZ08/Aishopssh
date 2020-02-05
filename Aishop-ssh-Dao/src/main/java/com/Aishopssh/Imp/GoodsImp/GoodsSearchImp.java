package com.Aishopssh.Imp.GoodsImp;

import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Entites.HighShInfo;

import java.util.List;

public interface GoodsSearchImp {
    /**
     * 模糊查询
     * @param data
     * @return
     */
    public List<Goods> getSearchResult(String data);

    /**
     * 高级搜索
     * @param highShInfo
     * @return
     */
    public List<Goods> getHighSearchRs(HighShInfo highShInfo);
    public Goods getOneGoods(int gid);
}
