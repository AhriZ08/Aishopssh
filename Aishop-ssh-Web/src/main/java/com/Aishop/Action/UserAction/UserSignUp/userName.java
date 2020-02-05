package com.Aishop.Action.UserAction.UserSignUp;

import com.Aishopssh.Entites.User;
import com.Aishopssh.Imp.GoodsServiceImp;
import com.Aishopssh.Imp.UserImp.UserLoginImp;
import com.Aishopssh.Imp.UserServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.security.PrivateKey;
import java.util.List;

public class userName extends ActionSupport {


    public String getExistence() {
        return existence;
    }

    public void setExistence(String existence) {
        this.existence = existence;
    }

    private String existence;

    @Autowired
    @Qualifier("UserService")
    UserServiceImp UserService;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public String username(){

        this.existence="2";
        User user = UserService.GetUserbyName(this.name);
        if(user==null){
            this.existence="1";
        }
        return SUCCESS;
    }


}
