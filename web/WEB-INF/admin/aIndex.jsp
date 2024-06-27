<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${html_title}</title>
    <script>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;
            element.init();
        });
    </script>
    <style>
        .layui-card .layui-card-body .layui-icon {
            display: inline-block;
            width: 100%;
            height: 60px;
            line-height: 60px;
            text-align: center;
            border-radius: 2px;
            font-size: 30px;
            background-color: #F8F8F8;
            color: #333;
            transition: all .3s;
            -webkit-transition: all .3s;
        }
        .layui-card .layui-card-body {
            text-align: center;
        }
        #notify {
            text-align: left;
        }

    </style>
</head>
<body class="layui-layout-body" style="background-color: #F2F2F2">
<jsp:include page="/filterLogin.jsp"></jsp:include>
<jsp:include page="/WEB-INF/admin/aHeader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/admin/adminNav.jsp"></jsp:include>
<div class="layui-layout layui-layout-admin">
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <div class="layui-card">
                <div class="layui-card-header" id="index-function">功能</div>
                <div>总票数${ticketList}，已购数${ticketList1}，退票数${ticketList2}</div>
            </div>

        </div>
    </div>
    <jsp:include page="/footer.jsp"></jsp:include>
</div>
<script type="text/javascript">
    document.onkeydown = function(e) {
        e = window.event || e;
        var k = e.keyCode;
    }
</script>
<script type="text/javascript">
    $("#nav li:nth-child(1)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(2)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(3)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(4)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(5)").addClass("layui-nav-itemed");
</script>
</body>
</html>
<%--页面指令和标签库引入：--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>：指定页面的内容类型和字符编码为UTF-8，使用Java语言。--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>：引入JSTL核心标签库，为JSP页面提供基本的控制流和模板化功能。--%>
<%--HTML头部：--%>

<%--<head>部分定义页面的标题和引入的JavaScript和CSS资源。--%>
<%--    <title>${html_title}</title>：页面标题，${html_title}是一个占位符，通常在页面加载时会被具体的标题文本替换。--%>
<%--    <script>：包含JavaScript代码区域，使用layui框架的element模块初始化。--%>
<%--<style>：包含页面的CSS样式，定义了一些特定元素（如卡片和图标）的样式。--%>
<%--    页面主体：--%>

<%--    <body>部分定义页面的整体布局和样式，使用layui的布局和样式。--%>
<%--    使用了多个 <jsp:include> 标签引入其他JSP页面，如登录过滤器、管理员头部、管理员导航和页脚等。--%>
<%--            JavaScript代--%>
<%--    ：--%>

<%--          --%>

<%--    包含两个 <script> 块，第一个处理键盘事件，第二个给导航菜单项添加样式。--%>