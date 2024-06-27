<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录页</title>
    <link rel="stylesheet" href="./css/layui.css">
    <link rel="stylesheet" href="/sims/css/modules/layer/default/layer.css">
    <link rel="stylesheet" href="./css/login.css">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="shortcut icon" href="./images/favicon.ico" type="image/x-icon" />
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <style type="text/css">

    </style>
</head>
<%--meta 标签设置了字符编码和浏览器兼容模式，确保页面在不同浏览器中的一致性。--%>
<%--引入了 Layui 和自定义 CSS 文件，以及 jQuery 库。--%>
<body>
<div class="frame-main">
    <div class="login-main">
        <header class="layui-elip">车票系统</header>
        <form class="layui-form" action="" name="formf" method="post">
            <%--            div 和 header 标签定义了页面结构和标题。--%>
            <%--            form 标签定义了登录表单，使用 layui-form 类进行 Layui 样式的应用。--%>
            <div class="layui-input-inline">
                <label class="layadmin-user-login-icon layui-icon layui-icon-username"></label>
                <input type="text" name="id" id="id" value="${loginid}" required lay-verify="required" placeholder="用户名" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-input-inline">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password"></label>
                <input type="password" value="${loginpassword}" id="password" name="password" required lay-verify="required" placeholder="密码" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-input-inline" style="width: 56%; margin-bottom: 0px;">
                <label class="layadmin-user-login-icon layui-icon layui-icon-vercode"></label>
                <input type="text" name="verifycode" id="code" required lay-verify="required" placeholder="验证码" autocomplete="off"
                       class="layui-input">
            </div>
            <a href="javascript:refreshCode()">
                <img style="padding-left: 14px;" src="${pageContext.request.contextPath}/checkCodeServlet" title="刷新验证码" id="vcode" draggable="false">
            </a>
            <%--    输入框用于填写用户名、密码和验证码。验证码图片点击后会刷新。--%>

            <div style="padding-left: 54px;padding-bottom: 6px;">
                <input type="radio" name="roles" value="user" title="乘客" checked>
                <input type="radio" name="roles" value="admin" title="管理员">
            </div>

            <div class="layui-input-inline login-btn">
                <button type="button" onclick="a()" lay-submit lay-filter="login" class="layui-btn" id="login" name="submit-login">登录</button>
            </div>
            <%--    单选按钮用于选择角色（乘客或管理员）。--%>
            <%--    登录按钮触发 a() 函数来提交表单。--%>
            <hr/>
            <!--<div class="layui-input-inline">
                <button type="button" class="layui-btn layui-btn-primary">QQ登录</button>
            </div>
            <div class="layui-input-inline">
                <button type="button" class="layui-btn layui-btn-normal">微信登录</button>
            </div>-->
            <p><a href="register.jsp" class="fl">立即注册</a>
            <div class="tooltip">
                <span class="tooltiptext">${login_msg}</span>
            </div>
            <%--    包含一个链接到注册页面。--%>
            <%--    使用 tooltip 显示登录信息提示。--%>

        </form>
    </div>
</div>
<script src="layui.js"></script>
<script src="./lay/modules/layer.js"></script>

<script type="text/javascript">
    function refreshCode() {
        var vcode = document.getElementById("vcode");
        vcode.src = "${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
    }
</script>
<script type="text/javascript">
    layui.use('form',function(){
        var form = layui.form;
        //刷新界面 所有元素
        form.render();
    });
</script>

<script type="text/javascript">
    // $("#login").on("click", function(){
    function a() {
        var num = document.getElementsByName("roles");
        var checked_value = "user";
        for (var i = 0; i < num.length; i++) {
            var radio = num[i];
            if (radio.checked) {
                checked_value = radio.value;
            }
        }
        var id = document.getElementById("id").value;
        var password = document.getElementById("password").value;
        var verifycode = document.getElementById("code").value;
        if (id=='' || password=='' || verifycode=='') {
            return;
        }else {
            if (checked_value=="user") {
                document.formf.action="${pageContext.request.contextPath}/loginServlet?roles=user";
                document.formf.submit();

            }else {
                document.formf.action="${pageContext.request.contextPath}/loginServlet?roles=admin";
                document.formf.submit();
            }
        }
    }
</script>
</body>
</html>
<%--引入 Layui 和其他 JavaScript 文件。--%>
<%--refreshCode() 函数用于刷新验证码图片。--%>
<%--Layui 表单初始化。--%>
<%--a() 函数处理表单提交逻辑，根据选择的角色设置表单的 action 并提交表单。--%>