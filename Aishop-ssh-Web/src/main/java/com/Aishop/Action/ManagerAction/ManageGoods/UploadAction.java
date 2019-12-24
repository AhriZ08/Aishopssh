package com.Aishop.Action.ManagerAction.ManageGoods;

import com.Aishopssh.Imp.ManagerServiceImp.ManageGoodsServiceImp;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
@Scope("prototype")
public class UploadAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Autowired
    @Qualifier("ManageGoodsService")
    private ManageGoodsServiceImp beanDB;

    public String UploadPic(){
        String SavePath = request.getSession().getServletContext().getRealPath("/images/");
        JSONObject obj = new JSONObject();
        String TempPath = "D:\\NewFolder";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(new File(TempPath));
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            String saveName = "";
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem file:list) {
                FileItem item = file;
                String value = item.getName();
                int stat = value.lastIndexOf("/");
                String filename = value.substring(stat + 1);
                String suffix = filename.substring(filename.lastIndexOf(".") + 1);
                saveName = new Date().getTime() + "." + suffix;
                request.getSession().setAttribute("filename", saveName);
                item.write(new File(SavePath, saveName));
            }
            obj.put("code", 0);
            obj.put("filename", saveName);
            response.getWriter().write(obj.toString());
            response.getWriter().close();
        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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
