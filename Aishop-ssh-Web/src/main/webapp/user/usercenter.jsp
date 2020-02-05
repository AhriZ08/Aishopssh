<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.Aishopssh.Entites.User"%>
<%@ page import="com.Aishopssh.Dao.UserDao.UserInfoDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String name = (String)session.getAttribute("username");
	UserInfoDao userinfodao = new UserInfoDao();
	User user = new User();
	user = userinfodao.GetUserbyName(name);
%>
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=path %>/css/basic-grey.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>
function update(){
	var url ="<%=path%>/update.action?&id="+frm1.id.value+"&name="+frm1.name.value+"&pwd"+frm1.pwd.value+
			"&blocked"+frm1.blocked.value+"&email="+frm1.email.value+"&qq="+frm1.qq.value+"&postcode="+frm1.youbian.value+
			"&trueName="+frm1.truename.value+"&tel="+frm1.tel.value+"&addr="+frm1.dizhi.value+"&securityQuestion="+frm1.tishi.value+"&securityAnswer="+frm1.huida.value
	+"&comfirmPwd="+frm1.comfirmPwd.value+"&registerTime="+frm1.registerTime.value+"&recentLoginTime="+frm1.recentLoginTime.value+"&loginTime="+frm1.loginTime.value
	"&ip='111'";
	alert("修改成功");
	window.location.href=encodeURI(url);
	window.event.returnValue=false;
}
</script>

</head>
<body>
<form name="frm1" method="post" class="basic-grey">

<input type="hidden" value="<%=user.getName()%>" name="name" id="txt1">
	<input type="hidden" value="<%=user.getId()%>" name="id" id="id">
	<input type="hidden" value="<%=user.getPwd()%>" name="pwd" >
	<input type="hidden" value="<%=user.getBlocked()%>" name="blocked" >
	<input type="hidden" value="<%=user.getComfirmPwd()%>" name="comfirmPwd" >
	<input type="hidden" value="<%=user.getRegisterTime()%>" name="registerTime" >
	<input type="hidden" value="<%=user.getRecentLoginTime()%>" name="recentLoginTime" >
	<input type="hidden" value="<%=user.getLoginTime()%>" name="loginTime" >
<h1><font color=#fbb8ac><%=name %>的个人中心</font></h1>

    <label>
	<span>真实姓名:</span>
	<input type="text" value="<%=user.getTrueName()%>" name="truename">
	</label>
	
	 <label>
	<span>E-mail:</span>
	<input type="text" value="<%=user.getEmail()%>" name="email">
	</label>
	
	 <label>
	<span>QQ号码:</span>
	<input type="text" value="<%=user.getQq()%>" name="qq">
	</label>
	 <label>
	<span>联系电话:</span>
	<input type="text" value="<%=user.getTel()%>" name="tel">
	</label>
	 <label>
	<span>联系住址:</span>
	<input type="text" value="<%=user.getAddr()%>" name="dizhi">
	</label>
	 <label>
	<span>邮政编码:</span>
	<input type="text" value="<%=user.getPostcode()%>" name="youbian">
	</label>
	 <label>
	<span>找回问题:</span>
	<input type="text" value="<%=user.getSecurityQuestion()%>" name="tishi">
	</label>
	 <label>
	<span>答案:</span>
	<input type="text" value="<%=user.getSecurityAnswer()%>" name="huida">
	</label>

	<label>
        <span>&nbsp;</span>
        <input type="button" class="button" value="提交" onclick="update()"/>
    </label>

</form>
</body>
</html>