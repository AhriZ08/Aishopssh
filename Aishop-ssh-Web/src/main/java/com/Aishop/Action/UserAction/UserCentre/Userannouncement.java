package com.Aishop.Action.UserAction.UserCentre;

import com.Aishopssh.Entites.Notice;
import com.Aishopssh.Imp.UserServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;

public class Userannouncement  extends ActionSupport {
    public ArrayList<Notice> getNotices() {
        return Notices;
    }

    public void setNotices(ArrayList<Notice> notices) {
        Notices = notices;
    }

    private ArrayList<Notice> Notices;

    @Autowired
    @Qualifier("UserService")
    UserServiceImp userservice;
    public String getall(){
        this.Notices= userservice.getall();
        return SUCCESS;
    }
}
