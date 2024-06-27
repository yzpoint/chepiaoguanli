<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询车票</title>
    <link rel="stylesheet" href="./css/layui.css">
    <link rel="stylesheet" href="./css/style.css">
    <script src="./layui.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
<body class="layui-layout-body" style="background-color: #F2F2F2">
<jsp:include page="/filterLogin.jsp"></jsp:include>
<c:if test="${flag == 'admin'}">
    <jsp:include page="/WEB-INF/admin/aHeader.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/admin/adminNav.jsp"></jsp:include>
</c:if>
<c:if test="${flag == 'user'}">
    <jsp:include page="/WEB-INF/student/sHeader.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/student/studentNav.jsp"></jsp:include>
</c:if>
<div class="layui-layout layui-layout-admin">
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <span class="layui-breadcrumb">
                <c:if test="${flag == 'admin'}">
                    <a href="">管理员</a>
                    <a href="">车票管理</a>
                    <a><cite>查询车票</cite></a>
                </c:if>
                <c:if test="${flag == 'user'}">
                    <a href="">乘客</a>
                    <a href="">车票信息</a>
                    <a><cite>车票列表</cite></a>
                </c:if>
            </span>

            <form style="padding-top: 20px;" action="${pageContext.request.contextPath}/findTickByPageServlet" method="post">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <a class="layui-btn layui-btn-danger" href="javascript:void(0);" id="deleteSelectTicket">导出</a>
                    </div>
                </div>
            </form>

            <form id="selectTicket" action="${pageContext.request.contextPath}/deleteSelectTicketServlet" method="post">
                <table class="layui-table" lay-filter="test">
                    <thead>
                    <tr>
                        <th><input id="firstCb" type="checkbox" class="my-checkbox" name="" title="" lay-skin="primary"></th>
                        <th>乘客姓名</th>
                        <th>班次号</th>
                        <th>路线</th>
                        <th>发车时间</th>
                        <th>到达时间</th>
                        <th>金额</th>
                        <th>出发日期</th>
                        <th>下单日期</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>

                    <c:forEach items="${pb.list}" var="ticket" varStatus="s">
                        <tr>
                            <th><input type="checkbox" class="my-checkbox" name="id" value="${ticket.id}" title="" lay-skin="primary"></th>
                            <td>${ticket.name}</td>
                            <td>${ticket.scheduleCode}</td>
                            <td>${ticket.route}</td>
                            <td>${ticket.departureTime}</td>
                            <td>${ticket.arrivalTime}</td>
                            <td>${ticket.ticketPrice}</td>
                            <td>${ticket.ticketDate}</td>
                            <td>${ticket.ticketDate}</td>
                            <td>${ticket.status}</td>
                                <%--                            <td><c:choose>--%>
                                <%--                                <c:when test="${ticket.departureTime <= now}">已乘车</c:when>--%>
                                <%--                                <c:otherwise>未乘车</c:otherwise>--%>
                                <%--                            </c:choose></td>--%>
                            <td>
                                <c:if test="${ticket.status2 == 1 && ticket.status == '已购票'}">
                                    <a class="layui-btn layui-btn-normal" href="${pageContext.request.contextPath}/updateTicketServlet?id=${ticket.id}">退票</a>
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
                    <a href="${pageContext.request.contextPath}/findTickByPageServlet?currentPage=${pb.currentPage-1}&rows=5&id=${condition.id[0]}&passenger=${condition.passenger[0]}">
                        </c:if>
                        <li class="page-li">上一页</li></a>

                    <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage == i}">
                    <a href="${pageContext.request.contextPath}/findTickByPageServlet?currentPage=${i}&rows=5&id=${condition.id[0]}&passenger=${condition.passenger[0]}"><li class="page-li" style="background-color: #009688;border-radius: 2px;color: white;">${i}</li></a>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                    <a href="${pageContext.request.contextPath}/findTickByPageServlet?currentPage=${i}&rows=5&id=${condition.id[0]}&passenger=${condition.passenger[0]}"><li class="page-li">${i}</li></a>
                    </c:if>
                    </c:forEach>

                    <c:if test="${pb.currentPage == pb.totalPage}">
                    <a href="javascript:return false;">
                        </c:if>
                        <c:if test="${pb.currentPage != pb.totalPage}">
                        <a href="${pageContext.request.contextPath}/findTickByPageServlet?currentPage=${pb.currentPage+1}&rows=5&id=${condition.id[0]}&passenger=${condition.passenger[0]}">
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
    function deleteTicket(id) {
        if (confirm("你确定删除该车票吗？")) {
            location.href = "${pageContext.request.contextPath}/deleteTicketServlet?id=" + id;
        }
    }

    window.onload = function () {
        document.getElementById("deleteSelectTicket").onclick = function () {
            var newWindow = window.open('${pageContext.request.contextPath}/download', '_blank');
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
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>：指定页面的内容类型和字符编码为UTF-8，使用Java语言。--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>：引入JSTL核心标签库，为JSP页面提供基本的控制流和模板化功能。--%>
<%--<head>部分定义页面的标题、引入的样式表和JavaScript资源。--%>
<%--    <title>查询车票</title>：页面标题为“查询车票”。--%>
<%--    <link>：引入layui和自定义样式表。--%>
<%--    <script>：引入layui和jQuery的JavaScript资源。--%>
<%--<body>部分定义页面的整体布局和样式，使用layui的布局和样式。--%>
<%--使用了 <jsp:include> 标签包含了登录过滤器、管理员和用户的头部以及导航。--%>
<%--使用 <span class="layui-breadcrumb"> 定义面包屑导航，根据用户类型（管理员或用户）显示不同的导航链接。--%>
<%--导出按钮：使用 <form> 标签定义了一个表单，通过 ${pageContext.request.contextPath} 指定后端处理车票导出的Servlet路径。--%>
<%--车票信息展示表格：使用 <table> 标签展示车票信息，通过 JSTL 的 <c:forEach> 标签循环展示每一条车票信息，包括乘客姓名、班次号、路线、发车时间、到达时间、金额、出发日期、下单日期、状态以及操作（例如退票）。--%>
<%--分页导航：使用 <ul> 和 <li> 标签实现分页功能，根据 ${pb.currentPage}、${pb.totalPage} 等 JSTL 变量控制分页逻辑和显示。--%>
<%--数据统计：--%>
<%--使用 <fieldset> 标签显示总记录数和总页数。--%>
<%--JavaScript脚本：--%>
<%--layui元素初始化：使用 layui 的 element.init() 初始化页面元素。--%>
<%--导出车票按钮点击事件：定义了 deleteSelectTicket 按钮的点击事件，点击后通过 window.open 打开一个新窗口执行导出操作。--%>
<%--全选功能：定义了 firstCb 复选框的点击事件，实现全选和取消全选的功能。--%>
<%--导航栏样式处理：使用 jQuery 为导航栏添加样式，表明当前页面位置。--%>