package com.Aishop.Action.WelcomePageAction;

import com.Aishopssh.Entites.Goods;
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

    private List<Goods> goodsList;

    private int idx;
    private int currpage;

    public List<Goods> getGoodsList() { return goodsList; }

    public int getIdx() { return idx; }

    public void setIdx(int idx) { this.idx = idx; }

    public int getCurrpage() { return currpage; }

    public void setCurrpage(int currpage) { this.currpage = currpage; }

    @Autowired
    @Qualifier("GoodsService")
    GoodsServiceImp goodsService;

    public String getWelcomePageGoods(){
        this.goodsList = goodsService.getWelcomeGoods(idx, currpage);
        return SUCCESS;
    }
}
