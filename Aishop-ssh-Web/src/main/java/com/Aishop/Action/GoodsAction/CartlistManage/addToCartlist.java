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
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Scope("prototype")
public class addToCartlist extends ActionSupport implements ServletRequestAware, ServletResponseAware {
    private int id;
    private int uid;
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private InputStream inputStream;
    private HttpServletRequest request;
    private HttpServletResponse response;
    public InputStream getInputStream() {
        return inputStream;
    }
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }


    @Autowired
    @Qualifier("GoodsService")
    GoodsServiceImp goodsService;

    public String addToCartlist(){
        int fg;
        String s = "";
        System.out.println("addToCartlist uid:"+uid);
        System.out.println("addToCartlist id:"+id);
        fg = goodsService.cartListIsExist(uid, id);
        if(fg == 0){
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String currDate = df.format(date);
            int f = goodsService.addToCartLis(uid, id, currDate);
            if (f == 1){
                s = "success";
            }else {
                s = "failed";
            }
        }else {
            s = "NoAdd";
        }
        inputStream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
        return  "success";
    }
}
