package com.Aishop.Action.UserAction.UserCentre;

import com.Aishopssh.Entites.Notice;
import com.Aishopssh.Imp.UserImp.UserannouncementImp;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@Scope("prototype")
public class getNotice extends ActionSupport implements ServletRequestAware {
    HttpServletRequest request;
    private List<Notice> noticeList;

    public List<Notice> getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(List<Notice> noticeList) {
        this.noticeList = noticeList;
    }

    @Autowired
    @Qualifier("UserannouncementDao")
    UserannouncementImp userannouncement;

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = request;
    }

    @Override
    public String execute() throws Exception {
        this.noticeList = userannouncement.getAll();
        if(noticeList.isEmpty()){
            System.out.printf("noticeList is null");
        }else{
            System.out.printf("noticeList not null");
        }
        for (Notice notice:noticeList){
            System.out.printf(notice.getTitle());
        }
        return "success";
    }
}
