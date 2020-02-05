<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.Aishopssh.Entites.*,java.text.DecimalFormat"%>
<%@ page import="com.Aishopssh.Entites.Cartlist" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车查看</title>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css.map">

<%	String path=request.getContextPath(); %>
<link rel="stylesheet" href="<%=path %>/css/bootstrap-theme.css">
<link rel="stylesheet" href="<%=path %>/css/bootstrap-theme.css.map">
<link rel="stylesheet" href="<%=path %>/css/bootstrap-theme.css.map">
<link rel="stylesheet" href="<%=path %>/css/bootstrap-theme.min.css.map">
<link rel="stylesheet" href="<%=path %>/css/bootstrap.css">
<link rel="stylesheet" href="<%=path %>/css/bootstrap.css.map">
<link rel="stylesheet" href="<%=path %>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=path %>/css/bootstrap.min.css.map">

<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" type="text/css">

<script src="<%=path %>/js/bootstrap.js"></script>
<script src="<%=path %>/js/bootstrap.min.js"></script>
<script src="<%=path %>/js/npm.js"></script>

<style>
.num{
	width:20px;
	text-align:center;
}
.divs{ 
	width:100%; 
	height:600px; 
	FILTER: progid:DXImageTransform.Microsoft.Gradient(gradientType=0,startColorStr='#15A216',endColorStr='#fafafa'); /*IE*/
	background:-moz-linear-gradient(top,#15A216,#fafafa);/*火狐*/ 
	background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(#CCEEFF), to(#FFFFFF));/*谷歌*/ 
 
	background-image: -webkit-gradient(linear,left bottom,left top,color-start(0, #CCEEFF),color-stop(1, #FFFFFF));/* Safari & Chrome*/
	filter:  progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#15A216', endColorstr='#fafafa'); /*IE6 & IE7*/
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#15A216', endColorstr='#fafafa')"; /* IE8 */
	}
	.table td{
		text-align:center;	
	}
	input {
		border:none;
	}
</style>

</head>

<body>

<div class="page-header" style="background:#00BBFF;margin-top:-20px;height:80px">
  <h1 style="line-height:80px">欢迎您！<small id="uname"></small></h1>
</div>

<div class="row"  style="background:#00BBFF;height:60px;margin-top:-19px">
  <div class="col-md-2" style="color:#121212;margin-top:20px;text-align:center">极享购物</div>
  <div class="col-md-2" style="color:#121212;margin-top:20px;text-align:center">满载而归</div>
  <div class="col-md-2" style="color:#121212;margin-top:20px;text-align:center">物有所值</div>
  <div class="col-md-2" style="color:#121212;margin-top:20px;text-align:center">琳琅满目</div>
  <div class="col-md-2" style="color:#121212;margin-top:20px;text-align:center">应有尽有</div>
  <div class="col-md-2" style="color:#121212;margin-top:20px;text-align:center">敬请享受</div>
  
</div>

<div class="divs" style="margin-top:10px">
<div class="page-header" style="margin-top:-17px;height:40px;margin-bottom:60px;">
  <h2 style="margin-left:240px;">Shopping Bag</h2>
  
  <small style="margin-left:240px;margin-top:-10px;">@please enjoy your shopping and do something you want to</small>

</div>
	<table class="table table-hover" style="width:850px;margin:0 auto;">
 	 <tr><td style="font-size:20px;height:20px;line-height:20px;">商品名称</td><td style="font-size:20px;">数量</td><td style="font-size:20px;">市场价</td><td style="font-size:20px;">会员价</td><td style="font-size:20px;">折扣</td>
 	 <td style="font-size:20px;">小计 </td><td style="font-size:20px;">操作</td></tr>

 	
 	<%
 		ArrayList<Cartlist> CartList = (ArrayList<Cartlist>)session.getAttribute("CartList");
 		DecimalFormat op = new DecimalFormat("0.00");
 		int tolfg = 0;
 		if(CartList.size() == 0){
 			out.print("<tr>");
 			out.print("<td colspan='7'>暂无商品</td>");
 			out.print("</tr>");
 		}else{
 			tolfg = 1;
			for(int i = 0; i < CartList.size(); i++){
	 %>
		 <tr>
			 <td style="height:40px;line-height:20px;"><%=CartList.get(i).getTbGoodsByGoodsId().getName() %></td>
			 <td>
  					<button type="button" class="btn btn-default btn-sm" onclick="changeNum(1, <%=i%>, <%=CartList.get(i).getTbGoodsByGoodsId().getId()%>)">-</button>
 						<input type="text" value="<%=CartList.get(i).getGoodsNum()%>" class="num" id="<%=i %>"/>
  					<button type="button" class="btn btn-default btn-sm" onclick="changeNum(2, <%=i%>, <%=CartList.get(i).getTbGoodsByGoodsId().getId()%>)">+</button>
			 </td>
			 <td><%=CartList.get(i).getTbGoodsByGoodsId().getMemberPrice() %></td>
			 <td><%=CartList.get(i).getTbGoodsByGoodsId().getMarketPirce() %></td>
			 <td><%=op.format(Integer.parseInt(CartList.get(i).getTbGoodsByGoodsId().getMemberPrice()) * 1.0 / Integer.parseInt(CartList.get(i).getTbGoodsByGoodsId().getMarketPirce()))%></td>
			 <td><%=CartList.get(i).getTbGoodsByGoodsId().getMemberPrice()%></td>
			 <td><button class="btn btn-default" type="button" onclick="DelOneOrder(<%=CartList.get(i).getOrderNum()%>, <%=i%>)">删除</button></td>
		 </tr> 	
	<%
			} 
		}
 	 %>
	</table>
	<hr/>
	<div>
		<a class="btn btn-default" role="button" style="margin-left:260px" onclick="ToBuy()">去收银台</a>
		<button class="btn btn-default" type="button" onclick="DelAll()">清空购物车</button>
		<a class="btn btn-default" role="button" href="<%=path %>/index2.jsp">返回个人中心</a>
		<a class="btn btn-default" role="button" href="<%=path %>/NewWelcome.jsp">返回首页</a>
	</div>
	
	<div style="float:right;margin-top:-20px;margin-right:100px">
	<table>
	<tr><td style="color:#8080C0">总价：</td><td id="ct"></td></tr>
	</table>
	</div>
	
	
	<div style="margin-top:100px;background:#CCEEFF;height:100px">
		
		
		<div style="color:white;text-align:center">@enjoy your shopping and pick up things carefully</div>
		<br>
		<div style="color:white;text-align:center">You can choose anything you want</div>
		
	
	</div>
</div>
<script>
var totalm = 0;
function DelAll(){
	if("${sessionScope.CartList.size()}" != "0"){
		var r=confirm("确定要清空吗？");
		if(r == true){
			$.ajax({
				url:"${pageContext.request.contextPath}/DelAllCart.action",
				dataTpye:"text",
				type:"get",
				success:function(ts){
					if(ts == "ok"){
						$(".table-hover").find("tr").each(function(){
							if($(this).index() > 0){
								$(this).remove();
							}
						});
						$("#ct").html("0");
					}else if(ts == "notok"){
						console.log("清空失败！");
					}
				}
			});
		}
	}else{
		alert("购物车为空！");
	}
}
function LoginName(){
	var uid = "${sessionScope.id}";
	var stitle = "";
	var sul = "";
	if(uid == ""){
		stitle += '欢迎来到爱购物！<a href="${pageContext.request.contextPath}/index.jsp">请登录</a>';
		$(".Tophead-title").html(stitle);
	}else{
		$(".Tophead-title").html("");
		$.ajax({
			url:"${pageContext.request.contextPath}/GetUserNameById.action?id=" + uid,
			cache:false,
			async:false,
			dataType:"text",
			type:"post",
			success:function(rs){
				stitle += '欢迎来到爱购物！   ' + rs;
				$(".Tophead-title").html(stitle);
				sul = $(".Tophead-ul-op").html();
				sul += '<li><a onclick="ToCartList()" style="cursor:pointer">购物车</a></li>';
				sul += '<li><a href="${pageContext.request.contextPath}/index2.jsp">个人中心</a></li>';
				$(".Tophead-ul-op").html(sul);
			}
		});
	}
}
function DelOneOrder(ind, row){
	$.ajax({
		url:"${pageContext.request.contextPath}/carlistdelone.action?id="+ind,
		dataType:"text",
		type: "GET",
		success:function(data){
			console.log("异步成功");
			var idx = 0;
			if(data == "ok"){
				$(".table-hover tr").eq(row + 1).remove();
			}
		},
		error:function(){
			alert("异步请求失败！");
		}
	});
}
function changeNum(fg, ix, spid){
	if(fg == 1){
		$("input").each(function(){
			if($(this).attr("id") == ix){
				var i = parseInt($(this).val());
				if(i > 1){
					i = i - 1;
					$(this).val(i);
					DataOption(i, spid);
					zongjia();
					xiaoji(ix);
				}
			}
		});
	}
	if(fg == 2){
		$("input").each(function(){
			if($(this).attr("id") == ix){
				var j = parseInt($(this).val());
				j = j + 1;
				$(this).val(j);
				DataOption(j, spid);
				zongjia();
				xiaoji(ix);
			}
		});
	}
}
function DataOption(num, spid){
	$.ajax({
		url:"<%=path%>/ModCartSpNum.action?num=" + num + "&spid=" + spid,
		type: "GET",
		dataType: "text",
		success:function(data){
			if(data == "ok"){
				console.log("ok");
			}else if(data == "notok") {
				concole.log("notok");
			}
		},
		error:function(){
			alert("异步请求失败！");
		}
	});
}
$(function(){
	zongjia();
	LoginName();
});
function zongjia(){
	$("#ct").html("");
	var zongjia = 0;
	if("${sessionScope.CartList.size()}" != "0"){
		$(".table-hover").find("tr").each(function(){
			if($(this).index() > 0){
				var tdArr = $(this).children();
				var n = parseInt(tdArr.eq(1).find('input').val());
				var cost = parseInt(tdArr.eq(3).html());
				zongjia = zongjia + n * cost;
			}
		});
		totalm = zongjia;
		var str = "<span>" + zongjia + "</span>";
		$("#ct").html(str);
	}else{
		$("#ct").html("0");
	}
}
function xiaoji(ix){
	var xj = 0;
	$(".table-hover").find("tr").each(function(){
		if($(this).index() > 0){
			var td = $(this).children();
			var m = parseInt(td.eq(1).find('input').val());
			var co = parseInt(td.eq(3).html());
			xj = m * co;
			var s = "<span>" + xj + "</span>";
			td.eq(5).html(s);
		}
	});
}
function ToBuy(){
	if("${sessionScope.CartList.size()}" != "0"){
		window.location.href="<%=path%>/cart/clearcart.jsp?totalm=" + totalm;
	}else{
		alert("购物车为空！");
	}
}
</script>
</body>
</html>