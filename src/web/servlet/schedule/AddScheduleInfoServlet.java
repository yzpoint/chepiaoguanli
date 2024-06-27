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
import java.time.LocalDateTime;
import java.util.Date;

@WebServlet("/addScheduleInfoServlet")
public class AddScheduleInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ScheduleService service= new ScheduleServiceImpl();
        //先进行判断是否已存在该班次号
        String scheduleCode = request.getParameter("scheduleCode");
        Schedule s = new Schedule();
        s.setScheduleCode(scheduleCode);
        Integer newStudent = service.findByScheduleCode(scheduleCode);
        if (newStudent >0) {
            request.setAttribute("update_msg","已存在该车次，请重新添加！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("addScheduleServlet").forward(request, response);
        }else {
            String route = request.getParameter("route");
            String departureTime = request.getParameter("departureTime");
            String arrivalTime = request.getParameter("arrivalTime");
            String ticketPrice = request.getParameter("ticketPrice");
            String capacity = request.getParameter("capacity");

            Schedule updateStudent = new Schedule();

            updateStudent.setScheduleCode(scheduleCode);
            updateStudent.setArrivalTime(arrivalTime);
            updateStudent.setDepartureTime(departureTime);
            updateStudent.setRoute(route);
            updateStudent.setCapacity(Integer.parseInt(capacity));
            updateStudent.setTicketPrice(new BigDecimal(ticketPrice));


            service.addSchedule(updateStudent);
            response.sendRedirect("findScheduleByPageServlet");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//doPost 方法：
//
//设置请求编码为 UTF-8，确保能正确处理中文参数。
//创建 ScheduleService 的实例，用于处理班次信息的业务逻辑。
//获取请求参数 scheduleCode，即班次号。
//调用 ScheduleService 的 findByScheduleCode 方法，检查是否已经存在相同的班次号。
//如果班次号已存在 (count > 0)：
//设置错误消息并将其存储在请求属性中。
//转发到添加班次信息的页面 (addScheduleServlet)，以便用户重新输入。
//如果班次号不存在：
//继续获取其他参数：route (路线)，departureTime (发车时间)，arrivalTime (到达时间)，ticketPrice (票价)，capacity (容量)。
//创建 Schedule 对象并设置这些参数。
//调用 ScheduleService 的 addSchedule 方法，将新的班次信息添加到数据库。
//添加成功后，重定向到查询班次列表的 Servlet (findScheduleByPageServlet)。
//doGet 方法：
//
//调用 doPost 方法，确保 GET 请求也能处理相同的逻辑。