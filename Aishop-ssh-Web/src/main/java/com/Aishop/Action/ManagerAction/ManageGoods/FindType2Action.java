package com.Aishop.Action.ManagerAction.ManageGoods;

import com.Aishopssh.Entites.Type2;
import com.Aishopssh.Imp.ManagerImp.ManageGoodsDaoImp;
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
public class FindType2Action extends ActionSupport implements ServletRequestAware, ServletResponseAware {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Autowired
    @Qualifier("ManageGoodsDao")
    ManageGoodsDaoImp beanDB;

    public String FindType2() throws IOException {
        int type1id = Integer.parseInt(request.getParameter("type1id"));
        List<Type2> type2list;
        type2list = beanDB.GetAllType2();
        String str = "[";
        int type2count = type2list.size();
        for (int i = 0; i < type2count; i++) {
            Type2 type2 = type2list.get(i);
            if (type2.getId() == type1id) {
                str += JSON.toJSONString(type2);
                str += ",";
            }
        }
        str = str.substring(0, str.length() - 1);
        str += "]";
        response.getWriter().write(str);
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
