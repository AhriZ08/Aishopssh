<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>商品搜索结果</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/NewCommon.css" type="text/css">
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Top.css" type="text/css">
<style type="text/css">
.MiddleShopList{
	margin:0px auto;
	width:1000px;
	height:500px;
	margin-top:25px;
}
.MiddleShopList-Top{
	height:80px;
	position:relative;
	width:670px;
	margin:0px auto;
}
.MiddleShopList-Top-title{
	font-size:30px;
	line-height:80px;
	margin-left:10px;
}
.MiddleShopList-Top-Search{
	position:relative;
	top:-6px;
	margin-left:30px;
}
.MiddleShopList-Top-icon{
	position:absolute;
	line-height:80px;
	left:560px;
	cursor:pointer;
}
.MiddleShopList-Middle{

}
.MiddleShopList-HighLvSearch{
	display:inline;
	width:35px;
	height:35px;
	margin-left:5px;
	position:absolute;
	top:23px;
	text-align:center;
}
.MiddleShopList-HighLvSearch span{
	font-size:12px;
	color:#c2c2c2;
	cursor:pointer;
}
.High-Search-Pop{
	width:500px;
	height:250px;
	padding:10px;
	padding-top:30px;
	margin:0px auto;
}	
.OneShop{
	position:relative;
	text-align:center;
	width:300px;
	height:310px;
}
.OneShop img{
	width:300px;
	height:260px;
}
.OneShop-bottom{
	width:100px;
	height:33px;
	margin:0px auto;
	margin-top:6px;
}
.OneShop-bottom-icon{
	position:absolute;
	left:111px;
	bottom:10px;
	cursor:pointer;
}
.imgpointer{
	cursor:pointer;
}
.OneShop-bottom-icon2{
	position:absolute;
	left:155px;
	bottom:10px;
	cursor:pointer;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js" charset="utf-8"></script>
<script>
function ToCartList(){
	var uid = "${sessionScope.id}";
	if(uid == ""){
		layer.alert("请先登录！", {icon: 7});
	}else{
		window.location.href="${pageContext.request.contextPath}/cartlistAction";
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
layui.use('util', function(){
	var util = layui.util;
	util.fixbar({
		bar1:'<i class="layui-icon layui-icon-cart" style="font-size: 30px;"></i>',
		css: "{bottom:200px}",
		click: function(type){
			if(type == "bar1") {
				ToCartList();
			}
		}
	});
});
function spcartadd(id){
	var uid = "${sessionScope.id}";
	if(uid == ""){
		layer.alert("请先登录！", {icon: 7});
	}else{
		$.ajax({
			url: "${pageContext.request.contextPath}/SpCartAdd.action?id="+id,
			data:{"uid":uid},
			cache:false,
			dataType:"text",
			success:function(data){
				if(data == "success"){
					layer.msg("添加成功！");
				}else if(data == "failed") {
					layer.msg("添加购物车失败！");
				}else if(data == "NoAdd") {
					layer.msg("请勿重复添加购物车！");
				}
			}
		})
	}
}
function highsearch(){
	var data = $("#highform").serialize();
	$.ajax({
		url: "${pageContext.request.contextPath}/GetHighSearchRs.action",
		data: data,
		type: "post",
		cache: false,
		dataType: "text",
		success: function(rst){
			if(rst == "OK"){
				window.location.href="${pageContext.request.contextPath}/ShopSearchList.jsp";
			}else if(rst == "NO"){
				layer.msg("暂无搜索结果！", {icon:0});
			}
		}
	});
}
layui.use('layer', function(){
	  var layer = layui.layer;
});
layui.use('form',function(){
	var form = layui.form;
	form.on('submit(formDemoHS)', function(com){
		highsearch();
	});
});
function detail(id){
	var url = "GetOneShop.action?id=" + id;
	window.open(url);
}
layui.use('element', function(){
	var element = layui.element;
	init();
});
function init(){
	var str = "";
	var ct = 0;
	var fg = 0;
	$.ajax({
		url: "${pageContext.request.contextPath}/GetSchInitData.action",
		type:"post",
		cache: false,
		dataType: "json",
		success: function(obj){
			$.each(obj, function(index, item){
				if(ct % 3 == 0){
					str += "<div class='layui-row layui-col-space20'>";
				}
				str += "<div class='layui-col-lg4'>";
				str += "<div class='OneShop NoMagPad'>";
				str += "<img src='${pageContext.request.contextPath}" + item.picture + "' onclick='detail(" + item.id + ")' style='cursor:pointer;'/>"
				str += "<div class='OneShop-bottom NoMagPad'>";
				str += "<span>" + item.name + "</span><br/>";
				str += "<span style='color:#B5B5B5'>$" + item.memberPrice + "</span>";
				str += "</div>";
				str += "<div class='OneShop-bottom-icon'><i class='layui-icon layui-icon-cart-simple' style='font-size:30px;' onclick='spcartadd(" + item.id + ")'></i></div>";
				str += "<div class='OneShop-bottom-icon2'><i class='layui-icon layui-icon-about' style='font-size:30px;' onclick='detail(" + item.id + ")' class='imgpointer'></i></div>";
				str += "</div>";
				str += "</div>";
				if(ct % 3 == 2){
					str += "</div>";
				}
				fg = ct;
				ct++;
			});
			if(fg % 3 != 2){
				str += "</div>";
			}
			str += "</div>";
			$(".layui-tab-item").html(str);
			layui.element.render('tab','Shop-tab');
			$(".OneShop-bottom-icon").hide();
			$(".OneShop-bottom-icon2").hide();
			$(".OneShop").hover(function(){
					$(this).find(".OneShop-bottom").stop().slideToggle();
					$(this).find(".OneShop-bottom-icon").stop().slideToggle();
					$(this).find(".OneShop-bottom-icon2").stop().slideToggle();
				},function(){
					$(this).find(".OneShop-bottom-icon").stop().slideToggle();
					$(this).find(".OneShop-bottom-icon2").stop().slideToggle();
					$(this).find(".OneShop-bottom").stop().slideToggle();
				}
			);
		}
	});
}
$(function(){
	$('#High-Search').hide();
	$(".MiddleShopList-HighLvSearch span").click(function(){
		layer.open({
		      type: 1,
		      area:['600px','410px'],
		      title:'商品高级查找',
		      shadeClose: true, //点击遮罩关闭
		      content: $('#High-Search'),
		      resize: false,
		      move: false,
		      scrollbar: false
		    });
	});
	$("#icon-search").click(function(){
		var data = $("#input-search").val();
		if(data == null || data == ""){
			layer.msg('请输入搜索信息！', {icon:0});
		}else{
			$.ajax({
				url: "${pageContext.request.contextPath}/GetPubSearchRs.action",
				data:{"data":data},
				type:"post",
				cache: false,
				dataType: "text",
				success: function(obj){
					if(obj == "OK"){
						window.location.href="ShopSearchList.jsp";
					}else{
						layer.msg("无匹配商品！", {icon:0});
					}
				}
			});
		}
	});
	LoginName();
});
</script>
</head>
<body>
<div class="layui-bg-gray Tophead NoMagPad" style="position:fixed;z-index:2;">
	<span class="Tophead-title"></span>
	<ul class="Tophead-ul-op">
		<li><a href="${pageContext.request.contextPath}/NewWelcome.jsp">返回首页</a></li>
	</ul>
</div>
<div class="main" style="z-index:1">

	<div class="NoMagPad MiddleShopList">
	
		<div class="MiddleShopList-Top">
			<span class="MiddleShopList-Top-title">爱购物</span>
			<div class="layui-inline MiddleShopList-Top-Search">
				<input type="text" placeholder="请输入商品搜索信息" autocomplete="off" class="layui-input" style="width:450px;"/>
			</div>
			<i class="layui-icon layui-icon-search MiddleShopList-Top-icon"></i>
			<div class="MiddleShopList-HighLvSearch">
				<span>高级搜索</span>
			</div>
		</div>
		
		<div class="MiddleShopList-Middle">
			<div class="layui-tab layui-tab-card">
				<ul class="layui-tab-title">
					<li class="layui-this">综合排序</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show"></div>
				</div>
			</div>
		</div>	
			
	</div>
	
</div>
<div class="High-Search-Pop" id="High-Search">
	<form class="layui-form" action="">
	
		<div class="layui-form-item">
			<label class="layui-form-label">商品名称：</label>
			<div class="layui-input-block">
				<input type="text" name="shopname" required lay-verify="required" placeholder="请输入商品名称" autocomplete="off" class="layui-input"/>
			</div>
		</div>
		
		<div class="layui-form-item">	
			<div class="layui-input-block">
				<input type="checkbox" name="shopdimsh" title="模糊查找" lay-skin="primary" value="0" checked>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">会员价格：</label>		
				<div class="layui-input-inline" style="width: 80px;">
					<input type="text" name="price_min" placeholder="¥"  autocomplete="off" class="layui-input"/>
				</div>
				<div class="layui-form-mid">-</div>
				<div class="layui-input-inline" style="width: 80px;">
					<input type="text" name="price_max" placeholder="¥" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">商品类别：</label>		
			<div class="layui-input-block">
				<select name="shoptype" lay-verify="required">
					<option value="0" selected>服装内衣</option>
        			<option value="1">服装男装</option>
        			<option value="2">服装女装</option>
				</select>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div style="text-align:center">
				<button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemoHS" style="margin-top:20px;" type="button">立即搜索</button>
			</div>
		</div>
	</form>
</div>
</body>
</html>