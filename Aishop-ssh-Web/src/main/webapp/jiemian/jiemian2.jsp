<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.Aishopssh.*"%>
<%@ page import="com.Aishopssh.Dao.UserDao.UserannouncementDao" %>
<%@ page import="com.Aishopssh.Entites.Notice" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
%>
	<script src="<%=path %>/jquery/jquery-3.3.1.js"></script>
	<script type="text/javascript">
		$(function () {
			$.ajax({
				url:"<%=path%>/getNotice.action",
				success:function (rs) {
					$("#decoimg_a2").html("");
					var picC = 1;
					var str = "";
					$.each(rs, function (index, item) {
						str += "<div class=\"decoimg_b2\" id=\"d1\"><a href=\"http://sc.chinaz.com/\"><img src=\"<%=path%>/image/"+ picC +".jpg\"></a><p><h class=\"time\">";
						str += item.time;
						str += "</h>";
						str += item.title;
						str += "</br></br>";
						str += item.content + "</p></div>";
						picC++;
					});
					$("#deconum2").html("");
					var nexstr = "";
					$.each(rs, function (index, item) {
						nexstr += "<li><a href=\"javascript:void(0)\" hidefocus=\"true\" target=\"_self\" id=\"a1\">"+ item.title +"</a></li>";
					});
					$("#decoimg_a2").html(str);
					$("#deconum2").html(nexstr);
					console.log("ok");
				}
			})
		});
	</script>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/user.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	font-family: 楷体;
	background-image:url(images/背景1.png);
	background-color:#f1fbf1;
	background-position:50% 0%;
}

p{
line-height: 0.5;
width:100%; height:100%; border:1px;
font-family: 楷体;
font-size:30px;
}
.time{
font-size:18px;
}
</style>
</head>
<body>
<div id="gonggao" align="center">
<table align="left" border="0">
<tr>
<th>
<div id="decoroll2" class="imgfocus">

	<div id="decoimg_a2" class="imgbox">

	</div>
	
	<ul id="deconum2" class="num_a2">

	</ul>
</div>
</th></tr>
</table>
</div>

</body>

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