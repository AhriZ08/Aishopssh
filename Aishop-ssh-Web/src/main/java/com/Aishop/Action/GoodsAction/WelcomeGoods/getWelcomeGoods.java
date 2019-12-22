package com.Aishop.Action.GoodsAction.WelcomeGoods;

import com.Aishopssh.Service.GoodsService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class getWelcomeGoods extends ActionSupport {

    @Autowired
    GoodsService goodsService;

    private int idx;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String WelcomeGoodslist(){

        return null;
    }
}
