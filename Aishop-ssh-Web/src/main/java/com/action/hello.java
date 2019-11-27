package com.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

@Controller
@ParentPackage("struts-default")
@Namespace("/")
public class hello extends ActionSupport {

    @Action(value = "hello", results = {@Result(name = "SUCCESS", location = "/hello.jsp")})
    public String execute() throws Exception {
        System.out.println("xxxx");
        return "SUCCESS";
    }
}
