package com.Aishop.Action.GoodsAction.GoodsSearch;

import com.Aishopssh.Entites.Goods;
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
import java.util.List;

@Controller
@Scope("prototype")
public class getGoodsSearchRs extends ActionSupport implements ServletResponseAware, ServletRequestAware {
    private String data;
    private InputStream inputStream;
    public InputStream getInputStream() {
        return inputStream;
    }
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    private HttpServletRequest request;
    private HttpServletResponse response;
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

    public String getSearchResult() {
        List<Goods> goodsList = goodsService.getPublicSearch(data);
        if(!goodsList.isEmpty()){
            request.getSession().setAttribute("searchData", data);
            request.getSession().setAttribute("searchFlag", "0");
            inputStream = new ByteArrayInputStream("OK".getBytes(StandardCharsets.UTF_8));
        }else {
            inputStream = new ByteArrayInputStream("NO".getBytes(StandardCharsets.UTF_8));
        }
        return  "success";
    }

}
