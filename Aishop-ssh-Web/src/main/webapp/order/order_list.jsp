<%--
  Created by IntelliJ IDEA.
  User: ender
  Date: 2019-12-24
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.ArrayList,java.util.List"%>
<%@ page import="com.Aishopssh.Entites.Orders" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();

    ArrayList<Orders> reclist=(ArrayList<Orders>)session.getAttribute("order");
    session.removeAttribute("order");
    if(reclist==null){
        reclist=new ArrayList<Orders>();
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>订单管理</title>
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/common.css">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css" type="text/css">
    <script>
        function check1(){
            var x = document.forms["find"]["name"].value;
            var y = document.forms["find"]["ddh"].value;
            if((x==""||x==null)&&(y==""||y==null)){
                alert("请至少输入一项！");
                return false;
            }
        }
    </script>
</head>
<body>
<form name="find" method="post" onsubmit="return check1()" action="<%=path%>/getOrderByXN.action">
    <table width="1200" height="5" border="0" cellpadding="0"
           cellspacing="0" align="center" >
        <tr>
            <td >
                <input type="text" name="Xdr" placeholder="请输入姓名" >
                <input type="text" name="num" placeholder="请输入订单号">
                <input type = "submit" class="layui-btn layui-btn-primary layui-btn-xs" value = "查询"  >
            </td>



        </tr>
    </table>
</form>

<table width="1200" height="100" border="0" cellpadding="0"
       cellspacing="0" align="center" >
    <tr>
        <td height="25" colspan="14" style="background:#0078B7;	font-size: 18px;font-weight: bold;" align="center">
            订单信息列表
        </td>
    </tr>
    <tr class="td_header">
        <td>订单号</td>
        <td>收货人姓名</td>
        <td>性别</td>
        <td>收货地址</td>
        <td>邮编</td>
        <td>联系电话</td>
        <td>收货时间</td>
        <td>支付方式</td>
        <td>买家留言</td>
        <td>下单时间</td>
        <td>下单人姓名</td>
        <td>支付总金额</td>
        <td><center>订单状态</center></td>
    </tr>
        <%
int count=reclist.size();
for(int i=0;i<count;i++){
	Orders order = reclist.get(i);
	String dingdanhao=order.getNum();
	String shouhuoren=order.getPurchaserName();
	String sex=order.getConsigneeSex();
	String dizhi=order.getConsigneeAddr();
	String youbian=order.getPostcode();
	String tel=order.getTel();
	String shsj=order.getConsigneeName();
	String zffs=order.getPaymentType();
	String leaveword=order.getPurchaserLeaveWord();
	String time=order.getPurchaseTime();
	String xiadanren=order.getPurchaserName();
	String zt=order.getStatus();
	String total=order.getAmount();
%>
    <tr class="td_<%=i%2+1%>">
        <td><%=dingdanhao %></td>
        <td><%=shouhuoren %></td>
        <td><%=sex %></td>
        <td><%=dizhi %></td>
        <td><%=youbian %></td>
        <td><%=tel %></td>
        <td><%=shsj %></td>
        <td><%=zffs %></td>
        <td><%=leaveword %></td>
        <td><%=time %></td>
        <td><%=xiadanren %></td>
        <td><%=total %></td>

        <td>
            <center>
                <form name="frm" method="post" action="<%=request.getContextPath()%>/reOrder.action?num=<%=order.getNum() %>">
                  <input type= "radio" name="status" value="0" <%=zt.equals("0")?"checked":null %>>未收款
            <input type= "radio" name="status" value="1" <%=zt.equals("1")?"checked":null %>>已收款
            <input type= "radio" name="status" value="2" <%=zt.equals("2")?"checked":null %>>已发货
            <input type= "radio" name="status" value="3" <%=zt.equals("3")?"checked":null %>>已收货
            <input type = "submit" class="layui-btn layui-btn-primary layui-btn-xs" value = "修改" >
            <a href="<%=path %>/Order.action?oid=<%=order.getId() %>"
               class="layui-btn layui-btn-primary layui-btn-xs">删除</a>
        </form></center>
        </td>
    </tr>
        <%} %>

    <tr><td colspan="8"><a href="<%=request.getContextPath() %>/getAllOrder.action"
                           class="layui-btn layui-btn-primary layui-btn-xs" >刷新列表</a>
    </td></tr>
</body>
</html>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });

</script>

