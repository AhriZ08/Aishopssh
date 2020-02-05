package com.Aishop.Action.UserAction.UserCentre;

import com.Aishopssh.Entites.Leaveword;
import com.Aishopssh.Entites.User;
import com.Aishopssh.Imp.UserServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IeavewordInsert extends ActionSupport implements ModelDriven<Leaveword> {

    @Autowired
    @Qualifier("UserService")
    UserServiceImp userservice;

    public Leaveword getLeaveword() {
        return leaveword;
    }

    public void setLeaveword(Leaveword leaveword) {
        this.leaveword = leaveword;
    }

    private Leaveword leaveword;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    private String userid;

    @Override
    public Leaveword getModel() {
        return this.leaveword;
    }
    public String leavewordinsert(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(" yyyy-MM-dd ");
        String currentDate =  dateFormat.format( new Date() );
        User user;

        user = userservice.GetUserbyId(Integer.parseInt(this.userid));
        this.leaveword.setId(userservice.GetLeavewordMaxid()+1);
        this.leaveword.setTime(currentDate);
        this.leaveword.setTbUserByUserId(user);
        this.leaveword.setIsReply(0);
        userservice.IeavewordInsert(this.leaveword);
        return "success";
    }

}
