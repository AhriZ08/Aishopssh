package com.Aishop.Action.GoodsAction.GoodsComments;

import com.Aishopssh.Imp.GoodsServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Scope("prototype")
public class addComments extends ActionSupport {
    private String comTitle;
    private String comContent;
    private int gid;
    private int uid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getComTitle() {
        return comTitle;
    }

    public void setComTitle(String comTitle) {
        this.comTitle = comTitle;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }
    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Autowired
    @Qualifier("GoodsService")
    GoodsServiceImp goodsService;

    @Override
    public String execute() throws Exception {
        Date date = new Date();
        String s = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String currDate = df.format(date);
        int fg = goodsService.addComments(uid,gid,comTitle,comContent,currDate);
        if(fg != 0){
            s = "failed";
        }else {
            s = "ok";
        }
        inputStream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
        return "success";
    }
}
