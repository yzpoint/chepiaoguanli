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
<%--指定页面内容类型和字符编码为UTF-8，确保页面支持中文字符集。--%>
<%--引入 layui.css 和 style.css 样式文件，为页面应用layui框架和自定义样式。--%>
<%--设置页面图标 favicon.ico。--%>
<%--引入 layui.js 和 jquery 的脚本文件，为页面提供layui框架和jQuery的功能支持。--%>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" style="font-size: 52px"></div>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img  class="layui-nav-img">
                    管理员
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath}/logoutServlet">退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>
<%--body 使用 layui-layout-body 样式类来定义页面的布局风格。--%>
<%--div 使用 layui-layout 和 layui-layout-admin 样式类来创建一个 layui 风格的布局，包含头部导航栏。--%>
<%--div 使用 layui-header 样式类来定义头部导航栏。--%>
<%--div 使用 layui-logo 样式类来定义网站LOGO区域，可以通过调整 font-size 来设置LOGO的大小。--%>
<%--ul 使用 layui-nav 和 layui-layout-right 样式类来创建一个右对齐的导航栏。--%>
<%--li 使用 layui-nav-item 样式类来定义导航项。--%>
<%--a 标签包含管理员的头像和名称，并使用 layui-nav-img 样式类来定义头像的样式。--%>
<%--dl 使用 layui-nav-child 样式类来定义导航项的子菜单。--%>
<%--子菜单项 dd 包含一个链接，用于注销管理员，并使用 JSTL 表达式 ${pageContext.request.contextPath} 动态生成 URL，确保链接路径正确。--%>
<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>
<script type="text/javascript">
    function alertabout() {

    }
</script>
<%--使用 layui 的 element 模块来初始化导航栏，确保其功能性操作。--%>
<%--定义一个空的 alertabout 函数，可以用于以后添加弹出框功能。--%>
</body>
</html>
