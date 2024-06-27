<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="./css/layui.css">
    <link rel="stylesheet" href="./css/style.css">
    <script src="./layui.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
<%--设置页面内容类型为 text/html，编码为 UTF-8。--%>
<%--引入 JSTL 标签库。--%>
<%--引入 Layui 样式表和 JavaScript 文件，以及 jQuery 库。--%>

<body class="layui-layout-body" style="background-color: #F2F2F2">

<div class="layui-layout layui-layout-admin">
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;background-color: #8d8dc2;">
            <form class="layui-form" action="${pageContext.request.contextPath}/registerUserInfoServlet" style="padding-top: 50px" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-block">
                        <input type="text" name="userName" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                        <input type="text" name="password" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">真实名称</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" required lay-verify="required"  autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">邮箱</label>
                    <div class="layui-input-block">
                        <input type="text" name="email" required lay-verify="required"  autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
                        <button class="layui-btn layui-btn-primary" type="reset">重置</button>
                        <span style="padding-left: 20px;">${update_msg}</span>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%--使用 Layui 的 layui-layout-body 类和背景颜色样式定义页面主体。--%>
<%--创建一个 layui-layout layui-layout-admin 布局，并在其中添加主要内容区域。--%>
<%--使用 Layui 的 layui-form 类创建表单，设置表单的提交路径为 registerUserInfoServlet，使用 POST 方法提交。--%>
<%--添加用户名、密码、真实姓名和邮箱的输入框，每个输入框都是必填的并带有相应的 Layui 样式。--%>
<%--添加表单提交和重置按钮，以及显示来自后台的消息 ${update_msg}。--%>

<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>

<script>
    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
</script>
<%--使用 Layui 的模块化加载方式，初始化 element 模块来启用页面中的所有元素。--%>
<%--初始化 form 模块并重新渲染表单，确保 Layui 的样式和交互效果生效。--%>
</body>
</html>
