<%--
  Created by IntelliJ IDEA.
  User: ender
  Date: 2019-12-24
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.Aishopssh.Entites.Leaveword" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    ArrayList<Leaveword> reclist=(ArrayList<Leaveword>)session.getAttribute("list");
    session.removeAttribute("list");
    if(reclist==null){
        reclist=new ArrayList<Leaveword>();
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>留言板</title>
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/common.css">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css" type="text/css">
</head>
<body>
<table width = "1000" height = "100" bprder = "0" cellpadding="0"
       cellspacing="0" align="center">
    <tr><td colspan="8"><a href=/ class="layui-btn layui-btn-primary layui-btn-xs">
        我要留言</a></td>
    </tr>
    <tr>
        <td height="25" colspan="14" style="background:#0078B7;	font-size: 18px;font-weight: bold;" align="center">
            留言列表
        </td>
    </tr>
    <tr class="td_header">
        <td>标题</td>
        <td>留言时间</td>
        <td>是否回复</td>
        <td></td>
    </tr>
    <%
        int count = reclist.size();
        for (int i=0;i<count;i++){
            Leaveword leaveword = reclist.get(i);
            int id = leaveword.getId();
            String title = leaveword.getTitle();
            String time = leaveword.getTime();
            int hfzt = leaveword.getIsReply();
            String huifu = "";
            if(hfzt==0){
                huifu = "还没有回复哦~";
            }else{
                huifu = "√";
            }
    %>
    <tr class="td_<%=i%2+1%>">

        <td><%=title %></td>
        <td><%=time %></td>
        <td><%=huifu %></td>
        <td><a href="<%=path %>/getLeaveWordById.action?lid=<%=leaveword.getId() %>"
               class="layui-btn layui-btn-primary layui-btn-xs">详情</a>


    </tr>
    <%}%>
    <tr>
        <td colspan="8"><a href="<%=request.getContextPath() %>/getAllLeaveWord.action"
                           class="layui-btn layui-btn-primary layui-btn-xs">
            刷新列表</a></td>

</table>
</body>
</html>
