<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.Aishopssh.Entites.Admin" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String path = request.getContextPath();
	Admin manager = (Admin) session.getAttribute("mgr");
	session.removeAttribute("mgr");
%>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/Manager.css">
<script type="text/javascript" src="<%=path %>/js/datacheck.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/layui/css/layui.css">
<script src="<%=path %>/js/jquery.js"></script>
<script src="<%=path %>/layui/layui.js"></script>
<script src="<%=path %>/js/ajaxupload.js"></script>
<script>
	layui.use('form', function(){
	  	var form = layui.form;
		form.on('submit(formDemo)', function(data){
			layer.msg(JSON.stringify(data.field));
		});
	});
</script>
<body>
	<form class="layui-form" method="post" action="<%=path%>/ManagerSelfUpdateAction.action">
		<input type="hidden" name="id" value="<%=manager.getId()%>">
		<div class="layui-form-item">
			<label class="layui-form-label">账号：</label>
			<div class="layui-input-block">
      			<input type="text" name="name" required  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input" value="<%=manager.getName()%>">
    		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码：</label>
			<div class="layui-input-block">
      			<input type="text" name="pwd" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" value="<%=manager.getPwd()%>">
    		</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</body>
</html>