package com.Aishop.Action.LeaveWordAction;

import com.Aishopssh.Imp.LeaveWordServiceImp;
import com.Aishopssh.Service.LeaveWordService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Maredb
 * @date 2019-12-24 - 15:13
 */
@Controller
@Scope("prototype")
public class LeaveWord extends ActionSupport implements ServletResponseAware, ServletRequestAware {

    private HttpServletRequest request;
    private HttpServletResponse response;

    @Autowired
    @Qualifier("LeaveWordService")
    private LeaveWordServiceImp leaveService;

    private int uid;                                        //用户ID
    private int lid;                                        //留言ID

    @Autowired
    LeaveWordService leaveWordService;


    //通过用户ID来获得所有留言
    public String getAllLeaveWord(){
        request.getSession().setAttribute("list",leaveService.GetAllLeaveWordByUid(uid));
        return SUCCESS;
    }

    //通过留言ID获得留言
    public String getLeaveWordBylId(){
        request.getSession().setAttribute("leaveword",leaveService.getLeaveWordByLid(lid));
        request.getSession().setAttribute("reply",leaveService.getReplyById(lid));
        return SUCCESS;
    }

    //通过留言ID获得管理员回复内容
    public String getReplyBylId(){
        request.getSession().setAttribute("reply",leaveService.getReplyById(lid));
        return SUCCESS;
    }


    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }
}
