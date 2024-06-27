<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TITLE</title>
</head>
<body>
<%
    if (session.getAttribute("user")==null  && session.getAttribute("admin")==null) {
%>
<jsp:forward page = "login.jsp"/>
<%
    }
%>

</body>
</html>
<%--<%@ page ... %> 指令: 定义了页面的编码和语言类型。--%>

<%--HTML 结构:--%>

<%--<head> 部分只包含了一个 <title> 元素，显示在浏览器标签页上。--%>
<%--    <body> 部分包含了 Java 代码片段，用于动态生成页面内容。--%>
<%--    Java 代码片段:--%>

<%--    使用 <% ... %> 标记包裹了一段 Java 代码。--%>
<%--    session.getAttribute("user") 和 session.getAttribute("admin") 用于检查用户是否已登录。这里假设在登录时，会将用户信息存储在 session 中的 user 或 admin 属性中。--%>
<%--    如果条件 session.getAttribute("user") == null && session.getAttribute("admin") == null 成立，表示用户未登录。此时，使用 <jsp:forward> 标签将请求转发到 login.jsp 页面，要求用户登录。--%>