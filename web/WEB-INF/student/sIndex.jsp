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
<%--<%@ page ... %>：JSP页面指令，设置页面的字符编码为UTF-8。--%>
<%--<%@ taglib ... %>：引入JSTL核心标签库，用于在JSP中使用标准的JSTL标签。--%>
<%--<html>：HTML根元素，标识页面的开始。--%>
<%--<head>：头部区域包含了页面的标题、引用的外部资源（如JavaScript和CSS）、以及内联的样式定义。--%>
<%--    <title>${html_title}</title>：页面标题，通过${html_title}变量动态获取，可能根据不同的请求动态变化。--%>
<body class="layui-layout-body" style="background-color: #F2F2F2">
<jsp:include page="/filterLogin.jsp"></jsp:include>
<jsp:include page="/WEB-INF/student/sHeader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/student/studentNav.jsp"></jsp:include>
<div class="layui-layout layui-layout-admin">
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <div class="layui-card">
                <div class="layui-card-header" id="index-function">功能</div>
            </div>

        </div>
    </div>
    <jsp:include page="/footer.jsp"></jsp:include>
</div>
<%--<body class="layui-layout-body" style="background-color: #F2F2F2">：设置页面的主体样式为layui布局样式，并指定背景色。--%>
<%--<jsp:include page="..."></jsp:include>：使用JSP的include指令包含其他JSP文件，如登录过滤器、学生头部和导航。--%>
<%--<div class="layui-layout layui-layout-admin">：使用layui框架的布局容器，设置为管理员布局。--%>
<%--    <div class="layui-body">：layui布局的主体部分，页面主要内容的容器。--%>
<%--        <div class="layui-card">：layui的卡片组件，用来显示功能区域。--%>
<%--            <div class="layui-card-header" id="index-function">功能</div>：卡片的标题部分，显示文字“功能”。--%>
<script type="text/javascript">
    $("#nav li:nth-child(1)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(2)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(3)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(4)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(5)").addClass("layui-nav-itemed");
</script>
<%--$("#nav li:nth-child(n)").addClass("layui-nav-itemed");：使用jQuery选择器，为导航栏的特定项添加layui框架的样式，使其默认展开显示。--%>
</body>
</html>
