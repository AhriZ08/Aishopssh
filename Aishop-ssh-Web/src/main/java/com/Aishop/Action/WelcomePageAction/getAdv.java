package com.Aishop.Action.WelcomePageAction;

import com.Aishopssh.Entites.Advertisements;
import com.Aishopssh.Imp.GoodsServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class getAdv extends ActionSupport {
    private List<Advertisements> advertisementsList;

    public List<Advertisements> getAdvertisementsList() {
        return advertisementsList;
    }

    public void setAdvertisementsList(List<Advertisements> advertisementsList) {
        this.advertisementsList = advertisementsList;
    }

    @Autowired
    @Qualifier("GoodsService")
    GoodsServiceImp goodsServicedao;

    public String getAdv(){
        advertisementsList = goodsServicedao.getAdv();
        return "success";
    }
}
