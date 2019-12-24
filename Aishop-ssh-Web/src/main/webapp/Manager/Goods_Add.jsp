<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%@ page import="com.Aishopssh.Dao.ManagerDao.ManageGoodsDao" %>
<%@ page import="com.Aishopssh.Entites.Type1" %>
<%@ page import="com.Aishopssh.Entites.Type2" %>
<%@ page import="com.Aishopssh.Entites.Type3" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String path = request.getContextPath();
	ManageGoodsDao beanDB = new ManageGoodsDao();
	List<Type1> type1list = beanDB.GetAllType1();
	List<Type2> type2list = beanDB.GetAllType2();
	List<Type3> type3list = beanDB.GetAllType3();
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
		form.on('select(type1)', function(data){
			var type1id = data.value;
			var ss = "";
			$.ajax({
				url:"<%=path%>/FindType2Action.action?type1id=" + type1id
				,type:"post"
				,dataType:"json"
				,success:function(data) {
					$("#Type2").html("");
					ss += '<option value="" selected>请选择一个类别</option>';
					$.each(data, function(i, list){
						ss += '<option value="' + list.id + '">' + list.typename + '</option>';
					});
				$("#Type2").html(ss);
				layui.form.render();
				}
			});
		});
		form.on('select(type2)', function(data){
			var type2id = data.value;
			var ss = "";
			$.ajax({
				url:"<%=path%>/FindType3Action.action?type2id=" + type2id
				,type:"post"
				,dataType:"json"
				,success:function(data) {
					$("#Type3").html("");
					ss += '<option value="" selected>请选择一个类别</option>';
					$.each(data, function(i, list){
						ss += '<option value="' + list.id + '">' + list.typename + '</option>';
					});
				$("#Type3").html(ss);
				layui.form.render();
				}
			});
		});
	});
	layui.use('upload', function(){
		var $ = layui.jquery
		var upload = layui.upload;
		var uploadInst = upload.render({
			elem: '#uploadpic'
		    ,url: '<%=path%>/UploadAction.action'
		    ,before: function(obj){
				obj.preview(function(index, file, result){
		        $('#tupian_entity').attr('src', result);
			});
		    }
			,done: function(res){
				if(res.code > 0){
					return layer.msg('上传失败');
				}
				if (res.code == 0){
					var filename = res.filename;
					filename = "/images/" + filename;
					$("#tupian").attr("value", filename);
				}
		    }
		    ,error: function(){			    
				var demoText = $('#demoText');
				demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
				demoText.find('.demo-reload').on('click', function(){
					uploadInst.upload();
				});
		    }
		})
	});
</script>
<body>
<%
	int type1count = type1list.size();
%>
	<form class="layui-form" method="post" action="<%=path%>/GoodsInsertAction.action">
		<div class="layui-form-item">
			<label class="layui-form-label">商品名称：</label>
			<div class="layui-input-block">
      			<input type="text" name="mingcheng" required  lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input" value="">
    		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">上市时间：</label>
			<div class="layui-input-block">
      			<input type="text" name="addtime" required  lay-verify="required" placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input" value="">
    		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">市场价：</label>
			<div class="layui-input-block">
      			<input type="text" name="shichangjia" required  lay-verify="required|number" placeholder="请输入市场价" autocomplete="off" class="layui-input" value="">
    		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">会员价：</label>
			<div class="layui-input-block">
      			<input type="text" name="huiyuanjia" required  lay-verify="required|number" placeholder="请输入会员价" autocomplete="off" class="layui-input" value="">
    		</div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label">类别：</label>
			<div class="layui-input-block">
				<select name="type1" lay-verify="required" id="Type1" lay-filter="type1">
			    	<option value="">请选择一个类别</option>
			        <%
			        	for (int i = 0; i < type1count; i++) {
			        		Type1 Retype1 = type1list.get(i);%>
			        		<option value="<%=Retype1.getId()%>"<%
			        		%>><%=Retype1.getTypeName()%></option>
			        	<%}
			        %>
				</select>
			</div>
  		</div>
  		<div class="layui-form-item">
		    <label class="layui-form-label"></label>
			<div class="layui-input-block">
				<select name="type2" lay-verify="required" id="Type2" lay-filter="type2">
			    	<option value="">请选择一个类别</option>
				</select>
			</div>
  		</div>
  		<div class="layui-form-item">
		    <label class="layui-form-label"></label>
			<div class="layui-input-block">
				<select name="type3" lay-verify="required" id="Type3" lay-filter="type3">
			    	<option value="">请选择一个类别</option>
				</select>
			</div>
  		</div>
  		<div class="layui-form-item">
			<label class="layui-form-label">等级：</label>
			<div class="layui-input-block">
      			<input type="text" name="dengji" required  lay-verify="required" placeholder="请输入等级" autocomplete="off" class="layui-input" value="">
    		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">品牌：</label>
			<div class="layui-input-block">
      			<input type="text" name="pinpai" required  lay-verify="required" placeholder="请输入品牌" autocomplete="off" class="layui-input" value="">
    		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">型号：</label>
			<div class="layui-input-block">
      			<input type="text" name="xinghao" required  lay-verify="required" placeholder="请输入型号" autocomplete="off" class="layui-input" value="">
    		</div>
		</div>
		<div class="layui-form-item">
    		<label class="layui-form-label">是否推荐：</label>
    		<div class="layui-input-block">
      			<input type="radio" name="tuijian" value="1" title="是" checked>
      			<input type="radio" name="tuijian" value="0" title="否">
    		</div>
  		</div>
  		<div class="layui-form-item">
			<label class="layui-form-label">总数量：</label>
			<div class="layui-input-block">
      			<input type="text" name="shuliang" required  lay-verify="required|number" placeholder="请输入新的商品总数" autocomplete="off" class="layui-input" value="">
    		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">已售出：</label>
			<div class="layui-input-block">
      			<input type="text" name="cishu" required  lay-verify="required|number" placeholder="请输入已售出的数量" autocomplete="off" class="layui-input" value="">
    		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">简介：</label>
			<div class="layui-input-block">
      			<input type="text" name="jianjie" required  lay-verify="required" placeholder="请输入简介" autocomplete="off" class="layui-input" value="">
    		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">图片：</label>
			<div class="layui-input-block">
				<label>
					<input type="hidden" name="tupian" required  lay-verify="required" autocomplete="off" class="layui-input" value="" id="tupian">
					<button type="button" class="layui-btn" id="uploadpic">上传图片</button>
					<div>
						<img class="td_tupian" id="tupian_entity" src="">
      				<p id="demoText"></p>
					</div>
      			</label>	
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