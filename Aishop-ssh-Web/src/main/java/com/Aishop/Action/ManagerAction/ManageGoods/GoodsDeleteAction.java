package com.Aishop.Action.ManagerAction.ManageGoods;

import com.Aishopssh.Imp.ManagerServiceImp.ManageGoodsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class GoodsDeleteAction {
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Autowired
    @Qualifier("ManageGoodsService")
    ManageGoodsServiceImp manageService;

    public String DeleteGoods(int id) {
        manageService.DeleteGoods(id);
        return "success";
    }
}
