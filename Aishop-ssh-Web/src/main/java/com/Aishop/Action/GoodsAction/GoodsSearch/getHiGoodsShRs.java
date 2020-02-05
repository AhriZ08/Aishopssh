package com.Aishop.Action.GoodsAction.GoodsSearch;


import com.Aishopssh.Entites.Goods;
import com.Aishopssh.Entites.HighShInfo;
import com.Aishopssh.Imp.GoodsServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
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
import java.util.List;

@Controller
@Scope("prototype")
public class getHiGoodsShRs extends ActionSupport implements ServletRequestAware, ServletResponseAware, ModelDriven<HighShInfo> {
    private HighShInfo highShInfo = new HighShInfo();
    @Override
    public HighShInfo getModel() {
        return this.highShInfo;
    }

    public HighShInfo getHighShInfo() {
        return highShInfo;
    }
    public void setHighShInfo(HighShInfo highShInfo) {
        this.highShInfo = highShInfo;
    }
    private InputStream inputStream;
    private HttpServletRequest request;
    private HttpServletResponse response;
    public InputStream getInputStream() {
        return inputStream;
    }
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
    @Autowired
    @Qualifier("GoodsService")
    GoodsServiceImp goodsService;


    public String getHiGoodsSearchRs(){
        if(highShInfo == null){
            System.out.println("null");
        };
        if(highShInfo.getShopDim() == null || highShInfo.getShopDim() == "") {
            highShInfo.setShopDim("1");
        }
        List<Goods> goodsList = goodsService.getHighSearch(highShInfo);
        if(!goodsList.isEmpty()){
            request.getSession().setAttribute("highShInfo", highShInfo);
            request.getSession().setAttribute("searchFlag", "1");
            inputStream = new ByteArrayInputStream("OK".getBytes(StandardCharsets.UTF_8));
        }else {
            inputStream = new ByteArrayInputStream("NO".getBytes(StandardCharsets.UTF_8));
        }
        System.out.println("高级搜索表单数据：" + highShInfo.toString());
        return "success";
    }


}
