package com.Aishop.Action.ManagerAction.ManageGoods;

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
import java.util.List;

@Controller
@Scope("prototype")
public class GoodsGetAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Autowired
    @Qualifier("ManageGoodsService")
    private ManageGoodsServiceImp manageService;

    public String GetGoods() {
        int id = Integer.parseInt(request.getParameter("id"));
        Goods goods = manageService.GetGood(id).get(0);
        request.getSession().setAttribute("good", goods);
        request.getSession().setAttribute("type1", manageService.GetAllType1());
        request.getSession().setAttribute("Type1", manageService.GetType1(goods.getType1().getId()));
        request.getSession().setAttribute("Type2", manageService.GetType2(goods.getType2().getId()));
        request.getSession().setAttribute("Type3", manageService.GetType3(goods.getType3().getId()));
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
