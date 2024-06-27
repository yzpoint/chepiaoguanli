<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TITLE</title>
</head>
<body>

<%
    if (session.getAttribute("user")!=null) {
%>
<jsp:forward page = "/WEB-INF/student/sIndex.jsp"/>
<%
}else if (session.getAttribute("admin")!=null) {
%>
<jsp:forward page = "/WEB-INF/admin/aIndex.jsp"/>
<%
}else {
%>
<jsp:forward page = "login.jsp" />
<%
    }
%>
</body>
</html>
<%--<%@ page ... %> 指令:--%>

<%--定义了页面的编码和语言类型。--%>
<%--登录状态判断:--%>

<%--使用了 <% ... %> 语法，这是 JSP 的脚本元素，用于在页面中插入 Java 代码。--%>
<%--Session 属性检查:--%>

<%--session.getAttribute("user") 和 session.getAttribute("admin") 分别检查了名为 "user" 和 "admin" 的会话属性是否存在，来判断用户的登录状态。--%>
<%--重定向:--%>

<%--如果 session.getAttribute("user") 返回非空，则将请求重定向到 /WEB-INF/student/sIndex.jsp 页面。--%>
<%--如果 session.getAttribute("admin") 返回非空，则将请求重定向到 /WEB-INF/admin/aIndex.jsp 页面。--%>
<%--如果以上两个条件均不满足（即用户未登录或会话已过期），则将请求重定向到 login.jsp 页面。--%>
<%--解释--%>
<%--<jsp:forward> 标签:--%>

<%--    用于将请求转发到另一个资源（页面或者 Servlet）。--%>
<%--    根据不同的条件，选择性地将用户引导到不同的页面。--%>
<%--    使用 session.getAttribute():--%>

<%--    通过 session.getAttribute("user") 和 session.getAttribute("admin") 方法来检查会话中是否存在特定的属性。--%>
<%--    如果属性存在且非空，则意味着用户已登录。--%>
<%--    条件判断:--%>

<%--    根据不同的会话属性值，决定将请求重定向到不同的页面。--%>
<%--    这种方式可以根据用户的角色或权限动态展示不同的内容或功能。--%>
<%--    使用场景--%>
<%--    登录控制:--%>

<%--    用于控制用户登录后的页面访问权限，确保只有经过身份验证的用户才能访问敏感信息或执行特定操作。--%>
<%--    页面分发:--%>

<%--    在 Web 应用中，根据用户类型或角色，将请求发送到不同的页面以提供定制化的用户体验。--%>