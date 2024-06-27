package web.servlet.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("teacher");
        session.removeAttribute("admin");
        session.invalidate();
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//doPost 方法：
//
//设置编码：确保正确解析请求中的中文参数。
//获取当前 session。
//移除 session 中的特定属性：
//        "user"：用于普通用户登录时保存的信息。
//        "teacher"：可能是指教师角色的登录信息（虽然在代码中没有特别处理，但在 LoginServlet 中可能有相关处理）。
//        "admin"：管理员角色的登录信息。
//调用 invalidate() 方法使当前 session 失效，即清除所有 session 数据。
//最后，通过 response.sendRedirect("index.jsp") 将用户重定向到项目的首页 index.jsp。
//doGet 方法：
//
//调用 doPost 方法，确保 GET 请求也能处理相同的逻辑。