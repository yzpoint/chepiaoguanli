package web.servlet.ticket;

import domain.Schedule;
import domain.Ticket;
import domain.User;
import service.ScheduleService;
import service.TicketService;
import service.impl.ScheduleServiceImpl;
import service.impl.TicketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/addTicketServlet")
public class AddTicketInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //先进行判断是否已存在该班次号
        String id = request.getParameter("id");
        ScheduleService service= new ScheduleServiceImpl();
        Schedule schedule = service.findById(id);
        User user = (User) request.getSession().getAttribute("user");
        Ticket ticket = new Ticket();
        ticket.setUserName(user.getUserName());
        ticket.setName(user.getName());
        ticket.setScheduleId(schedule.getId());
        ticket.setScheduleCode(schedule.getScheduleCode());
        ticket.setRoute(schedule.getRoute());
        ticket.setDepartureTime(schedule.getDepartureTime());
        ticket.setArrivalTime(schedule.getArrivalTime());
        LocalDate currentDate = LocalDate.now();
        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Format the current date
        String formattedDate = currentDate.format(formatter);
        ticket.setTicketDate(formattedDate);
        ticket.setTicketPrice(schedule.getTicketPrice());
        TicketService ticketService = new TicketServiceImpl();

        ticketService.addTicket(ticket);
        request.setAttribute("update_msg","添加成功！"+String.format("%tT",new Date()));
        response.sendRedirect("findTickByPageServlet");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//doPost方法：处理POST请求。首先设置请求的字符编码为UTF-8，以确保能正确处理中文等特殊字符。
//从请求中获取参数id，即要添加车票的班次ID。
//使用ScheduleServiceImpl创建ScheduleService对象，并调用其findById(id)方法获取对应id的Schedule对象。
//从当前会话的属性中获取user对象，表示当前登录用户。
//创建一个新的Ticket对象，将用户和班次的相关信息设置到Ticket对象中。
//获取当前日期并格式化为"yyyy-MM-dd"格式，设置到Ticket对象的ticketDate属性中。
//使用TicketServiceImpl创建TicketService对象，并调用其addTicket(ticket)方法将新的车票信息添加到系统中。
//将成功添加的消息存储为请求属性 "update_msg"，并重定向到"findTickByPageServlet"，即查找车票信息的Servlet页面，以显示更新后的信息。
//doGet方法：处理GET请求。直接调用doPost(request, response)方法，实现GET和POST请求的统一处理逻辑，确保请求都由doPost方法处理。