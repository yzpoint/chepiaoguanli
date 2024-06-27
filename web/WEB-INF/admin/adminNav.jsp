<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

</head>
<%--声明页面内容类型为UTF-8，确保页面支持中文字符集。--%>
<%--设置页面的字符编码为UTF-8。--%>
<%--设置视口，使页面在移动设备上显示良好，最大缩放比例为1。--%>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test" id="nav">
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">车次管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/findScheduleByPageServlet">车次列表</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/addScheduleServlet">新增车次</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">乘客管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/findUserByPageServlet">乘客列表</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/addUserServlet">增加乘客</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">购票信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/findTickByPageServlet">购票列表</a></dd>

                    </dl>
                </li>


            </ul>
        </div>
    </div>
</div>

</body>
</html>
<%--body 使用 layui-layout-body 样式类来定义页面的布局风格。--%>
<%--div 使用 layui-layout 和 layui-layout-admin 样式类来创建一个 layui 风格的布局，包含侧边栏和主体区域。--%>
<%--div 使用 layui-side 和 layui-bg-black 样式类来定义侧边栏的风格和背景颜色。--%>
<%--div 使用 layui-side-scroll 样式类来启用侧边栏滚动。--%>
<%--ul 使用 layui-nav 和 layui-nav-tree 样式类来创建一个垂直导航树。--%>
<%--使用 JSTL 表达式 ${pageContext.request.contextPath} 动态生成 URL，确保链接路径正确。--%>

<%--每个导航项由一个父级 li 和一个子级 dl 组成，包含以下内容：--%>

<%--车次管理--%>

<%--车次列表：链接到 findScheduleByPageServlet。--%>
<%--新增车次：链接到 addScheduleServlet。--%>
<%--乘客管理--%>

<%--乘客列表：链接到 findUserByPageServlet。--%>
<%--增加乘客：链接到 addUserServlet。--%>
<%--购票信息管理--%>

<%--购票列表：链接到 findTickByPageServlet。--%>
