<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增车次信息</title>
    <link rel="stylesheet" href="./css/layui.css">
    <link rel="stylesheet" href="./css/style.css">
    <script src="./layui.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
<%--声明页面内容类型为UTF-8。--%>
<%--引入JSTL核心库。--%>
<%--设置页面标题。--%>
<%--引入layui的CSS和JavaScript文件，以及jQuery库。--%>
<body class="layui-layout-body" style="background-color: #F2F2F2">
<jsp:include page="/filterLogin.jsp"></jsp:include>
<jsp:include page="/WEB-INF/admin/aHeader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/admin/adminNav.jsp"></jsp:include>
<%--设置body的样式，并包含过滤登录、头部和导航的JSP页面。--%>
<div class="layui-layout layui-layout-admin">
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <span class="layui-breadcrumb">
                <a href="">管理员</a>
                <a href="">车次管理</a>
                <a><cite>新增车次信息</cite></a>
            </span>
            <form class="layui-form" action="${pageContext.request.contextPath}/addScheduleInfoServlet" style="padding-top: 50px" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">车次编号</label>
                    <div class="layui-input-block">
                        <input type="text" name="scheduleCode" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">路线</label>
                    <div class="layui-input-block">
                        <input type="text" name="route" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">发车时间</label>
                    <div class="layui-input-block">
                        <input type="text" name="departureTime" required lay-verify="required" placeholder="格式: HH:MM:SS" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">到达时间</label>
                    <div class="layui-input-block">
                        <input type="text" name="arrivalTime" required lay-verify="required" placeholder="格式: HH:MM:SS" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">票价</label>
                    <div class="layui-input-block">
                        <input type="text" name="ticketPrice" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">容量</label>
                    <div class="layui-input-block">
                        <input type="text" name="capacity" required lay-verify="required" autocomplete="off" class="layui-input">
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
<%--使用layui框架创建一个表单，包括车次编号、路线、发车时间、到达时间、票价和容量的输入框。--%>
<%--表单提交的action指向addScheduleInfoServlet，使用POST方法提交数据。--%>
<%--使用了layui-form类和layui-input类来应用layui的样式。--%>
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
