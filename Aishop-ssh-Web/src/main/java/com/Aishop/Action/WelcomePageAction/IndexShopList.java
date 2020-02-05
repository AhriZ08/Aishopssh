package com.Aishop.Action.WelcomePageAction;

import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Entites.PageInfo;
import com.Aishopssh.Imp.GoodsServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class IndexShopList extends ActionSupport {

    private PageInfo<List<Goods>> pageInfo;

    public PageInfo<List<Goods>> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<List<Goods>> pageInfo) {
        this.pageInfo = pageInfo;
    }

    private int idx;
    private int curr;
    public int getCurr() {
        return curr;
    }
    public void setCurr(int curr) {
        this.curr = curr;
    }
    public int getIdx() { return idx; }
    public void setIdx(int idx) { this.idx = idx; }



    @Autowired
    @Qualifier("GoodsService")
    GoodsServiceImp goodsService;

    public String getWelcomePageGoods(){
        List<Goods> goodsList = goodsService.getWelcomeGoods(idx, curr);
        pageInfo = new PageInfo<>();
        pageInfo.setTotal(goodsList.size());
        pageInfo.setData(goodsList);
        return SUCCESS;
    }
}
