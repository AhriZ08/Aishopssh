package com.Aishop.Action.UserAction.UserLogin;

import com.Aishopssh.Entites.User;
import com.Aishopssh.Imp.UserServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class GetUserInfo extends ActionSupport {
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    private User user =new User();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name="123";

    @Autowired
    @Qualifier("UserService")

    UserServiceImp UserService;
    public User getuserinfo(){
        this.user=UserService.GetUserbyName(this.name);
        return this.user;
    }
}
