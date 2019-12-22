<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.Aishopssh.Entites.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>爱购物</title>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/NewCommon.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Top.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css" type="text/css">
<style type="text/css">
.ImageShowDiv{
	margin:0px auto;
}
.image{
	width:1500px;
	height:600px;
}
.shoplist{
	width:1400px;
	margin:0 auto;
	padding:5px;
	margin-top:10px;
}
.OneShop{
	position:relative;
	text-align:center;
	width:300px;
	height:310px;
	border:1px solid #EEEEEE;
}
.OneShop img{
	width:300px;
	height:260px;
}
.OneShop-bottom{
	width:200px;
	height:33px;
	margin:0px auto;
	margin-top:6px;
	cursor:pointer;
}
.OneShop-bottom-icon{
	position:absolute;
	left:111px;
	bottom:10px;
	cursor:pointer;
}
.OneShop-bottom-icon2{
	position:absolute;
	left:155px;
	bottom:10px;
	cursor:pointer;
}
.Bottom{
	width:500px;
	height:200px;
	position:relative;
	top:85px;
	margin:0px auto;
	bottom:0px;
}
.Bottom-title{
	width:250px;
	margin:0px auto;
	margin-top:20px;
	text-align:center;
}
.Bottom-Content{
	width:400px;
	margin-top:0px;
	margin:0px auto;
}
.High-Search-Pop{
	width:520px;
	height:260px;
	padding:10px;
	padding-top:30px;
	margin:0px auto;
}	
.imgpointer{
	cursor:pointer;
}
.shoplisttopage{
	width:450px;
	height:35px;
	text-align:center;
	margin:0px auto;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js" charset="utf-8"></script>
<script>
var currpage = 1;
var count = 0;
var tabidx = 1;
layui.use('element', function(){
	var element = layui.element;
	element.on('tab(Shop-tab)', function(data){
		$(".shoplisttopage").html("");
		currpage = 1;
		tabidx = data.index + 1;
		console.log("tabidx:" + tabidx);
		getspdata(tabidx);
		console.log("element count:" + count);
		if(count > 6) {
			ShoplisttoPage();
		}
	});
});
//取得商品信息
function getspdata(idx){
	$.ajax({
		url: "${pageContext.request.contextPath}/IndexShopList.action?idx=" + idx,
		type: "get",
		data: {"curr" : currpage},
		async: false,
		cache: false,
		dataType: "json",
		success: function(obj){
			var st = "";
			var ct = 0;
			var fg = 0;
			count = obj.total;
			$(".layui-tab-item").each(function(){
				if($(this).index() + 1 == idx) {
					st = "<div class='layui-container'>";
					ct = 0;
					fg = 0;
					$.each(obj.data, function(i, item){
						if(ct % 3 == 0){
							st += "<div class='layui-row layui-col-space15'>";
						}
						st += "<div class='layui-col-lg4'>";
						st += "<div class='OneShop NoMagPad'>";
						st += "<img src='${pageContext.request.contextPath}" + item.url + "' onclick='detail(" + item.id + ")' style='cursor:pointer;'/>";
						st += "<div class='OneShop-bottom NoMagPad'>";
						st += "<span>" + item.mingcheng + "</span><br/>"
						st += "<span style='color:#B5B5B5'>$" + item.huiyuanjia + "</span>";
						st += "</div>";
						st += "<div class='OneShop-bottom-icon'><i class='layui-icon layui-icon-cart-simple' style='font-size:30px;' onclick='spcartadd(" + item.id + ")'></i></div>";
						st += "<div class='OneShop-bottom-icon2'><i class='layui-icon layui-icon-about' style='font-size:30px;' onclick='detail(" + item.id + ")' class='imgpointer'></i></div>";
						st += "</div>";
						st += "</div>";
						if(ct % 3 == 2){
							st += "</div>";
						}
						fg = ct;
						ct++;
					});
					if(fg % 3 != 2){
						st += "</div>";
					}
					st += "</div>";
					$(this).html(st);
				}
			});
 			$(".OneShop-bottom-icon").hide();
 			$(".OneShop-bottom-icon2").hide();
			$(".OneShop").hover(function(){
/*					$(this).find(".OneShop-bottom-icon").stop().slideToggle();
					$(this).find(".OneShop-bottom-icon2").stop().slideToggle();*/
					$(this).find(".OneShop-bottom").removeClass("layui-anim-fadein").addClass("layui-anim layui-anim-fadeout");
				$(this).find(".OneShop-bottom-icon").removeClass("layui-anim-fadeout").stop().addClass("layui-anim layui-anim-fadein").show();
				$(this).find(".OneShop-bottom-icon2").removeClass("layui-anim-fadeout").addClass("layui-anim layui-anim-fadein").show();
				},function(){
/* 					$(this).find(".OneShop-bottom-icon").stop().slideToggle();
					$(this).find(".OneShop-bottom-icon2").stop().slideToggle();*/
					$(this).find(".OneShop-bottom").removeClass("layui-anim-fadeout").stop().addClass("layui-anim layui-anim-fadein").show();
					$(this).find(".OneShop-bottom-icon").removeClass("layui-anim-fadein").addClass("layui-anim layui-anim-fadeout");
					$(this).find(".OneShop-bottom-icon2").removeClass("layui-anim-fadein").addClass("layui-anim layui-anim-fadeout");
				}
			);
		},
		error:function(){
			alert("error");
		}
	});
	console.log("getdata count:" + count);
}
//首页商品分页
function ShoplisttoPage(){
	layui.use('laypage', function(){
		var laypage = layui.laypage;
		laypage.render({
			elem:'shoplisttopage',
			count: count,
			limit: 6,
			theme: '#1E9FFF',
			prev: '上一页',
			next: '下一页',
			jump: function(obj, first){
				if (!first) {
					currpage = obj.curr;
					getspdata(tabidx);
				}
			}
		})
	});
}
//跳转至我的购物车
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
	$(".Tophead-title").html("");
	$.ajax({
		url:"${pageContext.request.contextPath}/GetUserNameById?id=" + uid,
		cache:false,
		async:false,
		dataType:"text",
		type:"post",
		success:function(rs){
			if(rs != "-1"){
				stitle += '欢迎来到爱购物！   ' + rs;
				$(".Tophead-title").html(stitle);
				sul = $(".Tophead-ul-op").html();
				sul += '<li><a onclick="ToCartList()" style="cursor:pointer">购物车</a></li>';
				sul += '<li><a href="${pageContext.request.contextPath}/index2.jsp">个人中心</a></li>';
				$(".Tophead-ul-op").html(sul);
			}else{
				stitle += '欢迎来到爱购物！<a href="${pageContext.request.contextPath}/index.jsp">请登录</a>';
				$(".Tophead-title").html(stitle);
			}
		}
	});
}
//高级搜索功能
function highsearch(){
	var data = $("#highform").serialize();
	$.ajax({
		url: "${pageContext.request.contextPath}/GetSearchRs?flag=2",
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
//添加至购物车功能
function spcartadd(id){
	$.ajax({
		url: "${pageContext.request.contextPath}/SpCartAdd?id="+id,
		cache:false,
		dataType:"text",
		success:function(data){
			if(data == "NoUser") {
				layer.alert("请先登录！", {icon: 7});
			}else if(data == "success"){
				layer.msg("添加成功！");
			}else if(data == "failed") {
				layer.msg("添加购物车失败！");
			}else if(data == "NoAdd") {
				layer.msg("请勿重复添加购物车！");
			}
		}
	})
}
//获取广告信息
function InitAdv(){
	$.ajax({
		url: "${pageContext.request.contextPath}/GetAdvPic",
		type: "get",
		cache:false,
		dataType: "json",
		success:function(obj){
			$("#putimage").html("");
			var imgstr = "";
			$.each(obj,function(index, item){
				imgstr += '<div><img src="${pageContext.request.contextPath}' + item.url + '" class="image"/></div>';
			});
			$("#putimage").html(imgstr);
		},
		error:function(){
			alert("异步请求获取广告失败！");
		}
	})
}
function detail(id){
	var url = "GetOneShop?id=" + id;
	window.open(url);
}
var fl = 0;

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
layui.use('form',function(){
	var form = layui.form;
	form.on('submit(formDemoHS)', function(com){
		highsearch();
	});
})

layui.use('carousel', function(){
	var carousel = layui.carousel;
	//建造实例
	carousel.render({
		elem: '#imageshow'
		,width: '1500px' //设置容器宽度
		,height:'600px'
		,arrow: 'hover' //悬浮显示箭头
		,interval:'3000'
	});
});
layui.use('layer', function(){
	  var layer = layui.layer;
});
$(function(){
	$('#High-Search').hide();
	$(".Top-HighLvSearch span").click(function(){
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
				url: "${pageContext.request.contextPath}/GetSearchRs?flag=1",
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
	InitAdv();
	getspdata(tabidx);
	if(count > 6) {
		ShoplisttoPage();
	}
});
</script>
</head>
<body>
	<div class="layui-bg-gray Tophead NoMagPad" style="position:fixed;z-index:2;">
		<span class="Tophead-title"></span>
		<ul class="Tophead-ul-op">
			
		</ul>
	</div>
<div class="main" style="z-index:1;margin-top:25px;">
	<div class="Top">
		<span class="Top-title">爱购物</span>
		<div class="Top-Search">
			<input type="text" placeholder="请输入商品搜索信息" autocomplete="off" class="layui-input Top-Search-input" id="input-search">
		</div>	
		<i class="layui-icon layui-icon-search Top-Search-icon" id="icon-search"></i>
		<div class="Top-HighLvSearch">
			<span>高级搜索</span>
		</div>
	</div>
	<hr class="layui-bg-gray">
	<div class="NoMagPad">
		<div class="layui-carousel ImageShowDiv" id="imageshow">
			<div carousel-item id="putimage"></div>
		</div>
	</div>
	<div class="shoplist NoMagPad">
		<div class="layui-tab layui-tab-brief" lay-filter="Shop-tab">
		  <ul class="layui-tab-title Type-titel-ul">
		    <li class="layui-this">热门</li>
		    <li >推荐</li>
		  </ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
				暂无商品
				</div>
				<div class="layui-tab-item">
				暂无商品
				</div>
			</div>
		</div>
	</div>
	<div class="shoplisttopage" id="shoplisttopage"></div>
	<div class="Bottom">
		<div class="Bottom-title">
			<span class="layui-breadcrumb" lay-separator="|">
				<a href="">联系我们</a>
				<a href="">投诉举报</a>
				<a href="">意见反馈</a>
			</span>
		</div>
		<div class="Bottom-Content">
			<span class="layui-breadcrumb" lay-separator=" ">
				<a href="">©2019 版权归XXXX所有</a>
				<a href="">公众号</a>
				<a href="">关于爱购物</a>
				<a href="">填写文字</a>
			</span>
		</div>
	</div>
</div>

<div class="High-Search-Pop" id="High-Search">
	<form class="layui-form" id="highform">
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
				<select name="shoptype" lay-verify="required" style="max-height:200px;">
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