package com.Aishop.Action.ManagerAction.ManageGoods;

import com.Aishopssh.Dao.Common.MyTools;
import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Imp.ManagerServiceImp.ManageGoodsServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
public class GoodsInsertAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Autowired
    @Qualifier("ManageGoodsService")
    private ManageGoodsServiceImp manageService;

    public String GoodsInsert(){
        Goods goods = new Goods();
        //请对应表单提交名称
        goods.setName(request.getParameter("mingcheng"));
        goods.setAddtime(request.getParameter("addtime"));
        goods.setMarketPirce(request.getParameter("shichangjia"));
        goods.setMemberPrice(request.getParameter("huiyuanjia"));
        goods.setTypeIdLevel1(MyTools.strToint(request.getParameter("type1")));
        goods.setTypeIdLevel2(MyTools.strToint(request.getParameter("type2")));
        goods.setTypeIdLevel3(MyTools.strToint(request.getParameter("type3")));
        goods.setLevel(request.getParameter("dengji"));
        goods.setBrand(request.getParameter("pinpai"));
        goods.setModel(request.getParameter("xinghao"));
        goods.setIsRecommend(MyTools.strToint(request.getParameter("tuijian")));
        goods.setNum(MyTools.strToint(request.getParameter("shuliang")));
        goods.setPurchaseTime(MyTools.strToint(request.getParameter("cishu")));
        goods.setPicture(request.getParameter("tupian"));
        goods.setIntroduction(request.getParameter("jianjie"));
        manageService.InsertGoods(goods);

        return "success";
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }
}
