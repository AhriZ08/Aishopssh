<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.Aishopssh.Entites.User" %>
<%@ page import="com.Aishopssh.Dao.ManagerDao.ManageUserDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String path = request.getContextPath();
	List<User> reclist = (List<User>)session.getAttribute("users");
	session.removeAttribute("users");
	ManageUserDao beanDB = new ManageUserDao();
%>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/Manager.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/layui/css/layui.css">
<script type="text/javascript" src="<%=path %>/js/datacheck.js"></script>
<script src="<%=path %>/js/jquery.js"></script>
<script>
	function Dongjie(id){
		$.ajax({
			url:'<%=path%>/UsersFreezeAction.action?id=' + id
			,dataType:'text'
			,type:'get'
			,cache:false
			,success:function(){
				var zhuangtai = $("#zhuangtai").html();
				$("#zhuangtai").html("");
				$("#dongjie").html("");
				if (zhuangtai == "正常") {
					$("#zhuangtai").html("冻结");
					$("#dongjie").html("解冻");
				}
				else if (zhuangtai == "冻结") {
					$("#zhuangtai").html("正常");
					$("#dongjie").html("冻结");
				}
			}
			,error: function(XMLHttpRequest, textStatus, errorThrown){
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
			}
		})
	}
</script>
<body>
	<%
		int count = reclist.size();
		for (int i = 0; i < count; i++) {
			User user = reclist.get(i);
			String dongjie = "";
			String caozuo = "";
			if (user.getBlocked() == 0) {
				dongjie = "正常";
				caozuo = "冻结";
			}
			else if (user.getBlocked() == 1) {
				dongjie = "冻结";
				caozuo = "解冻";
			}
	%>		
			<div class="table_big">
				<div>
					<label class="td_header_name">用户昵称：</label>
					<label class="td_name"><%=user.getName()%></label>
					<label class="td_header_pwd">用户密码：</label>
					<label class="td_pwd"><%=user.getPwd()%></label>
					<label class="td_header_zhuangtai">用户状态：</label>
					<label class="td_zhuangtai" id="zhuangtai"><%=dongjie%></label>
					<button type="button" onclick="Dongjie(<%=user.getId()%>);" class="layui-btn layui-btn-normal" id="dongjie"><%=caozuo%></button>
				</div>
				<div>
					<label class="td_header_truename">真实姓名：</label>
					<label class="td_truename"><%=user.getTrueName()%></label>
					<label class="td_header_email">E-Mail：</label>
					<label class="td_email"><%=user.getEmail()%></label>
					<label class="td_header_tel">联系电话：</label>
					<label class="td_tel"><%=user.getTel()%></label>
					<label class="td_header_qq">QQ号码：</label>
					<label class="td_qq"><%=user.getQq()%></label>
				</div>
				<div>
					<label class="td_header_tishi">密码提示问题：</label>
					<label class="td_tishi"><%=user.getSecurityQuestion()%></label>
					<label class="td_header_huida">密码提示答案：</label>
					<label class="td_huida"><%=user.getSecurityAnswer()%></label>
				</div>
			</div>
			<div>
				<table width="100%">
					<tr>
						<td align="center"><button type="button" class="layui-btn layui-btn-danger" OnClick="UserDelete(<%=user.getId()%>)">删除该用户</button></td>
					</tr>
				</table>
			</div>
	<%
		}
	%>
	<script>
			function UserDelete(id) {
				var flag = 0;
				if (confirm("确认要删除该用户吗？")) {
					flag = 1;
				}
				if (flag == 1) {
					window.location.href = "<%=path%>/UsersDeleteAction.action?id=" + id;
				}
			}
	</script>
</body>
</html>