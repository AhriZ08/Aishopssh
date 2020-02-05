package com.Aishop.Action.GoodsAction.GoodsSearch;

import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Entites.HighShInfo;
import com.Aishopssh.Imp.GoodsServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Scope("prototype")
public class getSearchInitData extends ActionSupport implements ServletRequestAware {
    HttpServletRequest request;

    private List<Goods> goodsList;
    public List<Goods> getGoodsList() {
        return goodsList;
    }
    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Autowired
    @Qualifier("GoodsService")
    GoodsServiceImp goodsService;

    public String getSearchDta(){
        String Flag = (String) request.getSession().getAttribute("searchFlag");

        if(Flag.equals("0")){
            String data = (String) request.getSession().getAttribute("searchData");
            if(!data.isEmpty() || data != null){
                goodsList = goodsService.getPublicSearch(data);
                for (Goods g:goodsList){
                    System.out.println(g.getName());
                }
            }
        }else if(Flag.equals("1")){
            HighShInfo highShInfo = (HighShInfo) request.getSession().getAttribute("highShInfo");
            goodsList = goodsService.getHighSearch(highShInfo);
        }
        return "success";
    }
}
