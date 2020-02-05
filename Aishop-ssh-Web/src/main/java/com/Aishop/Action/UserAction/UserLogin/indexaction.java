package com.Aishop.Action.UserAction.UserLogin;

import com.Aishopssh.Entites.User;
import com.Aishopssh.Imp.UserServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Scope("prototype")
public class indexaction extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest request;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;

    public String getLoginflag() {
        return loginflag;
    }

    public void setLoginflag(String loginflag) {
        this.loginflag = loginflag;
    }

    private String loginflag;

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Autowired
    @Qualifier("UserService")
    UserServiceImp userservice;

    public String indexaction() {
        String name = this.username;
        String password = this.password;
        User user = userservice.GetUserbyName(name);
        SimpleDateFormat dateFormat = new SimpleDateFormat(" yyyy-MM-dd ");
        String currentDate = dateFormat.format(new Date());
        boolean flag = false;
        //得到输入的用户名和密码，用name得到UserInfo类型对象user
        if (user == null) {
            this.loginflag="1";
            return ERROR;
        }//user为空则返回到index界面提示报错
        else {
            flag = user.getPwd().equals(password);
        }//判断用户名是否正确
        if (flag) {

            System.out.println("indexaction id:"+user.getId());
            System.out.println("indexaction name:"+user.getName());
            this.request.getSession().setAttribute("username", user.getName());
            this.request.getSession().setAttribute("id", user.getId());

            System.out.println(this.request.getSession().getAttribute("id"));
            System.out.println(this.request.getSession().getAttribute("username"));
            user.setLoginTime(user.getLoginTime() + 1);
            user.setRecentLoginTime(currentDate);
            userservice.UserUpdate(user);
            return SUCCESS;
        }//跳转到学生登录界面
        if (flag == false && user != null) {
            this.loginflag="2";
            return ERROR;
        }
        return "4";
    }


}
