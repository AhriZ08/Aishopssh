package com.Aishop.Action.GoodsAction.CartlistManage;

import com.Aishopssh.Dao.Common.MyTools;
import com.Aishopssh.Entites.Orders;
import com.Aishopssh.Imp.GoodsImp.CartlistManageImp;
import com.Aishopssh.Imp.ManagerImp.ManageGoodsImp;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Scope("prototype")
public class AddOrder extends ActionSupport implements ServletRequestAware, ServletResponseAware{

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
    @Qualifier("ManagerDao")
    ManageGoodsImp manageGoods;

    @Autowired
    @Qualifier("CartListManageDao")
    CartlistManageImp cartlistManage;

    public String addOrder() throws Exception{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取请求参数
        Orders order = new Orders();
        order.setConsigneeName(request.getParameter("rcname"));
        order.setConsigneeSex(request.getParameter("rcsex"));
        order.setConsigneeAddr(request.getParameter("rcadd"));
        order.setPostcode(request.getParameter("rcpost"));
        order.setTel(request.getParameter("rctel"));
        order.setConsigneeRecTime(request.getParameter("rctime"));
        order.setPaymentType(request.getParameter("rctype"));
        order.setPurchaserLeaveWord(request.getParameter("rclw"));
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setConsigneeRecTime(df.format(d));
        int uid = MyTools.strToint(String.valueOf(request.getSession().getAttribute("id")));
        SimpleDateFormat ddf = new SimpleDateFormat("yyyyMMddHHmmss");
        order.setPurchaseTime(ddf.format(new Date()) + uid);
        String xiadanren = (String)request.getSession().getAttribute("username");
        System.out.println("xiadanren:" + xiadanren);
        order.setPurchaserName(xiadanren);

        String total = (String)request.getSession().getAttribute("totalM");
        order.setAmount(total);

        order.setStatus("已收款");

        System.out.println(order.toString());
        int flgl = manageGoods.AddOrder(order);

        PrintWriter out = response.getWriter();
        if(flgl == 0) {
            out.print("no");
        }
        if(flgl == 1) {
            out.print("ok");
            if(uid != 0) {
                request.getSession().removeAttribute("CartList");
                String sr = order.getPostcode();
                int pgid = MyTools.strToint(sr.substring(14));
                int x = cartlistManage.UpdatecartOrderNum(pgid,order.getNum());
                if(x != 0) {
                    System.out.println("下单并清空购物车成功！");
                }
            }
        }
        out.flush();
        out.close();
        return SUCCESS;
    }


}
