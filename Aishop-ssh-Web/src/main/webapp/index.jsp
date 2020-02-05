<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/24/024
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,com.Aishop.Action.UserAction.UserLogin.*,com.Aishopssh.Entites.*"%>
<%@ page import="com.Aishopssh.Dao.UserDao.UserInfoDao" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<%
    String path = request.getContextPath();
    List<List<String>> record = new ArrayList<List<String>>();
    Useragreement txt = new Useragreement();
    UserInfoDao userinfodao = new UserInfoDao();
    record = txt.getRecord();
    Admin admin = userinfodao.getadmin();
%>
<head>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/user.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="apple-touch-icon" sizes="76x76" href="<%=path%>/img/apple-icon.png">
    <link rel="icon" type="image/png" href="<%=path%>/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>会员登录</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <!-- CSS Files -->
    <link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=path%>/css/now-ui-kit.css?v=1.1.0" rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="<%=path%>/css/demo.css" rel="stylesheet" />
    <!-- Canonical SEO -->
    <link rel="canonical" href="" />
    <!--  Social tags      -->
    <meta name="keywords" content="">
    <meta name="description" content="">



</head>
<script src="js/jquery.js"></script>
<script src="js/vector.js"></script>
<style>
    #login_click2:hover {color:red;}
    .font1 {size:1px;}
    .font1:hover {size:3px;}
    .font { font-size:18px;}
    #text{
        height:400px;left:40%;
        overflow-y: scroll;
        background:#FFFFFF;
        color: #525252;
        margin-bottom: 16px;
        margin-right: 6px;
        margin-top: 2px;
        outline: 0 none;
        padding: 5px 0px 5px 5px;
        width: 100%;
        border-radius: 2px;
        -webkit-border-radius: 2px;
        -moz-border-radius: 2px;
        -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        background: #DFDFDF;
    }
    .class{
        font-size:20px;
    }


    #canvas{
        cursor:pointer;
        width:60%
    }
    #denlu{
        width: 120px;
        height: 20px;
        margin: 0 auto;
        position: fixed;
        left: 45%;
        margin-left: -60px;
        bottom: 80%;
    }
    #denlu h1{
        align:center;
    }

    #container {
        position: absolute;
        height: 100%;
        width: 100%;
        z-index:-1;
    }
    #output {
        width: 100%;
        height: 100%;
        z-index:-1;
    }
    .color{
        width: 120px;
        height: 20px;
        margin: 0 auto;
        position: fixed;
        left: 50%;
        margin-left: -60px;
        bottom: 20px;
    }
    .login_click{ margin-top:32px; height:40px;width:200px}
    .login_click a
    {


        text-decoration:none;
        background:#2f435e;
        color:#f2f2f2;

        padding: 10px 30px 10px 30px;
        font-size:16px;
        font-family: 微软雅黑,宋体,Arial,Helvetica,Verdana,sans-serif;
        font-weight:bold;
        border-radius:3px;
        -webkit-transition:all linear 0.30s;
        -moz-transition:all linear 0.30s;
        transition:all linear 0.30s;

    }
    .login_click a:hover { background:#385f9e; }
</style>

<body class="login-page sidebar-collapse">
<script src="<%=path %>/jquery/jquery-3.3.1.js"></script>
<script language="JavaScript">
    var flag = 0;
    $(function(){
        $("#name").on('blur',function(){
            if(frm1.name.value==""){
                $(".1").html("*&nbsp;<font size='4' color='red'>✘</font>");
            }else{
                $.ajax({
                    type: "Post",
                    url: "${pageContext.request.contextPath}/userName.action?name="+frm1.name.value,
                    //没有参数也一定要传一个空参数
                    dataType: "text",
                    success: function(data) {
                        if(data==("1")){
                            $(".1").html("*&nbsp;<font size='4' color='green'>√</font>");
                            flag = 1;
                        }
                        if(data==("2")){
                            $(".1").html("*&nbsp;<font size='4' color='red'>✘ 用户名重复</font>");
                        }
                    },
                    error: function(err) {
                        alert(err);
                    },
                });
            }
        });
        $("#pwd").on('blur',function(){
            if(frm1.pwd.value==""){
                $(".2").html("*&nbsp;<font size='4' color='red'>✘</font>");
            }
            if(frm1.pwd.value != ""){
                $(".2").html("*&nbsp;<font size='4' color='green'>√</font>");
            }
        });
        $("#pwd1").on('blur',function(){
            if(frm1.pwd.value == frm1.pwd1.value){
                $(".3").html("*&nbsp;<font size='4' color='green'>√</font>");
            }else{
                $(".3").html("*&nbsp;<font size='4' color='red'>✘</font>");
            }
        });
        $("#email").on('blur',function(){
            if(frm1.email.value.indexOf("@qq.com")>=0||frm1.email.value.indexOf("@163.com")>=0||frm1.email.value.indexOf("@gmail.com")>=0
                ||frm1.email.value.indexOf("@yahoo.com")>=0||frm1.email.value.indexOf("@msn.com")>=0){
                $(".4").html("*&nbsp;<font size='4' color='green'>√</font>");
            }else{
                $(".4").html("*&nbsp;<font size='4' color='red'>✘</font>");
            }
        });
        $("#qq").on('blur',function(){
            if(frm1.qq.value!=""){
                $(".5").html("&nbsp;<font size='4' color='green'>√</font>");
            }
        });
        $("#youbian").on('blur',function(){
            if(frm1.youbian.value!=""){
                $(".6").html("&nbsp;<font size='4' color='green'>√</font>");
            }
        });
        $("#truename").on('blur',function(){
            if(frm1.truename.value!=""){
                $(".7").html("&nbsp;<font size='4' color='green'>√</font>");
            }
        });
        $("#tel").on('blur',function(){
            if(frm1.tel.value!=""){
                $(".8").html("&nbsp;<font size='4' color='green'>√</font>");
            }
        });
        $("#dizhi").on('blur',function(){
            if(frm1.dizhi.value!=""){
                $(".9").html("&nbsp;<font size='4' color='green'>√</font>");
            }
        });
        $("#tishi").on('blur',function(){
            if(frm1.tishi.value!=""){
                $(".10").html("&nbsp;<font size='4' color='green'>√</font>");
            }
        });
        $("#huida").on('blur',function(){
            if(frm1.huida.value!=""){
                $(".11").html("&nbsp;<font size='4' color='green'>√</font>");
            }
        });
        $("#findname").on('blur',function(){
            var findname = document.getElementById('findname').value;
            $.ajax({
                type: "post",
                url: "<%=path%>/userName.action?name="+findname,
                //没有参数也一定要传一个空参数
                dataType: "text",
                success: function(data) {
                    if(data == "1"){
                        $(".find").html("&nbsp;<font size='4' color='red'>✘没有该用户</font>");
                    }
                    if(data == "2"){
                        $(".find").html("&nbsp;<font size='4' color='green'>√</font>");
                        $.ajax({
                            url: "<%=path%>/GetsecurityQuestion.action?name="+findname,
                            dataType: "json",
                            success: function (data) {
                                $("#question").val(data[0].Tishi);
                                $("#huida").val(data[1].Huida);
                                $("#findpwd").val(data[2].Pwd);
                            },
                            error: function(err) {
                                alert(err);
                            }
                        });
                    }
                },
                error: function(err) {
                    alert(err);
                }
            });
        });
    });

    function check(){
        if(frm1.name.value!=""&&frm1.pwd.value != ""&&frm1.pwd.value == frm1.pwd1.value&&(frm1.email.value.indexOf("@qq.com")>=0||frm1.email.value.indexOf("@163.com")>=0||frm1.email.value.indexOf("@gmail.com")>=0
            ||frm1.email.value.indexOf("@yahoo.com")>=0||frm1.email.value.indexOf("@msn.com")>=0)&&flag==1){
            var url ="<%=path %>/insert.action?name="+frm1.name.value+"&pwd="+frm1.pwd.value+"&comfirmPwd="+frm1.pwd1.value+"&email="+frm1.email.value+"&qq="+frm1.qq.value+"&postcode="+frm1.youbian.value+"&trueName="+frm1.truename.value+"&tel="+frm1.tel.value+"&addr="+frm1.dizhi.value+"&securityQuestion="+frm1.tishi.value+"&securityAnswer="+frm1.huida.value;
            alert("注册成功");
            window.location.href=url;
            window.event.returnValue=false;
        }else{
            alert("请确认重要信息已经填写");
        }
    }

    function findpwd(){
        if(document.getElementById('answer').value==document.getElementById('huida').value){
            alert("密码为:"+document.getElementById('findpwd').value);
        }else{
            alert("回答错误");
        }

    }
    <%

        String name=(String)session.getAttribute("username");
        String loginFlag=(String)session.getAttribute("loginflag");
        if(loginFlag==null){
            loginFlag="";
        }
            if(loginFlag.equals("1")){
                out.println("alert('用户【"+name+"】不存在！')");
            }else if(loginFlag.equals("2")){
                out.println("alert('密码错误！')");
            }
    %>
    $(function(){
        $("#login_click").click(function(){
            if($("#username").val()==""){
                alert("用户名不能为空");
                frm.username.focus();
            }
            else if($("#password").val()==""){
                alert("密码不能为空");
                frm.password.focus();
            }
            else if($("#yanzhenzhi").val()!=$("#yanzhen").val()){
                alert("请输入正确验证码");
                frm.yanzhen.focus();
            }
            if($("#username").val()!=""&&($("#password").val()!="")&&$("#yanzhenzhi").val()==$("#yanzhen").val()){
                var url = "<%=path%>/indexaction.action?username="+frm.username.value+"&password="+frm.password.value;
                alert(url);
                window.location.href=(url);
                window.event.returnValue=false;
            }
        });
        $("#queren").click(function(){
            document.getElementById('inputbox1').style.display=n?'block':'none';
        });
    });


    function msgbox(n){
        document.getElementById('inputbox').style.display=n?'block':'none';/* 点击按钮打开/关闭 对话框 */

    }
    function msgbox2(n){
        document.getElementById('inputbox2').style.display=n?'block':'none';/* 点击按钮打开/关闭 对话框 */

    }
    function msgbox1(n){
        var radios = document.getElementsByName("option");
        var value = 0;
        for(var i=0;i<radios.length;i++){
            if(radios[i].checked == true){
                value = radios[i].value;
            }
        }
        if(value==0){
            document.getElementById('inputbox').style.display=0?'block':'none';
            document.getElementById('inputbox1').style.display=n?'block':'none';/* 点击按钮打开/关闭 对话框 */
        }else{
            document.getElementById('inputbox').style.display=0?'block':'none';
        }
    }

    function admin(){
        if($("#yanzhenzhi").val()!=$("#yanzhen").val()){
            alert("验证码错误");
        }else{
            if(document.getElementById('username').value==document.getElementById('adminname').value&&document.getElementById('password').value==document.getElementById('adminpwd').value){
                alert("成功登录");
                window.location.href="<%=path%>/Manager/Manager.jsp";
            }else{
                alert("管理员账号信息错误");
            }
        }
    }
</script>

<input type="hidden" id="adminname" value="<%=admin.getName()%>">
<input type="hidden" id="adminpwd" value="<%=admin.getPwd()%>">
<input type="hidden" id="yanzhenzhi" value="">
<input type="hidden" id="huida" value="">
<input type="hidden" id="findpwd" value="">

<div class="box" id="inputbox">
    <a class="aui_close" href="" onclick="msgbox(0); return false;">×</a>
    <table border="0" align="center">
        <tr><th colspan="2">
            <h1>&emsp;&emsp;用户协议</h1>
            <div id="text"><p>
                    <%
		for(int i=0;i<record.size();i++){
			List<String> list= new ArrayList<String>(record.get(i));
			for(int j=0;j<list.size();j++){
			%>
                <p align="left"><%=list.get(j)%> </p>
                <%
                        }
                    }
                %>
            </div>
        </th></tr>
        <tr>
            <th  class="font"><input type="radio" name="option" value="0" align="left" checked>&emsp;&emsp;&emsp;&emsp;&ensp;我接受</th>
            <th class="font"><input type="radio" name="option" value="1" align="left">&emsp;&emsp;&emsp;&emsp;&ensp;不接受
            </th>
        </tr>
        <tr><td align="center" colspan="2"><div class="login_click" id="queren">
            <a id="1" href="javascript:msgbox1(1)">确 认</a>
        </div> </td></tr>
    </table>

</div>

<div id='inputbox1' class="box" >
    <a class="aui_close" href="" onclick="msgbox1(0); return false;">×</a>
    <form name="frm1" method="post">
        <table border="0" align="center">

            <tr><td colspan="2"> 用户信息，<span>*</span>为必填项</td></tr>
            <tr><td>用户名</td><td><input type="text" name="name" value="" size="20" maxlength="5" id="name">
            </td><td align="left"><p class="1" align="left">*</p></td></tr>

            <tr><td>密码</td><td><input type="password" name="pwd" value="" size="20" maxlength="20" id="pwd">
            </td><td><p class="2">*</p></td></tr>

            <tr><td>再次确认密码</td><td><input type="password" name="pwd1" value="" size="20" maxlength="20" id="pwd1">
            </td><td><p class="3">*</p></td></tr>

            <tr><td>E-mail</td><td><input type="text" name="email" value="" id="email">
            </td><td><p class="4">*</p></td></tr>

            <tr><td>QQ号码</td>
                <td><input type="text" name="qq" value="" size="20" maxlength="20" id="qq"></td><td><p class="5"></p></td></tr>

            <tr><td>邮政编码</td>
                <td><input type="text" name="youbian" value="" size="20" maxlength="20" id="youbian"></td><td><p class="6"></p></td></tr>

            <tr><td>真实姓名</td>
                <td><input type="text" name="truename" value="" size="20" maxlength="20" id="truename"></td><td><p class="7"></p></td></tr>

            <tr><td>联系电话</td>
                <td><input type="text" name="tel" value="" size="20" maxlength="20" id="tel"></td><td><p class="8"></p></td></tr>

            <tr><td>联系地址</td>
                <td><input type="text" name="dizhi" value="" size="20" maxlength="20" id="dizhi"></td><td><p class="9"></p></td></tr>

            <tr><td>保密问题</td>
                <td><input type="text" name="tishi" value="您最喜欢的明星是？" size="20" maxlength="20" id="tishi"></td><td><p class="10"></p></td></tr>

            <tr><td>提示答案</td>
                <td><input type="text" name="huida" value="" size="20" maxlength="20" id="daan"></td><td><p class="11"></p></td></tr>
            <tr><th></th><th><div class="login_click">
                <a  href="javascript:check()">确认</a>
            </div></th><th></th></tr>

        </table>
    </form>
</div>

<div class="box" id="inputbox2">
    <a class="aui_close" href="" onclick="msgbox2(0); return false;">×</a>
    <br />
    <br />
    <table border="0" align="center">
        <tr><td colspan="3">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<font size="5">用户密码找回</font></td></tr>
        <tr><td>请输入用户名:</td><td><input type="text" name="findname" value="" size="20" maxlength="5" id="findname">
        </td><td align="left"><p class="find" align="left">*</p></td></tr>
        <tr><td>问题:</td><td><textarea name="question"   rows="30" cols="200" id="question" readonly="readonly"></textarea></td></tr>
        <tr><td>答案:</td><td><input type="text" name="answer" value="" id="answer"></td></tr>
        <tr><th></th><th><div class="login_click">
            <a  href="javascript:findpwd()">确认</a>
        </div></th><th></th></tr>
    </table>

</div>

<nav class="navbar navbar-expand-lg bg-primary fixed-top navbar-transparent " color-on-scroll="400">
    <div class="container">
        <div class="collapse navbar-collapse justify-content-end" data-nav-image="<%=path%>/img/blurred-image-1.jpg">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">返回主页</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- End Navbar -->
<div class="page-header" filter-color="orange">
    <div class="page-header-image" style="background-image:url(<%=path%>/img/bg1.jpg)"></div>
    <div class="container">
        <div class="col-md-4 content-center">
            <div class="card card-login card-plain">
                <form class="form" method="" action="" name="frm" method="post" >
                    <div class="header header-primary text-center">
                        <div class="logo-container">
                            <img src="<%=path%>/img/now-logo.png" alt="">
                        </div>
                    </div>
                    <div class="content">
                        <div class="input-group form-group-no-border input-lg">
                                <span class="input-group-addon">
                                    <i class="now-ui-icons users_circle-08"></i>
                                </span>
                            <input type="text" class="form-control" placeholder="用户名" value="" name="username" id="username">
                        </div>
                        <div class="input-group form-group-no-border input-lg">
                                <span class="input-group-addon">
                                    <i class="now-ui-icons text_caps-small"></i>
                                </span>
                            <input type="password" placeholder="用户密码" class="form-control" value="" name="password" id="password"/>
                        </div>
                        <div class="input-group form-group-no-border input-lg">
                            <input type="text" class="form-control" placeholder="验证码" value="" id="yanzhen" name="yanzhen">
                        </div>
                        <canvas id="canvas" width="180px" height="50px"></canvas>
                    </div>
                    <div class="footer text-center">
                        <a href="#pablo" class="btn btn-primary btn-round btn-lg btn-block" id="login_click">登  录</a>
                        <a  class="btn btn-primary btn-round btn-lg btn-block"  href="javascript:admin()">管理员登录</a>
                    </div>
                    <div class="pull-left">
                        <h6>
                            <a href="javascript:msgbox(1)" class="link" id="login_click2"><font  id="font1">创建账户</font></a>
                        </h6>
                    </div>
                    <div class="pull-right">
                        <h6>
                            <a href="javascript:msgbox2(1)" class="link" >密码找回</a>
                        </h6>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <footer class="footer">
        <div class="copyright">
            &copy;
            <script>
                document.write(new Date().getFullYear())
            </script>, 成都信息工程大学
        </div>
    </footer>
</div>


<script>
    //生成随机数
    function randomNum(min,max){
        return Math.floor(Math.random()*(max-min)+min);
    }
    //生成随机颜色RGB分量
    function randomColor(min,max){
        var _r = randomNum(min,max);
        var _g = randomNum(min,max);
        var _b = randomNum(min,max);
        return "rgb("+_r+","+_g+","+_b+")";
    }
    //先阻止画布默认点击发生的行为再执行drawPic()方法
    document.getElementById("canvas").onclick = function(e){
        e.preventDefault();
        drawPic();
    };
    function drawPic(){
        //获取到元素canvas
        var $canvas = document.getElementById("canvas");
        var _str = "0123456789";//设置随机数库
        var _picTxt = "";//随机数
        var _num = 4;//4个随机数字
        var _width = $canvas.width;
        var _height = $canvas.height;
        var ctx = $canvas.getContext("2d");//获取 context 对象
        ctx.textBaseline = "bottom";//文字上下对齐方式--底部对齐
        ctx.fillStyle = randomColor(180,240);//填充画布颜色
        ctx.fillRect(0,0,_width,_height);//填充矩形--画画
        for(var i=0; i<_num; i++){
            var x = (_width-10)/_num*i+10;
            var y = randomNum(_height/2,_height);
            var deg = randomNum(-45,45);
            var txt = _str[randomNum(0,_str.length)];
            _picTxt += txt;//获取一个随机数
            ctx.fillStyle = randomColor(10,100);//填充随机颜色
            ctx.font = randomNum(16,40)+"px SimHei";//设置随机数大小，字体为SimHei
            ctx.translate(x,y);//将当前xy坐标作为原始坐标
            ctx.rotate(deg*Math.PI/180);//旋转随机角度
            ctx.fillText(txt, 0,0);//绘制填色的文本
            ctx.rotate(-deg*Math.PI/180);
            ctx.translate(-x,-y);
        }
        for(var i=0; i<_num; i++){
            //定义笔触颜色
            ctx.strokeStyle = randomColor(90,180);
            ctx.beginPath();
            //随机划线--4条路径
            ctx.moveTo(randomNum(0,_width), randomNum(0,_height));
            ctx.lineTo(randomNum(0,_width), randomNum(0,_height));
            ctx.stroke();
        }
        for(var i=0; i<_num*10; i++){
            ctx.fillStyle = randomColor(0,255);
            ctx.beginPath();
            //随机画原，填充颜色
            ctx.arc(randomNum(0,_width),randomNum(0,_height), 1, 0, 2*Math.PI);
            ctx.fill();
        }
        $("#yanzhenzhi").val(_picTxt);
        return _picTxt;//返回随机数字符串
    }
    drawPic();
</script>

</body>
</html>
