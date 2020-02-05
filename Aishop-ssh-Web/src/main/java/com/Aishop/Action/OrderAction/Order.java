package com.Aishop.Action.OrderAction;

import com.Aishopssh.Entites.Orders;
import com.Aishopssh.Imp.OrderServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Maredb
 * @date 2019-12-24 - 16:57
 */
@Controller
@Scope("prototype")
public class Order extends ActionSupport implements ServletResponseAware, ServletRequestAware {

    private HttpServletRequest request;
    private HttpServletResponse response;

    private String status;

    @Autowired
    @Qualifier("OrderService")
    private OrderServiceImp orderService;

    private int oid;                            //订单ID
    Orders order = new Orders();                //一个订单对象
    private String num;                         //订单号
    private String Xdr;                         //下单人
    private int flag = 0;


    //获取所有订单
    public String getAllOrder(){
        request.getSession().setAttribute("orderList",orderService.getAllOrder());
        return SUCCESS;
    }

    //根据订单号删除订单
    public String delOrder(){
        flag = orderService.DeleteOrder(oid);
        getAllOrder();
        return SUCCESS;
    }

    //修改订单状态
    public String reOrder(){
        order = orderService.getOrderByNum(num);
        order.setStatus(status);
        flag = orderService.StatusOrder(order);
        getAllOrder();
        return SUCCESS;
    }

    //根据订单号得到订单
    public String getOrderByNum(){
        request.getSession().setAttribute("order",orderService.getOrderByNum(num));
        return SUCCESS;
    }

    //根据下单人得到订单
    public String getOrderByXdr(){
        request.getSession().setAttribute("order2",orderService.getOrderByXdr(Xdr));
        return SUCCESS;
    }

    //根据下单人和订单号得到订单
    public String getOrderByXN(){
        request.getSession().setAttribute("order3",orderService.getOrderByNameAndNum(Xdr,num));
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getXdr() {
        return Xdr;
    }

    public void setXdr(String xdr) {
        Xdr = xdr;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
