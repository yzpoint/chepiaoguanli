<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="./css/layui.css">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="icon" href="./images/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="./images/favicon.ico" type="image/x-icon">
    <script src="layui.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
<%--<%@ page ... %>：JSP页面指令，设置页面的字符编码为UTF-8。--%>
<%--<html>：HTML根元素，标识页面的开始。--%>
<%--<head>：头部区域包含页面的元数据和引用的外部资源。--%>
<%--    <link>：引入了layui.css和自定义的style.css样式表，用于页面的外观和布局。--%>
<%--    <link>中的favicon.ico指定了页面的图标，这在浏览器标签页中显示。--%>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" style="font-size: 52px"></div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">

        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img  class="layui-nav-img">
                </a>
                <dl class="layui-nav-child">

                    <dd><a href="${pageContext.request.contextPath}/logoutServlet">退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>
<%--<body class="layui-layout-body">：设置页面的主体样式为layui布局样式。--%>
<%--<div class="layui-layout layui-layout-admin">：使用layui框架的布局容器，设置为管理员布局。--%>
<%--    <div class="layui-header">：页面顶部的头部区域，包含了网站的标志和右侧的用户操作区域。--%>
<%--        <ul class="layui-nav layui-layout-left">和<ul class="layui-nav layui-layout-right">：左右两侧的导航栏，这里右侧包含了一个下拉菜单，用于用户操作，如退出系统。--%>
<%--            <script>：引入了layui.js和jQuery，提供页面所需的JavaScript功能和UI组件支持。--%>
<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>
<script type="text/javascript">
    function alertabout() {
        alert("车票管理系统\n");
    }
</script>
<%--layui.use('element', function(){ ... })：使用layui的element模块初始化页面的元素和功能，确保页面正常运行。--%>
<%--function alertabout() { ... }：定义了一个JavaScript函数alertabout()，当调用时，显示包含车票管理系统作者信息的警告框。--%>
</body>
</html>
