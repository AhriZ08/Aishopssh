package com.Aishop.Action.GoodsAction.CartlistManage;

import com.Aishopssh.Dao.Common.MyTools;
import com.Aishopssh.Imp.GoodsImp.CartlistManageImp;
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
public class CartlistAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    @Autowired
    @Qualifier("CartListManageDao")
    CartlistManageImp cartlistManage;

    public String cartlistAction() throws Exception {
        request.setCharacterEncoding("UTF-8");
        //设置响应编码格式
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        int uid = MyTools.strToint(String.valueOf(request.getSession().getAttribute("id")));

        request.getSession().setAttribute("CartList", cartlistManage.getAllCart(uid));
        System.out.println("cartlistAction:"+cartlistManage.getAllCart(uid).size());
        return SUCCESS;
    }
}



