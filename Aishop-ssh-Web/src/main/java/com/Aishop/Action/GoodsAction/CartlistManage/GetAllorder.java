package com.Aishop.Action.GoodsAction.CartlistManage;

import com.Aishopssh.Dao.Common.MyTools;
import com.Aishopssh.Entites.Orders;
import com.Aishopssh.Imp.ManagerServiceImp.ManagerServiceImp;
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
public class GetAllorder extends ActionSupport implements ServletRequestAware, ServletResponseAware {
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
    @Qualifier("ManagerService")
    ManagerServiceImp OrderlistDao;

    public String Getallorder() throws Exception{

            //设置请求编码格式
            request.setCharacterEncoding("UTF-8");
            //设置响应编码格式
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            int uid = MyTools.strToint(String.valueOf(request.getSession().getAttribute("id")));

            System.out.println("GetAllOrder->uid:" + uid);
            List<Orders> odsipls = new ArrayList<Orders>();
            odsipls = OrderlistDao.SGetAllOrder(uid);
            System.out.println("odsipls的长度->" + odsipls.size());
            request.getSession().setAttribute("odsipls", odsipls);
            return "success";
        }

}
