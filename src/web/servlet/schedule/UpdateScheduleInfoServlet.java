package web.servlet.schedule;



import domain.Schedule;

import service.ScheduleService;

import service.impl.ScheduleServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

@WebServlet("/updateScheduleInfoServlet")
public class UpdateScheduleInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
//        HttpSession session = request.getSession();

        String id = request.getParameter("id");
        String scheduleCode = request.getParameter("scheduleCode");
        String route = request.getParameter("route");
        String departureTime = request.getParameter("departureTime");
        String arrivalTime = request.getParameter("arrivalTime");
        String ticketPrice = request.getParameter("ticketPrice");
        String capacity = request.getParameter("capacity");

        Schedule updateStudent = new Schedule();
        updateStudent.setId(Integer.parseInt(id));
        updateStudent.setScheduleCode(scheduleCode);
        updateStudent.setRoute(route);
        updateStudent.setDepartureTime(departureTime);
        updateStudent.setArrivalTime(arrivalTime);
        updateStudent.setTicketPrice(new BigDecimal(ticketPrice));
        updateStudent.setCapacity(Integer.parseInt(capacity));
        //调用studentUpdata服务
        ScheduleService service= new ScheduleServiceImpl();
        service.updateInfo(updateStudent);
        response.sendRedirect("findScheduleByPageServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//Servlet 注解和配置：
//
//@WebServlet("/updateScheduleInfoServlet")：指定 Servlet 的访问 URL。
//doPost 方法：
//
//设置请求编码为 UTF-8。
//获取表单提交的班次信息参数：id, scheduleCode, route, departureTime, arrivalTime, ticketPrice, capacity。
//创建 Schedule 对象 updateSchedule，并通过 set 方法设置各个属性。
//实例化 ScheduleService 接口的实现类 ScheduleServiceImpl。
//调用 service.updateInfo(updateSchedule) 方法更新班次信息。
//使用 response.sendRedirect("findScheduleByPageServlet") 重定向到查询班次信息的页面，以便更新后能立即看到更新结果。
//doGet 方法：
//
//实现 GET 请求的处理逻辑，直接调用 doPost 方法处理 GET 请求。