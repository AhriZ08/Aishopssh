<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车清空</title>

<%	String path=request.getContextPath(); %>
<link rel="stylesheet" href="<%=path %>/css/bootstrap-theme.css.">
<link rel="stylesheet" href="<%=path %>/css/bootstrap-theme.css.map">
<link rel="stylesheet" href="<%=path %>/css/bootstrap-theme.css.map">
<link rel="stylesheet" href="<%=path %>/css/bootstrap-theme.min.css.map">
<link rel="stylesheet" href="<%=path %>/css/bootstrap.css">
<link rel="stylesheet" href="<%=path %>/css/bootstrap.css.map">
<link rel="stylesheet" href="<%=path %>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=path %>/css/bootstrap.min.css.map">

<script src="<%=path %>/js/bootstrap.js"></script>
<script src="<%=path %>/js/bootstrap.min.js"></script>
<script src="<%=path %>/js/npm.js"></script>

<style>

	.div3{
			border:1px solid grey;
			background-color:#E9E9E9;
			opacity:0.7;
			color:black;
			width:1380px;
			margin-bottom:2px;
			eight:25px;
	}
	
</style>


</head>
<body>

<div class="div3">用户的订单填写</div>

<form id="frm" action = "#" method = "get">
			<table border="1" style="width:800px;height:600px">
			
				<tr >
				<td >收货人姓名</td><td><input type="text"></td>
				</tr>
				
				<tr>
				<td >收货地址</td>
				<td><input type="text" ></td>
				</tr>
				
				
				
				<tr>
				<td>邮政编码</td>
				<td><input type="text"></td>
				</tr>
				
				<tr>
				<td>联系电话</td>
				<td><input type="text" ></td>
				</tr>
				
				<tr><td><div class="dropdown">
  					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
   						时间
    					<span class="caret"></span>
  						</button>
  							<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    						<li><a href="#">Action</a></li>
    						<li><a href="#">Another action</a></li>
    						<li><a href="#">Something else here</a></li>
    						<li role="separator" class="divider"></li>
   							<li><a href="#">Separated link</a></li>
  							</ul>
					</div>
					</td>
					</tr>
				
				<tr><td><div class="dropdown">
  					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
   						支付方式
    					<span class="caret"></span>
  						</button>
  							<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    						<li><a href="#">Action</a></li>
    						<li><a href="#">Another action</a></li>
    						<li><a href="#">Something else here</a></li>
    						<li role="separator" class="divider"></li>
   							<li><a href="#">Separated link</a></li>
  							</ul>
					</div>
					</td>
					</tr>
				
				<tr>
				<td>备注</td>
				<td><textarea maxlength="200" name="courseliuyan"></textarea>200个字符以内</td>
				</tr>
				
				
			</table>
		</form>
		<button>提交订单</button>
				

</body>
</html>