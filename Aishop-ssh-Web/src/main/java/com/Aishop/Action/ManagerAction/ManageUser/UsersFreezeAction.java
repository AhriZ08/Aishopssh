package com.Aishop.Action.ManagerAction.ManageUser;

import com.Aishopssh.Entites.User;
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
public class UsersFreezeAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Autowired
    @Qualifier("ManageUserService")
    private ManageUserServiceImp manageService;

    public  String UpdateUser(){
        User user = new User();
        int id = Integer.parseInt(request.getParameter("id"));
        user = (User)manageService.GetUser(id);
        int dongjie = user.getBlocked();
        if (dongjie == 0) {
            dongjie = 1;
        }
        else if (dongjie == 1) {
            dongjie = 0;
        }
        user.setBlocked(dongjie);
        manageService.FreezeUser(user);

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
