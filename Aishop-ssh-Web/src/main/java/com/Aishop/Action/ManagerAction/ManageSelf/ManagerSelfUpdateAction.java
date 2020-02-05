package com.Aishop.Action.ManagerAction.ManageSelf;

import com.Aishopssh.Dao.Common.MyTools;
import com.Aishopssh.Entites.Admin;
import com.Aishopssh.Imp.ManagerServiceImp.ManageSelfServiceImp;
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
public class ManagerSelfUpdateAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
    private HttpServletRequest request;
    private HttpServletResponse response;

    private Integer id;
    public Integer getAid() {
        return id;
    }
    public void setAid(Integer id) {
        this.id = id;
    }
    @Autowired
    @Qualifier("ManageSelfService")
    private ManageSelfServiceImp manageService;

    public String UpdateManager(){

        Admin manager = new Admin();
        //请对应表单名称
        manager.setId(MyTools.strToint(request.getParameter("id")));
        manager.setName(request.getParameter("name"));
        manager.setPwd(request.getParameter("pwd"));
        manageService.UpdateManager(manager);
        this.id = manager.getId();
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
