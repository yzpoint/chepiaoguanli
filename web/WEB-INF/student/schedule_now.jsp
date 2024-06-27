<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--设置页面的内容类型为HTML，字符编码为UTF-8，并引入JSTL核心标签库。--%>
<html>
<head>
    <title>查询班次</title>
    <link rel="stylesheet" href="./css/layui.css">
    <link rel="stylesheet" href="./css/style.css">
    <script src="./layui.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
<%--定义页面的标题，引入LayUI和自定义样式表的CSS文件，以及LayUI的JavaScript文件和jQuery库。--%>
<body class="layui-layout-body" style="background-color: #F2F2F2">
<jsp:include page="/filterLogin.jsp"></jsp:include>
<jsp:include page="/WEB-INF/student/sHeader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/student/studentNav.jsp"></jsp:include>
<div class="layui-layout layui-layout-admin">
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <span class="layui-breadcrumb">
                <a href="">乘客</a>
                <a href="">车票信息</a>
                <a><cite>购票</cite></a>
            </span>

            <form style="padding-top: 20px;" action="${pageContext.request.contextPath}/findScheduleNowByPageServlet" method="post">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: auto;">班次号</label>
                        <div class="layui-input-inline">
                            <input type="tel" name="scheduleCode" value="${condition.id[0]}" autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label" style="width: auto;">路线</label>
                        <div class="layui-input-inline">
                            <input type="text" name="route" value="${condition.route[0]}" autocomplete="off" class="layui-input">
                        </div>

                        <div class="layui-input-inline">
                            <button type="submit" class="layui-btn">查询</button>
                        </div>
                    </div>
                </div>
            </form>

            <form id="selectSchedule"  method="post">
                <table class="layui-table" lay-filter="test">
                    <thead>
                    <tr>
                        <th><input id="firstCb" type="checkbox" class="my-checkbox" name="" title="" lay-skin="primary"></th>
                        <th>班次号</th>
                        <th>发车时间</th>
                        <th>到达时间</th>
                        <th>路线</th>
                        <th>票价</th>
                        <th>剩余票数</th>
                        <th>状态</th>
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
                            <td>${schedule.status}</td>
                            <td>
                                <c:if test="${schedule.status == '未发车' && schedule.capacity>0}">
                                    <a class="layui-btn layui-btn-normal" href="${pageContext.request.contextPath}/addTicketServlet?id=${schedule.id}">预订</a>
                                </c:if>

                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </form>

            <ul>
                <c:if test="${pb.currentPage == 1}">
                <a href="javascript:return false;">
                    </c:if>
                    <c:if test="${pb.currentPage != 1}">
                    <a href="${pageContext.request.contextPath}/findScheduleNowByPageServlet?currentPage=${pb.currentPage-1}&rows=5&id=${condition.id[0]}&route=${condition.route[0]}">
                        </c:if>
                        <li class="page-li">上一页</li></a>

                    <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage == i}">
                    <a href="${pageContext.request.contextPath}/findScheduleNowByPageServlet?currentPage=${i}&rows=5&id=${condition.id[0]}&route=${condition.route[0]}"><li class="page-li" style="background-color: #009688;border-radius: 2px;color: white;">${i}</li></a>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                    <a href="${pageContext.request.contextPath}/findScheduleNowByPageServlet?currentPage=${i}&rows=5&id=${condition.id[0]}&route=${condition.route[0]}"><li class="page-li">${i}</li></a>
                    </c:if>
                    </c:forEach>

                    <c:if test="${pb.currentPage == pb.totalPage}">
                    <a href="javascript:return false;">
                        </c:if>
                        <c:if test="${pb.currentPage != pb.totalPage}">
                        <a href="${pageContext.request.contextPath}/findScheduleNowByPageServlet?currentPage=${pb.currentPage+1}&rows=5&id=${condition.id[0]}&route=${condition.route[0]}">
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
<%--导航和布局：--%>
<%--使用了LayUI的布局类 layui-layout-body 和 layui-layout layui-layout-admin，并包含了乘客导航栏和学生头部信息。--%>
<%--面包屑导航：--%>
<%--使用 layui-breadcrumb 类展示面包屑导航，显示了乘客、车票信息和购票的链接顺序。--%>
<%--查询表单：--%>
<%--使用 <form> 标签实现班次查询功能，通过输入班次号和路线来进行条件查询。--%>
<%--提交的目标是 ${pageContext.request.contextPath}/findScheduleNowByPageServlet，使用 POST 方法提交。--%>
<%--班次信息展示表格：--%>
<%--使用 <table> 和 <thead> 标签定义表头，展示班次的各项信息，包括班次号、发车时间、到达时间、路线、票价、剩余票数、状态和操作。--%>
<%--使用 <c:forEach> 标签遍历 ${pb.list} 中的班次信息，并展示在表格中。--%>
<%--    操作列根据班次状态和票数动态显示预订按钮。--%>
<%--    分页链接：--%>
<%--    使用 <ul> 和 <li> 标签实现分页功能，通过 ${pb.currentPage}、${pb.totalPage} 和条件参数生成相应的分页链接。--%>
<%--    记录数和页数信息：--%>
<%--    使用 <fieldset> 和 <legend> 显示当前查询结果的总记录数 ${pb.totalCount} 和总页数 ${pb.totalPage}。--%>
<%--    底部页脚：--%>
<%--    使用 <jsp:include> 包含了页脚信息。--%>
<script type="text/javascript">
    $("#nav li:nth-child(2) dl dd:nth-child(1)").addClass("layui-this");
    $("#nav li:nth-child(2)").addClass("layui-nav-itemed");
</script>
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
</script>
<%--导航栏样式设置：--%>
<%--使用 jQuery 设置特定位置导航栏的样式，突出显示当前页面位置。--%>
<%--LayUI元素初始化：--%>
<%--使用 layui.use('element', ...) 初始化LayUI的 element 元素。--%>
<%--删除班次确认函数：--%>
<%--deleteSchedule(id) 用于确认是否删除指定班次。--%>
<%--全选/全不选功能：--%>
<%--使用 document.getElementById("firstCb").onclick 实现全选和全不选功能。--%>
<%--页面加载完成事件：--%>
<%--window.onload 函数设置页面加载完成后执行的操作。--%>
</body>
</html>
