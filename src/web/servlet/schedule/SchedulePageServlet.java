package web.servlet.schedule;

import domain.PageBean;
import domain.Schedule;
import domain.Ticket;
import service.ScheduleService;
import service.TicketService;
import service.impl.ScheduleServiceImpl;
import service.impl.TicketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findScheduleByPageServlet")
public class SchedulePageServlet extends HttpServlet {
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

        ScheduleService service = new ScheduleServiceImpl();
        PageBean<Schedule> pb =  service.findByPage(currentPage,rows,condition);

        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);//存入查询条件
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        request.getRequestDispatcher("/WEB-INF/admin/schedule.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//Servlet 注解和配置：
//
//@WebServlet("/findScheduleByPageServlet")：指定 Servlet 的访问 URL。
//doPost 方法：
//
//设置请求编码为 UTF-8。
//获取当前页码 (currentPage) 和每页显示条数 (rows)，如果没有指定则默认为 1 和 5。
//获取条件查询参数 (condition)，这些参数可以包含用户在页面上进行的筛选和搜索条件。
//使用 ScheduleService 查询当前页的班次信息，并封装到 PageBean<Schedule> 中。
//将查询结果 (pb) 和查询条件 (condition) 存入请求属性，以便在页面上进行展示和处理。
//获取 HttpSession 对象，并将请求转发到 /WEB-INF/admin/schedule.jsp 页面，进行页面展示。
//doGet 方法：
//
//实现 GET 请求的处理逻辑，直接调用 doPost 方法处理 GET 请求。