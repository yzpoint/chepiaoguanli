package web.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userIndexServlet")
public class UserIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/student/sIndex.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//doPost 方法处理POST请求。使用 request.getRequestDispatcher().forward(request, response)
//方法将请求转发到位于 WEB-INF/student/sIndex.jsp 的页面。
//WEB-INF 目录下的资源不能直接被客户端访问，这样可以保护页面的安全性。
//
//doGet 方法直接调用了 doPost 方法，确保无论是GET还是POST请求，最终都会执行相同的请求转发逻辑。