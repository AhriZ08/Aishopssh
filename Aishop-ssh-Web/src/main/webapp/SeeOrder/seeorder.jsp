<%--
  Created by IntelliJ IDEA.
  User: 飞天小昊昊
  Date: 2019/12/25
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.Aishopssh.Entites.Orders" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js" charset="utf-8"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <title>订单信息</title>
    <%	String path=request.getContextPath(); %>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
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


    <style type="text/css">

        .div1{
            width:100%;
            background:#CCEEFF;
            height:80px;
            text-align:center;
            letter-spacing:120px;
            margin-bottom:20px;
        }

        .div2{
            font-size:50px;
            color:white;
            margin-left:150px;
        }

        .div3{

            width:100%;

        }

        .div5{

            border:1px solid #F0F0F0;
            width:63%;
            margin:0px auto;
            margin-left:280px;
            margin-bottom:40px;
        }

        .div6{

            border:1px solid #F0F0F0;
            width:63%;
            margin-left:280px;

        }

        .div7{
            background:#F0F0F0;
            height:40px;

        }

        .div8{
            background:#CCEEFF;
            width:100%;
            height:100px;
            margin-top:120px;

        }

    </style>
</head>


<body>
<div class="div1">
    <div class="div2">
        <span>订单信息</span>
    </div>
</div>

<!-- 订单搜索块 -->
<div class="div5">
    <div style="background:#CCEEFF;font-size:30px;text-align:center;" >我的订单列表</div>
    <!-- 	<div class="div3" style="margin-top:15px">
                    <div class="input-group" style="margin-bottom:15px;width:450px;margin:15px auto;">
                             <input type="text" class="form-control" placeholder="搜寻订单">
                             <span class="input-group-btn">
                                <button class="btn btn-default" type="button" style="float:right">搜索</button>
                              </span>
                    </div>/input-group -->

    <table class="table table-striped" style="height:15px;">
        <tr>
            <td>订单号</td><td>下单用户</td><td>订货人</td><td>金额总计</td><td>支付方式</td><td>收货时间</td><td>订单状态</td><td></td>
        </tr>
        <%
            ArrayList<Orders> odlist = (ArrayList<Orders>)session.getAttribute("odsipls");
            if(odlist.size() == 0){
                out.print("<tr>");
                out.print("<td>暂无订单</td>");
                out.print("</tr>");
            }else{
                for(int i = 0; i < odlist.size(); i++){
                    out.print("<tr>");
                    out.print("<td>" + odlist.get(i).getNum() + "</td>");
                    out.print("<td>" + odlist.get(i).getPurchaserName()+ "</td>");
                    out.print("<td>" + odlist.get(i).getConsigneeName() + "</td>");
                    out.print("<td>" + odlist.get(i).getAmount() + "</td>");
                    out.print("<td>" + odlist.get(i).getPaymentType() + "</td>");
                    out.print("<td>" + odlist.get(i).getConsigneeRecTime() + "</td>");
                    out.print("<td>" + odlist.get(i).getStatus() + "</td>");
                    out.print("<td><button class='btn btn-default' type='button' onclick='SearchOrder(" + odlist.get(i).getNum() + ")'>详情</button></td>");
                    out.print("<td><button class='btn btn-default' type='button' onclick='toDetailHide()'>收起</button></td>");
                    out.print("</tr>");
                }
            }
        %>
    </table>
</div>

<!-- 订单信息详细界面 -->
<table class="table table-striped" style="height:15px;margin-top:10px;margin-bottom:30px;width:63%;margin-left:280px;" id="odecartta">
</table>
<div class="div6">
</div>

<div class="div8">
    <div style="color:white;text-align:center">@enjoy your shopping and pick up things carefully</div>
    <br>
    <div style="color:white;text-align:center">You can choose anthing you want</div>
</div>
<script>
    function toDetailHide(){
        $("#odecartta").hide();
        $(".div6").hide();
    }
    function SearchOrder(ordernumber){
        $.ajax({
            url: "${pageContext.request.contextPath}/GetOneOrderDetail.action?OdNum=" + ordernumber,
            type:"POST",
            cache:false,
            dataType:"json",
            success:function(data){
                $(".div6").html("");
                var str = '<div class="div7"></div>';
                str += '<table style="height:100px">';
                str += '<tr><td><span style="font-size:20px;color:#90d7ec;">收货人信息</span></td></tr>';
                str += '<tr><td>下单人：</td><td>' + data.oddet.purchaserName + '</td></tr>';
                str += '<tr><td>收货人：</td><td>' + data.oddet.consigneeName + '</td></tr>';
                str += '<tr><td>收货人地址：</td><td>' + data.oddet.consigneeAddr + '</td></tr>';
                str += '</table>';

                str += '<table style="height:100px">';
                str += '<tr><td><span style="font-size:20px;color:#90d7ec;">地址信息</span></td></tr>';
                str += '<tr><td>邮政编码：</td><td>' + data.oddet.postcode + '</td></tr>';
                str += '<tr><td>联系电话：</td><td>' + data.oddet.tel + '</td></tr>';
                str += '<tr><td>送货时间：</td><td>' + data.oddet.consigneeRecTime + '</td></tr>';
                str += '</table>';

                str += '<table style="height:100px">';
                str += '<tr><td><span style="font-size:20px;color:#90d7ec;">支付信息</span></td></tr>';
                str += '<tr><td>支付方式：</td><td>' + data.oddet.paymentType + '</td></tr>';
                str += '</table>';

                $(".div6").html(str);

                $("#odecartta").html("");
                str = "<tr><td>商品名称</td><td>市场价</td><td>会员价</td><td>数量</td><td>小计</td></tr>";
                var sum = 0;
                $.each(data.cartlistArrayList, function(index, item){
                    str += "<tr>";
                    str += "<td>" + item.name + "</td>";
                    str += "<td>" + item.marketPirce + "</td>";
                    str += "<td>" + item.memberPrice + "</td>";
                    str += "<td>" + item.num + "</td>";
                    var a = parseInt(item.memberPrice);
                    var b = parseInt(item.num);
                    str += "<td>" + a * b + "</td>";
                    str += "</tr>";
                    sum += a * b;
                });
                str += "<tr><td></td><td></td><td></td><td></td><td>总计：" + sum + "</td></tr>";
                $("#odecartta").html(str);

                $("#odecartta").show();
                $(".div6").show();
            }
        })
    }
    $(function(){
        $("#odecartta").hide();
        $(".div6").hide();
    });
</script>
</body>
</html>