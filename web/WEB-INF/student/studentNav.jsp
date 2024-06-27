<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

</head>
<%--<%@ page ... %>：JSP页面指令，设置页面的字符编码为UTF-8，语言为Java。--%>
<%--<html>：HTML根元素，标识页面的开始。--%>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test" id="nav">
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">车票信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/findTickByPageServlet">车票列表</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/findScheduleNowByPageServlet">购票</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
</div>
<%--<body class="layui-layout-body">：使用layui布局框架的主体样式。--%>
<%--<div class="layui-layout layui-layout-admin">：layui的整体布局容器，用于实现管理员页面的布局结构。--%>
<%--    <div class="layui-side layui-bg-black">：layui的侧边栏容器，背景色为黑色。--%>
<%--        <ul class="layui-nav layui-nav-tree" lay-filter="test" id="nav">：layui的导航菜单组件，使用了树形结构和过滤器。--%>
<%--            lay-filter="test"：指定导航菜单的过滤器名称。--%>
<%--            id="nav"：指定导航菜单的ID，方便后续通过JavaScript操作。--%>
<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>
<%--<script>：JavaScript代码块，用于引入layui的element模块。--%>
<%--layui.use('element', function(){ ... })：初始化layui的element模块，确保导航菜单的交互功能正常运行。--%>
</body>
</html>
