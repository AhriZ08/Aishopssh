<%--
  Created by IntelliJ IDEA.
  User: ender
  Date: 2019-12-24
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.Aishopssh.Entites.Leaveword" %>
<%@ page import="com.Aishopssh.Entites.AdminReply" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    Leaveword leaveword=(Leaveword) session.getAttribute("leaveword");
    AdminReply huifu=(AdminReply) session.getAttribute("reply");
    String lwtitle=leaveword.getTitle();
    String lwcontent = leaveword.getContent();
    String lwtime = leaveword.getTime();
    String hftitle = huifu.getTitle();
    String hfcontent = huifu.getContent();
    String hftime = huifu.getReplyTime();
    int ydly = huifu.getIsRead();
    String yidu="";
    if(ydly==0){
        yidu="管理员太忙了还没读你的留言哦";
    }else{
        yidu="管理员已读！";
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>留言详情</title>
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/common.css">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css" type="text/css">
</head>
<body>
<fieldset weight="1000"class="layui-elem-field">
    <legend>留言主题</legend>
    <div class="layui-field-box">
        <%=lwtitle %>
        <fieldset class="layui-elem-field layui-field-title">
            <legend>留言内容</legend>
            <div class="layui-field-box">
                <%=lwcontent %>
            </div>
        </fieldset>
        <fieldset class="layui-elem-field layui-field-title">
            <legend>留言时间</legend>
            <div class="layui-field-box">
                <%=lwtime %>
            </div>
        </fieldset>
    </div>
</fieldset>
<fieldset class="layui-elem-field">
    <legend>回复主题</legend>
    <div class="layui-field-box">
        <%=hftitle %>
        <fieldset class="layui-elem-field layui-field-title">
            <legend>回复内容</legend>
            <div class="layui-field-box">
                <%=hfcontent %>
            </div>
        </fieldset>
        <fieldset class="layui-elem-field layui-field-title">
            <legend>回复时间</legend>
            <div class="layui-field-box">
                <%=hftime %>
            </div>
        </fieldset>
        <fieldset class="layui-elem-field layui-field-title">
            <legend>管理员已读？</legend>
            <div class="layui-field-box">
                <%=yidu %>
            </div>
        </fieldset>
    </div>
</fieldset>
</body>
</html>
