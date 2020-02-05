package com.Aishop.Action.ManagerAction.ManageGoods;

import com.Aishopssh.Entites.Type3;
import com.Aishopssh.Imp.ManagerServiceImp.ManageGoodsServiceImp;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@Scope("prototype")
public class FindType3Action extends ActionSupport implements ServletRequestAware, ServletResponseAware {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Autowired
    @Qualifier("ManageGoodsService")
    private ManageGoodsServiceImp beanDB;

    public String FindType3() throws IOException {
        int type2id = Integer.parseInt(request.getParameter("type2id"));
        List<Type3> type3list;
        type3list = beanDB.GetAllType3();
        String str = "[";
        int type3count = type3list.size();
        for (int i = 0; i < type3count; i++) {
            Type3 type3 = type3list.get(i);
            if (type3.getTbType2ByTypeIdLevel2().getId() == type2id) {
                str += JSON.toJSONString(type3);
                str += ",";
            }
        }
        str = str.substring(0, str.length() - 1);
        str += "]";
        System.out.println(str);
        response.getWriter().write(str);
        response.getWriter().flush();
        response.getWriter().close();
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
