package web.servlet.schedule;


import domain.Schedule;

import service.ScheduleService;

import service.impl.ScheduleServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateScheduleServlet")
public class UpdateScheduleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
//        session.setAttribute("sid",studentid);


        ScheduleService service = new ScheduleServiceImpl();
        Schedule schedule = service.findById(id);
        request.setAttribute("schedule",schedule);

        request.getRequestDispatcher("/WEB-INF/admin/updateSchedule.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//doPost方法：处理POST请求。首先设置请求的字符编码为UTF-8，以确保能正确处理中文等特殊字符。
//获取当前会话的HttpSession对象。
//从请求中获取参数id，这是要更新的班次的唯一标识。
//使用ScheduleServiceImpl创建ScheduleService对象，并调用其findById(id)方法获取对应id的Schedule对象。
//将获取到的Schedule对象存储为请求属性 "schedule"，以便后续JSP页面(updateSchedule.jsp)使用。
//将请求转发至"/WEB-INF/admin/updateSchedule.jsp"，这个JSP页面将显示并允许编辑该班次的详细信息。
//doGet方法：处理GET请求。直接调用doPost(request, response)方法，实现GET和POST请求的统一处理逻辑，确保请求都由doPost方法处理。