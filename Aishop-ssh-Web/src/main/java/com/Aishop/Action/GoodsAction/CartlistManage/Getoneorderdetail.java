package com.Aishop.Action.GoodsAction.CartlistManage;

import com.Aishopssh.Entites.CartAndOrderInfo;
import com.Aishopssh.Entites.Cartlist;
import com.Aishopssh.Entites.Orders;
import com.Aishopssh.Imp.ManagerServiceImp.ManagerServiceImp;
import com.alibaba.fastjson.JSON;
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
import java.util.ArrayList;

@Controller
@Scope("prototype")
public class Getoneorderdetail extends ActionSupport implements ServletResponseAware, ServletRequestAware {
    private HttpServletRequest request;
    private HttpServletResponse response;

    private int OdNum;

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

    public String GetOneOrderdetail() throws Exception{
        //设置请求编码格式
        request.setCharacterEncoding("UTF-8");
        //设置响应编码格式
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String OdNum = request.getParameter("OdNum");
        //获取订单
        Orders oddet = OrderlistDao.SGetOnedetailOrders(OdNum);
        //获取该订单的商品信息
        ArrayList<Cartlist> cartlistArrayList = OrderlistDao.SGetOrderCarlist(OdNum);

        CartAndOrderInfo<ArrayList<Cartlist>, Orders> crador = new CartAndOrderInfo<ArrayList<Cartlist>,Orders>();
        crador.setCartlist(cartlistArrayList);
        crador.setOrderinfo(oddet);

        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(crador));
        System.out.println("GetOneOrder-oddet->" + oddet.toString());
        out.flush();
        out.close();
        return SUCCESS;
    }
    public int getOdNum() {
        return OdNum;
    }

    public void setOdNum(int odNum) {
        this.OdNum = odNum;
    }
}
