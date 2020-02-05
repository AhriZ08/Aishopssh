<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>商品信息</title>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/NewCommon.css" type="text/css">
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
.MiddleShopList-Detail{
	width:100%;
	height:1150px;
	border:1px solid #dddddd;
}
.Detail-img{
	width:450px;
	height:400px;
	margin-top:20px;
	margin-left:20px;
}
.Detail-Info{
	display:inline;
	width:480px;
	height:400px;
	margin-top:20px;
	margin-right:30px;
	float:right;
}
.Detail-price{
	font-size:25px;
	color:#1C86EE;
}
.Detail-bottom{
	width:200px;
	margin:0px auto;
	margin-top:50px;
}
.Detail-comment{
	width:100%;
	height:200px;
	margin-top:40px;
}
.Detail-comment-form{
	width:800px;
	margin:0px auto;
	margin-top:50px;
}
.Detail-comment-one{
	width:100%;
	height:150px;
	border-bottom:1px solid #e2e2e2;
	position:relative;
}
.Detail-comment-one-left{
	float:left;
	width:80px;
	height:20px;
	text-align:center;
	border:1px solid #EEEEEE;
	margin-top:20px;
	margin-left:20px;
}
.Detail-comment-one-content{
	float:right;
	width:830px;
	height:100px;
	margin-top:20px;
	margin-right:20px;
}
.Detail-comment-one-day{
	position:absolute;
	bottom:3px;
	left:127px;
}
.page{
	width:500px;
	margin:0px auto;
	text-align:center;
	margin-top:20px;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js" charset="utf-8"></script>
<script>
var count = 0;
var curr = 1;
var limit = 3;
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
function toPage(){
	layui.use('laypage', function(){
		var laypage = layui.laypage;
		laypage.render({
			elem:'page',
			count: count,
			limit:limit,
			theme: '#1E9FFF',
			prev: '上一页',
			next: '下一页',
			jump: function(obj, first){
				curr = obj.curr;
				getData();
			}
		})
	});
}
function getData(){
	$.ajax({
		url:"${pageContext.request.contextPath}/GetAllShopCom.action?id=" + "${sessionScope.sp.getId()}",
		type: "post",
		data: {"curr" : curr},
		async:false,
		cache: false,
		dataType: "json",
		success: function(obj){
			var str = "";
			count = obj.total;
			$("#Detail-comment-all").html("");
			if(obj.total == 0){
				str += "<span style='margin-left:20px;margin-top:20px;'>暂无评论</span>";
			}else{
				$.each(obj.data, function(index, item){
					str += '<div class="Detail-comment-one">';
					str += '<div class="Detail-comment-one-left">'; 
					str += '<span style="line-height:20px;">' + item.username + '</span>';
					str += '</div>';
					str += '<div class="Detail-comment-one-content">';
					str += '<span style="font-size:20px;">' + item.title + '</span><br/>';
					str += '<span>' + item.content + '</span>';	
					str += '</div>';
					str += '<span class="Detail-comment-one-day">' + item.time + '</span>';
					str += '</div>';
				});
			}
			$("#Detail-comment-all").html(str);
		},
		error: function(){
			alert("异步请求失败！");
		}
	});	
}
layui.use('layer', function(){
	  var layer = layui.layer;
});
layui.use('form',function(){
	var form = layui.form;
	form.on('submit(formDemo)', function(com){
		var uid = "${sessionScope.id}";
		if(uid == ""){
			layer.alert("请先登录！", {icon: 7});
		}else{
			$.ajax({
				url: "AddComment.action?gid=" + "${sessionScope.sp.getId()}",
				data:com.field,
				type:"POST",
				dataType: "text",
				cache:false,
				success:function(rs){
					if(rs == "ok") {
						layer.alert("发表成功", {icon:1});
					}else if(rs == "failed") {
						layer.alert("发表失败", {icon:2});
					}
					$("#com-title").val("");
					$("#com-content").val("");
				}
			});
		}
	});
	form.on('submit(formDemoHS)', function(c){
		highsearch();
	});
});
layui.use('element',function(){
	var element = layui.element;
	element.on('tab(Detail-tab)',function(data){
		if(data.index == 1){
			getData();
			if(count > 3) {
				toPage();
			}
		}
	});
});
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
	LoginName();
});
</script>
</head>


<body>
<div class="layui-bg-gray Tophead NoMagPad" style="position:fixed;z-index:2;">
	<span class="Tophead-title">欢迎来到爱购物！<a href="">请登录</a></span>
	<ul class="Tophead-ul-op">
		<li><a href="${pageContext.request.contextPath}/NewWelcome.jsp">返回首页</a></li>
	</ul>
</div>
<div class="main" style="z-index:1;">
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
		
		<div class="MiddleShopList-Detail">
			<img class="Detail-img" src="${pageContext.request.contextPath}${sessionScope.sp.getPicture()}"/>
			<div class="Detail-Info">
				<table class="layui-table" lay-skin="nob">
					<colgroup>
						<col width="100">
						<col width="250">
					</colgroup>
					<tbody>
						<tr>
							<td colspan="2" style="font-size:25px;font-family:NSimSun;">${sessionScope.sp.getName()}</td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td>入市时间</td>
							<td style="font-size:20px;">${sessionScope.sp.getAddtime()}</td>
						</tr>
						<tr>
							<td>会员价</td>
							<td><span class="Detail-price">${sessionScope.sp.getMemberPrice()}</span></td>
						</tr>
						<tr>
							<td>市场价</td>
							<td><span class="Detail-price">${sessionScope.sp.getMarketPirce()}</span></td>
						</tr>
						<tr>
							<td>等级</td>
							<td style="font-size:20px;">${sessionScope.sp.getLevel()}</td>
						</tr>
						<tr>
							<td>品牌</td>
							<td style="font-size:20px;">${sessionScope.sp.getBrand()}</td>
						</tr>
						<tr>
							<td>数量</td>
							<td style="font-size:20px;">${sessionScope.sp.getNum()}</td>
						</tr>
						<tr>
							<td rowspan="2">简介</td>
							<td>${sessionScope.sp.getIntroduction()}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="Detail-bottom">
				<button class="layui-btn layui-btn-lg layui-btn-normal layui-btn-fluid" onclick="spcartadd(${sessionScope.sp.getId()})">加入购物车</button>
			</div>
			<div class="Detail-comment">
				<div class="layui-tab layui-tab-brief" lay-filter="Detail-tab">
					<ul class="layui-tab-title">
						<li class="layui-this">发表评论</li>
						<li>查看评论</li>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<div class="Detail-comment-form">
								<form class="layui-form" id="comform">
									<div class="layui-form-item">
										<label class="layui-form-label">评论主题</label>
										<div class="layui-input-block">
											<input type="text" name="comTitle" id="com-title" required  lay-verify="required" placeholder="请输入主题" autocomplete="off" class="layui-input"/>
										</div>
									</div>
									
									<div class="layui-form-item">
										<label class="layui-form-label">评论内容</label>
										<div class="layui-input-block">
											<textarea name="comContent" id="com-content" required lay-verify="required" class="layui-textarea"></textarea>
										</div>
									</div>
									
									<div class="layui-form-item" style="text-align:center;">
										<div class="layui-input-block">
											<button class="layui-btn" lay-submit lay-filter="formDemo" type="button">立即提交</button>
										</div>
									</div>
								</form>
							</div>
						</div>
						
						<div class="layui-tab-item">
								<div id="Detail-comment-all"></div>
								<div id="page" class="page"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>

<!-- 搜索弹窗 -->
<div class="High-Search-Pop" id="High-Search">
	<form class="layui-form" action="">
	
		<div class="layui-form-item">
			<label class="layui-form-label">商品名称：</label>
			<div class="layui-input-block">
				<input type="text" name="shopName" required lay-verify="required" placeholder="请输入商品名称" autocomplete="off" class="layui-input"/>
			</div>
		</div>
		
		<div class="layui-form-item">	
			<div class="layui-input-block">
				<input type="checkbox" name="shopDim" title="模糊查找" lay-skin="primary" value="0" checked>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">会员价格：</label>		
				<div class="layui-input-inline" style="width: 80px;">
					<input type="text" name="priceMin" placeholder="¥"  autocomplete="off" class="layui-input"/>
				</div>
				<div class="layui-form-mid">-</div>
				<div class="layui-input-inline" style="width: 80px;">
					<input type="text" name="priceMax" placeholder="¥" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">商品类别：</label>		
			<div class="layui-input-block">
				<select name="shopType" lay-verify="required">
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