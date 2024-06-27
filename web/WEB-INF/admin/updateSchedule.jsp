<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改班次信息</title>
    <link rel="stylesheet" href="./css/layui.css">
    <link rel="stylesheet" href="./css/style.css">
    <script src="./layui.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
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
                <a href="">车次管理</a>
                <a><cite>修改班次信息</cite></a>
            </span>
            <form class="layui-form" action="${pageContext.request.contextPath}/updateScheduleInfoServlet" style="padding-top: 50px" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">车次编号</label>
                    <div class="layui-input-block">
                        <input type="hidden" name="id" value="${schedule.id}">
                        <input type="text" name="scheduleCode" value="${schedule.scheduleCode}" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">路线</label>
                    <div class="layui-input-block">
                        <input type="text" name="route" value="${schedule.route}" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">发车时间</label>
                    <div class="layui-input-block">
                        <input type="text" name="departureTime" value="${schedule.departureTime}" required lay-verify="required" placeholder="格式: HH:MM:SS" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">到达时间</label>
                    <div class="layui-input-block">
                        <input type="text" name="arrivalTime"  value="${schedule.arrivalTime}" required lay-verify="required" placeholder="格式: HH:MM:SS" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">票价</label>
                    <div class="layui-input-block">
                        <input type="text" name="ticketPrice"   value="${schedule.ticketPrice}" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">容量</label>
                    <div class="layui-input-block">
                        <input type="text" name="capacity"   value="${schedule.capacity}" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">修改</button>
                        <button class="layui-btn layui-btn-primary" id="inforeset">重置</button>
                        <span style="padding-left: 20px;">${update_msg}</span>
                    </div>
                </div>
            </form>
            <jsp:include page="/footer.jsp"></jsp:include>
        </div>
    </div>
</div>


<script type="text/javascript">
    $("#nav li:nth-child(2) dl dd:nth-child(2)").addClass("layui-this");
    $("#nav li:nth-child(2)").addClass("layui-nav-itemed");
    $("#hidden-update").removeAttr("hidden");
</script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>

<script>
    //Demo
    layui.use('form', function(){

    });
</script>
<script>
    var sex = "${student.s_sex}";
    if (sex == '男') {
        $("#idsex").attr("checked","checked");
        $("#idsex2").removeAttr("checked");
    } else if (sex == '女') {
        $("#idsex2").attr("checked","checked");
        $("#idsex").removeAttr("checked");
    }else{
        $("#idsex").removeAttr("checked");
        $("#idsex2").removeAttr("checked");
    }
</script>
<script type="text/javascript">
    $(function () {
        $('#inforeset').bind('click',function () {
            $("#idsex").removeAttr("checked");
            $("#idsex2").removeAttr("checked");
            $("#student-name").val("");
            $("#student-age").val("");
            $("#student-phone").val("");
            $("#student-email").val("");
            $("#student-address").val("");
            alert("已重置！");
        });


    });
</script>

</body>
</html>
<%--页面指令和标签库引入：--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>：指定页面的内容类型和字符编码为UTF-8，使用Java语言。--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>：引入JSTL核心标签库，为JSP页面提供基本的控制流和模板化功能。--%>
<%--HTML头部：--%>

<%--<head>部分定义页面的标题、引入的样式表和JavaScript资源。--%>
<%--    <title>修改班次信息</title>：页面标题为“修改班次信息”。--%>
<%--    <link>：引入layui和自定义样式表。--%>
<%--    <script>：引入layui和jQuery的JavaScript资源。--%>
<%--页面主体：--%>

<%--<body>部分定义页面的整体布局和样式，使用layui的布局和样式。--%>
<%--使用了 <jsp:include> 标签包含了登录过滤器、管理员的头部和导航。--%>
<%--内容区域：--%>

<%--使用 <span class="layui-breadcrumb"> 定义面包屑导航，显示管理员、车次管理和修改班次信息的链接顺序。--%>
<%--表单：通过 <form> 标签实现了一个包含班次信息修改的表单，向 ${pageContext.request.contextPath}/updateScheduleInfoServlet 发送 POST 请求。--%>
<%--使用了 layui 的表单元素和验证功能 (lay-verify="required")。--%>
<%--<input> 标签用于输入车次编号、路线、发车时间、到达时间、票价和容量信息。--%>
<%--提交按钮为 layui 的按钮样式 (layui-btn)，点击后触发表单提交。--%>
<%--页面底部：--%>

<%--使用 <jsp:include> 标签包含了页脚。--%>
<%--JavaScript脚本：--%>

<%--导航栏样式设置：通过 jQuery 设置了导航栏中某个特定位置的样式，突出显示当前页面位置。--%>
<%--layui元素初始化：使用 layui 的 element.init() 初始化页面元素。--%>
<%--layui表单初始化：使用 layui 的 form 模块进行初始化，虽然当前脚本中没有具体的 form 相关代码，但通常用于表单元素的渲染和事件监听。--%>
<%--性别选择设置：根据 ${student.s_sex} 的值设置页面上的性别选择，通过设置复选框的 checked 属性。--%>
<%--重置按钮点击事件：为页面中的重置按钮绑定了点击事件，点击后清空性别选择和一些其他输入框的内容，并弹出提示框确认重置。--%>

