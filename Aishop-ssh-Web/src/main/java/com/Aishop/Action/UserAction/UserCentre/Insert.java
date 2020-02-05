package com.Aishop.Action.UserAction.UserCentre;

import com.Aishopssh.Entites.User;
import com.Aishopssh.Imp.UserImp.UserLoginImp;
import com.Aishopssh.Imp.UserServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.Date;
import java.text.SimpleDateFormat;



public class Insert extends ActionSupport{
    private String name=new String();
    private String pwd=new String();
    private String comfirmPwd=new String();
    private String email=new String();
    private String qq=new String();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getComfirmPwd() {
        return comfirmPwd;
    }

    public void setComfirmPwd(String comfirmPwd) {
        this.comfirmPwd = comfirmPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    private String postcode=new String();
    private String trueName=new String();
    private String tel=new String();
    private String addr=new String();
    private String securityQuestion=new String();
    private String securityAnswer=new String();







    @Autowired
    @Qualifier("UserService")
    UserServiceImp userservice;

    public String insert(){
        User user = new User();

        SimpleDateFormat dateFormat = new SimpleDateFormat(" yyyy-MM-dd ");
        String currentDate =  dateFormat.format( new Date() );

        user.setId(userservice.Usernumber()+1);
        user.setName(this.name);
        user.setPwd(this.pwd);
        user.setBlocked(0);
        user.setEmail(this.email);
        user.setTel(this.tel);
        user.setQq(this.qq);
        user.setIp("100.100.1");
        user.setSecurityQuestion(this.securityQuestion);
        user.setSecurityAnswer(this.securityAnswer);
        user.setAddr(this.addr);
        user.setPostcode(this.postcode);
        user.setRegisterTime(currentDate);
        user.setRecentLoginTime("0");
        user.setLoginTime(0);
        user.setTrueName(this.trueName);
        user.setComfirmPwd(this.comfirmPwd);
        userservice.UserInsert(user);
        return "success";
    }


}
