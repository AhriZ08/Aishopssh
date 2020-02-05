package com.Aishop.Action.GoodsAction.CartlistManage;

import com.Aishopssh.Dao.Common.MyTools;
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
import java.io.PrintWriter;

@Controller
@Scope("prototype")
public class DelAllCart extends ActionSupport implements ServletRequestAware,ServletResponseAware {
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
    @Qualifier("GoodsService")
    GoodsServiceImp CarListManageDao;


    public String delAllCart() throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int uid = MyTools.strToint(String.valueOf(request.getSession().getAttribute("id")));
        if (uid != 0) {
            System.out.println("DelAllCart->uid:" + uid);
            int fg = CarListManageDao.SdelAllCart(uid);
            PrintWriter out = response.getWriter();
            if (fg != 0) {
                out.print("ok");
            } else {
                out.print("notok");
            }
            out.flush();
            out.close();
        }
        return "success";
    }
}
