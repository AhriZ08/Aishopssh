package com.Aishop.Action.WelcomePageAction;

import com.Aishopssh.Imp.GoodsServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Controller
@Scope("prototype")
public class getUserName extends ActionSupport {
    private int id;
    private InputStream inputStream;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Autowired
    @Qualifier("GoodsService")
    GoodsServiceImp goodsService;
    public String getUserName() {
        System.out.println(id);
        String s = goodsService.getUserName(id);
        inputStream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
        return "SUCCESS";
    }
}
