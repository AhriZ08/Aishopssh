<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>管理员界面</title>
	<%
	String path = request.getContextPath();
	//int ManagerID = (int)session.getAttribute("AdminID");
	int ManagerID = 1;
%>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/Manager.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/animate.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/layui/css/layui.css">
<script src="<%=path %>/js/jquery.js"></script>
<script src="<%=path %>/layui/layui.js"></script>
<script>
	var flag = 0
	$(function(){
		$("#1").click(function(){
			if (flag == 0) {
				$("#left").removeClass("slideInLeft").addClass("animated slideOutLeft");
				$("#1").removeClass("layui-icon layui-icon-shrink-right").addClass("layui-icon layui-icon-spread-left");
				$("#work_right").removeClass("div_work_right_show").addClass("div_work_right_hide");
				flag = 1;
			}
			else if (flag == 1) {
				$("#left").removeClass("slideOutLeft").addClass("animated slideInLeft");
				$("#1").removeClass("layui-icon layui-icon-spread-left").addClass("layui-icon layui-icon-shrink-right");
				$("#work_right").removeClass("div_work_right_hide").addClass("div_work_right_show");
				flag = 0;
			}
		})
	})
	
	layui.use('element', function(){
		  var element = layui.element;})
</script>
</head>
<body>
	<div class="div_big">
		<div class="div_header">
			<div class="div_header_control">
				<i id="1" class="layui-icon layui-icon-shrink-right" style="font-size: 35px;"></i>
			</div>
			<div class="div_header_notice">
				<table>
					<tr>
						<td class="div_header_notice_welcome">欢迎管理员登录！</td>
						<td><a href="<%=path%>/NewWelcome.jsp.jsp"><span class="div_header_notice_out">退出</span></a></td>
					</tr>
				</table>
			</div>
		</div>
		<div class="div_work">
			<div class="div_work_left" id="left">
				<ul class="layui-nav layui-nav-tree layui-bg-green" lay-filter="test">
					<li class="layui-nav-item">
						<a href="javascript:;">商品管理</a>
							<dl class="layui-nav-child">
								<dd><a href="<%=path%>/GoodsListAction.action" target="workspace">商品信息</a></dd>
								<dd><a href="<%=path%>/GoodsAddAction.action" target="workspace">增加商品</a></dd>
							</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;">用户管理</a>
							<dl class="layui-nav-child">
								<dd><a href="<%=path%>/UserListAction.action" target="workspace">用户信息</a></dd>
								<dd><a href="<%=path%>/ManagerSelfGetAction.action?id=<%=ManagerID%>" target="workspace">管理员信息</a></dd>
							</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;">订单管理</a>
							<dl class="layui-nav-child">
								<dd><a href="<%=path%>/OrderListAction" target="workspace">订单信息</a></dd>
							</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;">信息管理</a>
							<dl class="layui-nav-child">
								<dd><a href="<%=request.getContextPath() %>/LwListAction" target="workspace">留言管理</a></dd>
								<dd><a href="<%=request.getContextPath() %>/NoticeServlet" target="workspace">系统公告管理</a></dd>
								<dd><a href="<%=request.getContextPath() %>/commentServlet" target="workspace">商品评论管理</a></dd>
							</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;">图片面板管理</a>
							<dl class="layui-nav-child">
								<dd><a href="<%=request.getContextPath() %>/Guanggaolist" target="workspace">系统logo信息</a></dd>
							</dl>
					</li>
				</ul>
			</div>
			<div class="div_work_right_show" id="work_right">
				<iframe class="div_work_right_workspace" name="workspace" scrolling="auto">
			</iframe>
			</div>
		</div>
	</div>
</body>
</html>