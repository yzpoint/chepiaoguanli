<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增乘客信息</title>
    <link rel="stylesheet" href="./css/layui.css">
    <link rel="stylesheet" href="./css/style.css">
    <script src="./layui.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
<%--声明页面内容类型为UTF-8，确保页面支持中文字符集。--%>
<%--引入JSTL核心库。--%>
<%--设置页面标题为“新增乘客信息”。--%>
<%--引入layui的CSS和JavaScript文件，以及jQuery库。--%>
<body class="layui-layout-body" style="background-color: #F2F2F2">
<jsp:include page="/filterLogin.jsp"></jsp:include>
<jsp:include page="/WEB-INF/admin/aHeader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/admin/adminNav.jsp"></jsp:include>
<div class="layui-layout layui-layout-admin">
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <span class="layui-breadcrumb">
                <a href="">管理员</a>
                <a href="">乘客管理</a>
                <a><cite>新增乘客信息</cite></a>
            </span>
            <form class="layui-form" action="${pageContext.request.contextPath}/addUserInfoServlet" style="padding-top: 50px" method="post">
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
            <jsp:include page="/footer.jsp"></jsp:include>
        </div>
    </div>
</div>
<%--使用layui的layui-layout和layui-body样式创建页面布局。--%>
<%--包含其他JSP页面，实现登录过滤、页面头部和导航功能。--%>
<%--使用layui-form样式创建一个表单，表单的提交地址为addUserInfoServlet，提交方法为POST。--%>
<%--表单包括用户名、密码、真实名称、邮箱等输入项，每个输入项都使用layui的样式类。--%>
<%--表单底部有两个按钮：添加和重置，并显示一个可能的更新消息。--%>

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
    $("#nav li:nth-child(1)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(2)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(3)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(4)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(5)").addClass("layui-nav-itemed");
</script>
<%--第一个脚本初始化layui的element模块。--%>
<%--第二个脚本初始化layui的form模块，并渲染表单。--%>
<%--使用jQuery为导航栏的前五个列表项添加选中的样式。--%>
</body>
</html>
