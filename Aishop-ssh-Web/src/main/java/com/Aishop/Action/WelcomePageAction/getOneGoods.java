package com.Aishop.Action.WelcomePageAction;

import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Imp.GoodsServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope("prototype")
public class getOneGoods extends ActionSupport implements ServletRequestAware, ServletResponseAware {
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private HttpServletRequest request;
    private HttpServletResponse response;
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Autowired
    @Qualifier("GoodsService")
    GoodsServiceImp goodsService;

    public String getOneGoods(){
        Goods goods = goodsService.getOneGoods(id);
        request.getSession().setAttribute("sp", goods);
        return "success";
    }
}
