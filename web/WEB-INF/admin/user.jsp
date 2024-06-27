<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询乘客</title>
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
                <a href="">乘客管理</a>
                <a><cite>查询乘客</cite></a>
            </span>


            <form id="selectPassenger" action="${pageContext.request.contextPath}/deleteSelectPassengerServlet" method="post">
                <table class="layui-table" lay-filter="test">
                    <thead>
                    <tr>
                        <th><input id="firstCb" type="checkbox" class="my-checkbox" name="" title="" lay-skin="primary"></th>

                        <th>用户名</th>
                        <th>真实姓名</th>
                        <th>邮箱</th>

                    </tr>
                    </thead>

                    <c:forEach items="${pb.list}" var="passenger" varStatus="s">
                        <tr>
                            <th><input type="checkbox" class="my-checkbox" name="id" value="${passenger.id}" title="" lay-skin="primary"></th>

                            <td>${passenger.userName}</td>
                            <td>${passenger.name}</td>
                            <td>${passenger.email}</td>
                        </tr>
                    </c:forEach>
                </table>
            </form>

            <ul>
                <c:if test="${pb.currentPage == 1}">
                <a href="javascript:return false;">
                    </c:if>
                    <c:if test="${pb.currentPage != 1}">
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage-1}&rows=5&id=${condition.id[0]}&name=${condition.name[0]}">
                        </c:if>
                        <li class="page-li">上一页</li></a>

                    <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage == i}">
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&id=${condition.id[0]}&name=${condition.name[0]}"><li class="page-li" style="background-color: #009688;border-radius: 2px;color: white;">${i}</li></a>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&id=${condition.id[0]}&name=${condition.name[0]}"><li class="page-li">${i}</li></a>
                    </c:if>
                    </c:forEach>

                    <c:if test="${pb.currentPage == pb.totalPage}">
                    <a href="javascript:return false;">
                        </c:if>
                        <c:if test="${pb.currentPage != pb.totalPage}">
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage+1}&rows=5&id=${condition.id[0]}&name=${condition.name[0]}">
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
    function deletePassenger(id) {
        if (confirm("你确定删除该乘客吗？")) {
            location.href = "${pageContext.request.contextPath}/deletePassengerServlet?id=" + id;
        }
    }

    window.onload = function () {
        document.getElementById("deleteSelectPassenger").onclick = function () {
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
                    document.getElementById("selectPassenger").submit();
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
    $("#nav li:nth-child(5)").addClass("layui-nav-itemed");
</script>

</body>
</html>
<%--页面指令和标签库引入：--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>：指定页面的内容类型和字符编码为UTF-8，使用Java语言。--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>：引入JSTL核心标签库，为JSP页面提供基本的控制流和模板化功能。--%>
<%--HTML头部：--%>

<%--<head>部分定义页面的标题、引入的样式表和JavaScript资源。--%>
<%--    <title>查询乘客</title>：页面标题为“查询乘客”。--%>
<%--    <link>：引入layui和自定义样式表。--%>
<%--    <script>：引入layui和jQuery的JavaScript资源。--%>
<%--页面主体：--%>

<%--<body>部分定义页面的整体布局和样式，使用layui的布局和样式。--%>
<%--使用了 <jsp:include> 标签包含了登录过滤器、管理员的头部和导航。--%>
<%--内容区域：--%>

<%--使用 <span class="layui-breadcrumb"> 定义面包屑导航，显示管理员、乘客管理和查询乘客的链接顺序。--%>
<%--查询表单：通过 <form> 标签实现了一个包含乘客信息列表和选择框的表格。--%>
<%--使用了 layui 的表格 (layui-table) 和复选框 (lay-skin="primary")。--%>
<%--<c:forEach> 标签遍历 ${pb.list} 中的乘客信息，展示每个乘客的用户名、真实姓名和邮箱。--%>
<%--分页链接：使用 <ul> 和 <li> 标签实现了分页功能，通过 ${pb.currentPage}、${pb.totalPage} 和条件参数生成相应的分页链接。--%>
<%--    每页显示5条记录 (rows=5)。--%>
<%--记录数和页数信息：使用 <fieldset> 和 <legend> 显示当前查询结果的总记录数 ${pb.totalCount} 和总页数 ${pb.totalPage}。--%>
<%--JavaScript脚本：--%>

<%--layui元素初始化：使用 layui 的 element.init() 初始化页面元素。--%>
<%--删除乘客信息确认：定义了 deletePassenger(id) 函数，用于确认是否删除单个乘客信息。--%>
<%--删除选中乘客信息确认：通过 document.getElementById("deleteSelectPassenger").onclick 实现，确认是否删除选中的乘客信息。--%>
<%--全选/全不选功能：通过 document.getElementById("firstCb").onclick 实现全选和全不选功能，操作名称为 id 的复选框。--%>
<%--导航栏样式设置：使用 jQuery 设置导航栏中特定位置的样式，突出显示当前页面位置。--%>
