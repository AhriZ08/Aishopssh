package com.Aishop.Action.ManagerAction.ManageUser;

import com.Aishopssh.Imp.ManagerServiceImp.ManageUserServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope("prototype")
public class UsersDeleteAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Autowired
    @Qualifier("ManageUserService")
    private ManageUserServiceImp manageService;

    public String DeleteUser(){
        int id = Integer.parseInt(request.getParameter("id"));
        manageService.DeleteUser(id);
        return "success";
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }
}
