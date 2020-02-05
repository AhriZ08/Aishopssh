<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.Aishopssh.*"%>
<%@ page import="com.Aishopssh.Dao.UserDao.UserInfoDao" %>
<!DOCTYPE html>
<%

	String path = request.getContextPath();
	String name = request.getParameter("username");
	String password = request.getParameter("password");
	System.out.print(password);
	UserInfoDao userinfodao= new UserInfoDao();
	String pwd = new String();
	pwd=userinfodao.GetUserbyName(name).getPwd();
	boolean flag = false;
	//得到输入的用户名和密码，用name得到UserInfo类型对象user
	if(pwd==null){
		session.setAttribute("username",name);
		session.setAttribute("loginflag","1");
		response.sendRedirect(path+"/index.jsp");
	}//user为空则返回到index界面提示报错
	else{
		flag = pwd.equals(password);
	}//判断用户名是否正确
	if(flag){
		
		response.sendRedirect(path+"/jiemian/index2.jsp");
		}//跳转到学生登录界面

%>