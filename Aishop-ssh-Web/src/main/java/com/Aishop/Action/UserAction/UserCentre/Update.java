package com.Aishop.Action.UserAction.UserCentre;

import com.Aishopssh.Entites.User;
import com.Aishopssh.Imp.UserServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Update extends ActionSupport implements ModelDriven<User> {
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getModel() {
        return this.user;
    }

    @Autowired
    @Qualifier("UserService")
    UserServiceImp userservice;

    public String update(User user){
        userservice.UserUpdate(user);
        return "success";
    }
}
