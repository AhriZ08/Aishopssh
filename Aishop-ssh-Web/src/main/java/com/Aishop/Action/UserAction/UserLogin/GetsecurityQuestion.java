package com.Aishop.Action.UserAction.UserLogin;

import com.Aishopssh.Entites.User;
import com.Aishopssh.Imp.UserServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Controller
@Scope("prototype")
public class GetsecurityQuestion extends ActionSupport implements ServletResponseAware {

    private HttpServletResponse response;
    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }
    public List<String> getSecurityQuestion() {
        return SecurityQuestion;
    }

    public void setSecurityQuestion(List<String> securityQuestion) {
        SecurityQuestion = securityQuestion;
    }

    private List<String> SecurityQuestion;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Autowired
    @Qualifier("UserService")
    UserServiceImp UserService;
    public String getsecurityquestion() throws IOException {
        User user = UserService.GetUserbyName(this.name);
        response.getWriter().write("[{\"Tishi\":\""+user.getSecurityQuestion() +"\"},{\"Huida\":\""+user.getSecurityAnswer()+"\"},{\"Pwd\":\""+user.getPwd()+"\"}]");
        response.getWriter().flush();
        response.getWriter().close();
        return SUCCESS;
    }


}
