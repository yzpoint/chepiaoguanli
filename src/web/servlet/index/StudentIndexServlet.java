package web.servlet.index;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentIndexServlet")
public class StudentIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/student/sIndex.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//doPost 方法：
//
//处理 POST 请求，将请求转发到 sIndex.jsp 页面。
//使用 request.getRequestDispatcher("/WEB-INF/student/sIndex.jsp").forward(request, response); 将请求和响应对象转发到 sIndex.jsp 页面。这样可以确保客户端的 URL 不会改变，并且数据可以从 servlet 传递到 JSP 页面。
//doGet 方法：
//
//调用 doPost 方法，确保 GET 请求也能正常处理。这样可以简化代码，保证无论是 GET 还是 POST 请求，都能执行相同的逻辑。