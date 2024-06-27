<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询班次</title>
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
                <a href="">班次管理</a>
                <a><cite>查询班次</cite></a>
            </span>
            <form style="padding-top: 20px;" action="${pageContext.request.contextPath}/excelUploadServlet" enctype="multipart/form-data" method="post">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: auto;">选择文件</label>
                        <div class="layui-input-inline">
                            <input type="file" name="file"  autocomplete="off" class="layui-input">
                        </div>

                        <div class="layui-input-inline">
                            <button type="submit" class="layui-btn">导入</button>
                        </div>
                    </div>
                </div>
            </form>

            <form id="selectSchedule" action="${pageContext.request.contextPath}/deleteSelectScheduleServlet" method="post">
                <table class="layui-table" lay-filter="test">
                    <thead>
                    <tr>
                        <th><input id="firstCb" type="checkbox" class="my-checkbox" name="" title="" lay-skin="primary"></th>
                        <th>班次号</th>
                        <th>发车时间</th>
                        <th>到达时间</th>
                        <th>路线</th>
                        <th>票价</th>
                        <th>载客量</th>
                        <th>操作</th>
                    </tr>
                    </thead>

                    <c:forEach items="${pb.list}" var="schedule" varStatus="s">
                        <tr>
                            <th><input type="checkbox" class="my-checkbox" name="id" value="${schedule.id}" title="" lay-skin="primary"></th>
                            <td>${schedule.scheduleCode}</td>
                            <td>${schedule.departureTime}</td>
                            <td>${schedule.arrivalTime}</td>
                            <td>${schedule.route}</td>
                            <td>${schedule.ticketPrice}</td>
                            <td>${schedule.capacity}</td>
                            <td><a class="layui-btn layui-btn-normal" href="${pageContext.request.contextPath}/updateScheduleServlet?id=${schedule.id}">修改</a><a class="layui-btn layui-btn-danger" href="javascript:deleteSchedule(${schedule.id});">删除</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </form>

            <ul>
                <c:if test="${pb.currentPage == 1}">
                <a href="javascript:return false;">
                    </c:if>
                    <c:if test="${pb.currentPage != 1}">
                    <a href="${pageContext.request.contextPath}/findScheduleByPageServlet?currentPage=${pb.currentPage-1}&rows=5&id=${condition.id[0]}&route=${condition.route[0]}">
                        </c:if>
                        <li class="page-li">上一页</li></a>

                    <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage == i}">
                    <a href="${pageContext.request.contextPath}/findScheduleByPageServlet?currentPage=${i}&rows=5&id=${condition.id[0]}&route=${condition.route[0]}"><li class="page-li" style="background-color: #009688;border-radius: 2px;color: white;">${i}</li></a>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                    <a href="${pageContext.request.contextPath}/findScheduleByPageServlet?currentPage=${i}&rows=5&id=${condition.id[0]}&route=${condition.route[0]}"><li class="page-li">${i}</li></a>
                    </c:if>
                    </c:forEach>

                    <c:if test="${pb.currentPage == pb.totalPage}">
                    <a href="javascript:return false;">
                        </c:if>
                        <c:if test="${pb.currentPage != pb.totalPage}">
                        <a href="${pageContext.request.contextPath}/findScheduleByPageServlet?currentPage=${pb.currentPage+1}&rows=5&id=${condition.id[0]}&route=${condition.route[0]}">
                            </c:if>
                            <li class="page-li">下一页</li></a>
            </ul>

            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 0px;">
                <legend>共${pb.totalCount}条记录，共${pb.totalPage}页</legend>
            </fieldset>
            <jsp:include page="/footer.jsp"></jsp:include>
        </div>
    </div>
</div>

<script>
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>
<script>
    function deleteSchedule(id) {
        if (confirm("你确定删除该班次吗？")) {
            location.href = "${pageContext.request.contextPath}/deleteScheduleServlet?id=" + id;
        }
    }

    window.onload = function () {
        document.getElementById("deleteSelectSchedule").onclick = function () {
            var flag = false;
            var cbs = document.getElementsByName("id");
            for (var i = 0; i < cbs.length; i++) {
                if (cbs[i].checked) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                if (confirm("你确定要删除选中条目吗？")) {
                    document.getElementById("selectSchedule").submit();
                }
            }
        }
        document.getElementById("firstCb").onclick = function () {
            var cbs = document.getElementsByName("id");
            for (var i = 0; i < cbs.length; i++) {
                cbs[i].checked = this.checked;
            }
        }
    }
    $("#nav li:nth-child(1)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(2)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(3)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(4)").addClass("layui-nav-itemed");
</script>

</body>
</html>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>：指定页面的内容类型和字符编码为UTF-8，使用Java语言。--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>：引入JSTL核心标签库，为JSP页面提供基本的控制流和模板化功能。--%>
<%--<head>部分定义页面的标题、引入的样式表和JavaScript资源。--%>
<%--    <title>查询班次</title>：页面标题为“查询班次”。--%>
<%--    <link>：引入layui和自定义样式表。--%>
<%--    <script>：引入layui和jQuery的JavaScript资源。--%>
<%--<body>部分定义页面的整体布局和样式，使用layui的布局和样式。--%>
<%--使用了多个 <jsp:include> 标签引入其他JSP页面，如登录过滤器、管理员头部、管理员导航和页脚等。--%>
<%--使用<form>标签实现文件上传，通过${pageContext.request.contextPath}指定后端处理文件上传的Servlet路径。 使用<table>和JSTL的<c:forEach>标签循环展示班次列表信息，每条班次包含操作链接--%>
<%--使用<ul>和<li>标签实现分页导航，通过${pb.currentPage}、${pb.totalPage}、${pb.totalCount}等JSTL变量控制 使用<fieldset>标签显示总--%>
<%--使用layui框架的element.init()--%>
<%--通过JavaScript实现删除单个班次和批量删除的确认弹窗，确保用--%>
<%--实现全选和取消全选功能，用--%>
<%--使用jQuery为导航栏添加样式，表明当前页面位置。--%>
