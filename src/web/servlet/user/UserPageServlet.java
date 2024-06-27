package web.servlet.user;

import domain.PageBean;
import domain.Ticket;
import domain.User;
import service.TicketService;
import service.UserService;
import service.impl.TicketServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class UserPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }

        //获取条件查询参数
        Map<String,String[]> condition = request.getParameterMap();

        UserService service = new UserServiceImpl();
        PageBean<User> pb =  service.findByPage(currentPage,rows,condition);

        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);//存入查询条件
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        request.getRequestDispatcher("/WEB-INF/admin/user.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//doPost 方法处理POST请求。首先设置请求的字符编码为UTF-8。
//获取请求中的当前页码 (currentPage) 和每页显示条数 (rows)，如果未指定则使用默认值。
//获取可能存在的条件查询参数 (condition)，这些参数可能包括搜索关键字、筛选条件等。
//创建 UserService 的实例，并调用其 findByPage 方法进行分页查询，返回一个 PageBean<User> 对象，其中包含了分页信息和查询结果。
//将查询结果 (pb) 和查询条件 (condition) 存入request属性中，以便在JSP页面中进行展示。
//使用 request.getRequestDispatcher().forward(request, response) 方法将请求转发到位于 WEB-INF/admin/user.jsp 的页面进行显示。
//这样设置可以确保页面只能通过后端转发访问，增加了安全性。
//
//doGet 方法直接调用了 doPost 方法，确保无论是GET还是POST请求，最终都会执行用户分页查询的处理逻辑。