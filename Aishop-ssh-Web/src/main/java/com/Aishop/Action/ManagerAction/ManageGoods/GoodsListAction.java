package com.Aishop.Action.ManagerAction.ManageGoods;

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

@Controller
@Scope("prototype")
public class GoodsListAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Autowired
    @Qualifier("ManageGoodsService")
    private ManageGoodsServiceImp manageService;

    public String GetAllGoods() {
       request.getSession().setAttribute("goods", manageService.GetAllGoods());
       request.getSession().setAttribute("type1", manageService.GetAllType1());
       request.getSession().setAttribute("type2", manageService.GetAllType2());
       request.getSession().setAttribute("type3", manageService.GetAllType3());
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
