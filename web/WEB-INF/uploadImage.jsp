<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--<%@ page ... %>：JSP页面指令，设置页面的语言为Java，内容类型为HTML，并且指定字符编码为UTF-8。--%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">：DOCTYPE声明，标识HTML文档类型和版本。--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%--<html>：HTML根元素。--%>
<%--<head>：HTML头部，包含页面的元数据。--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">：设置页面的字符编码为UTF-8。--%>
<%--    <title>Insert title here</title>：页面标题，可以根据实际需求修改。--%>
<img src="${pageContext.request.contextPath}/showPhotoServlet">
<form action="${pageContext.request.contextPath}/uploadImageServlet" method="post" enctype="multipart/form-data">
    <input  type="file" name="images">
    <button  type="submit"  name="upload">上传</button>
</form>
<%--<img src="${pageContext.request.contextPath}/showPhotoServlet">：显示图片的标签，使用${pageContext.request.contextPath}获取应用的上下文路径，结合/showPhotoServlet来请求显示图片的Servlet。--%>
<%--<form action="${pageContext.request.contextPath}/uploadImageServlet" method="post" enctype="multipart/form-data">：表单元素，使用POST方法向${pageContext.request.contextPath}/uploadImageServlet提交文件，设置表单编码类型为multipart/form-data，以支持文件上传。--%>
<%--    <input type="file" name="images">：文件上传输入框，用户可以选择要上传的图片文件。--%>
<%--    <button type="submit" name="upload">上传</button>：提交按钮，点击后将选择的图片文件上传到服务器。--%>
</body>
</html>