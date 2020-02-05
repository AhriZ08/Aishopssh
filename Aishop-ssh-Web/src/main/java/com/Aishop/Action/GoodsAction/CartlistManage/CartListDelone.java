package com.Aishop.Action.GoodsAction.CartlistManage;

import com.Aishopssh.Dao.Common.MyTools;
import com.Aishopssh.Imp.GoodsServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class CartListDelone extends ActionSupport implements ServletRequestAware, ServletResponseAware {

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
    GoodsServiceImp GoodsService;

    public String cartlistdelone() throws Exception{

        int id = MyTools.strToint(request.getParameter("id"));
        int fg = GoodsService.SdelOneGouwuche(id);
        PrintWriter out = response.getWriter();
        if(fg == 0) {
            out.print("notok");
            System.out.println("购物车删除失败");
            out.flush();
            out.close();
        }else {
            System.out.println("购物车删除成功");
            out.print("ok");
            out.flush();
            out.close();
        }
        return "success";
    }

    }

