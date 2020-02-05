<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.Aishopssh.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String path = request.getContextPath();
String name = (String)session.getAttribute("username");
String id = (String)session.getAttribute("userid");
%>
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=path %>/css/basic-grey.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>
function leaveword(){
	if(document.getElementById('leavecontent').value!=""){
	var url ="<%=path%>/leavewordInsert.action?userid="+document.getElementById('id').value+"&title="+document.getElementById('leavetitle').value+"&content="+document.getElementById('leavecontent').value;
	alert("提交成功");
	alert(url);
	window.location.href=encodeURI(url);
	window.event.returnValue=false;
	}else{
		alert("请填写内容");
	}
}
</script>

</head>
<body>
<div id="a">
<input type="hidden" id="id" value="<%=id %>">
<form action="" method="post" class="basic-grey">
    <h1>联系管理员
        <span>请填写下列内容</span>
    </h1>
    
    <label>
        <span>您的名字:</span>
        <input id="leavename" type="text" name="leavename" placeholder="您的真实姓名" value=""/>
    </label>
    
    <label>
        <span>您的邮箱:</span>
        <input id="leaveemail" type="text" name="leaveemail" placeholder="您的邮箱" value=""/>
    </label>
    
    <label>
        <span>留言主题:</span>
        <input id="leavetitle" type="text" name="leavetitle" placeholder="主题" value=""/>
    </label>
 
    <label>
        <span>您的意见:</span>
        <textarea id="leavecontent" name="leavecontent" placeholder="请把您的意见告诉我们"></textarea>
    </label>

    <label>
        <span>&nbsp;</span>
        <input type="button" class="button" value="提交" onclick="leaveword()"/>
    </label>
</form>
</div>


</body>
</html>