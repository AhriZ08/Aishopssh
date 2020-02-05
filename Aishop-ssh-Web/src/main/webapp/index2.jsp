<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.Aishopssh.*"%>
<%@ page import="com.Aishopssh.Dao.UserDao.UserannouncementDao" %>
<%@ page import="com.Aishopssh.Entites.Notice" %>

<!DOCTYPE html>
<html>
<head>
<%
	String path = request.getContextPath();
	Integer uid = (Integer) request.getSession().getAttribute("id");
	String id = Integer.toString(uid);
	String name = (String)request.getSession().getAttribute("username");
%>
<link rel="stylesheet" type="text/css" href="<%=path%>/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/user.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body{
background-color:#f1fbf1;
overflow-x:hidden; 
overflow-y:auto;
}
table{
width:100%;
height:100px;
}
th{
vertical-align:top;
}

.beijin {
	margin-left: 0;
	margin-right: -100px;
	max-width: 500px;
	font-family: 楷体;
	font-size: 20pt;
	background-position:50% 50%;
	width:200px;height:775px;
}

.login_click p{
line-height: 0.5
}
.login_click{
left:20%;
}
.beijin2 {
	margin-left: 300px;
	margin-right: -100px;
	font-family: 楷体;
	background-color:#f1fbf1;
	background-position:50% 0%;
}

.imgfocus p{
line-height: 0.5;
width:100%; height:100%; border:1px;
font-family: 楷体;
font-size:30px;
}
.time{
font-size:18px;
}

</style>
<title>个人界面</title>
</head>
<body>
<input type="hidden" value="<%=id%>" name="fid" id="fid">
<%session.setAttribute("userid",id);%>
<input type="hidden" value="<%=name%>" name="name" id="name">
<%session.setAttribute("username",name);%>
<ul class="layui-nav" id="frm">
  <li class="layui-nav-item">
    <a href="<%=path%>/user/leaveword.jsp" target = "zhuye">信息提示<span class="layui-badge-dot"></span></a>
  </li>
  <li class="layui-nav-item">
    <a href="" id="user"><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>
    <dl class="layui-nav-child" id="dl">
      <dd><a href="<%=path%>/user/usercenter.jsp" target = "zhuye">修改信息</a></dd>
      <dd><a href="javascript:;">安全管理</a></dd>
      <dd><a href="<%=path%>/index.jsp">退出账号</a></dd>
    </dl>
  </li>
</ul>
<table id="zhongxin" border="0" cellpadding="0">
<tr><th width=200px bgcolor="#425266">
<div class="beijin"><div class="login_click" id="login_click2">
			        <a  href="<%=path%>/jiemian/jiemian2.jsp" target = "zhuye">&emsp;公告&emsp;</a>
		</div>
		<div class="login_click" >
			  <a  href="<%=path%>/NewWelcome.jsp">购物首页</a>
		</div>
		<div class="login_click" >
			  <a  href="<%=path%>/CartlistAction.action">购物车&emsp;</a>
		</div>
		<div class="login_click" >
			  <a  href="<%=path%>/SeeOrder/seeorder.jsp" target = "zhuye">订单信息</a>
		</div>
</div>
		</th>
<th ><iframe id="frame_content" src="<%=path %>/jiemian/jiemian2.jsp"  frameborder="0" width=100% height=775 name="zhuye"></iframe>

		</th>
		</tr>

</table>

<script src="<%=path%>/layui/layui.all.js"></script>
<script>
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
  
  //…
});
</script>


</body>
<script src="<%=path %>/jquery/jquery-3.3.1.js"></script>
<script type="text/javascript" src="<%=path%>/js1/koala.min.1.5.js"></script>

<script type="text/javascript">
Qfast.add('widgets', { path: "<%=path%>/js1/terminator2.2.min.js", type: "js", requires: ['fx'] });  
Qfast(false, 'widgets', function () {	
	K.tabs({
		id: 'decoroll2', 
		conId: "decoimg_a2",//
		tabId:"deconum2",//
		tabTn:"a",
		conCn: '.decoimg_b2',//     
		auto: 1,//
		effect: 'fade',//
		eType: 'mouseover',//
		pageBt:true,//
		bns: ['.prev', '.next'],//                        
		interval: 3000// 
		
	}) 
}) 
</script>
</html>