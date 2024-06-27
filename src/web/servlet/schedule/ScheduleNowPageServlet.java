package web.servlet.schedule;

import domain.PageBean;
import domain.Schedule;
import domain.Ticket;
import javafx.print.Collation;
import org.springframework.util.CollectionUtils;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/findScheduleNowByPageServlet")
public class ScheduleNowPageServlet extends HttpServlet {
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
        TicketService ticketService = new TicketServiceImpl();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Format the current date
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(formatter);
        List<Ticket> ticketList = ticketService.findAll();
        ticketList = ticketList.stream().filter(t->t.getTicketDate().equals(formattedDate)).collect(Collectors.toList());
        ticketList = ticketList.stream().filter(t->t.getStatus().equals("已购票")).collect(Collectors.toList());
        Map<String, Integer> trainCountMap = new HashMap<>();

        // 遍历 ticketList，统计每个车次的数量
        for (Ticket ticket : ticketList) {
            String trainNumber = ticket.getScheduleCode();
            trainCountMap.put(trainNumber, trainCountMap.getOrDefault(trainNumber, 0) + 1);
        }
        List<Schedule> scheduleList =  pb.getList();
        if(!CollectionUtils.isEmpty(scheduleList)){
            scheduleList.forEach(t->{
                try {
                    Integer count = trainCountMap.get(t.getScheduleCode());
                    if(count != null){
                        t.setCapacity((t.getCapacity()-count>0)?(t.getCapacity()-count):0);
                    }
                    if(isTimeNotExceeded(t.getDepartureTime())){
                        t.setStatus("未发车");
                    }else {
                        t.setStatus("已发车");
                    }
                }catch (Exception e){
                    t.setStatus("已发车");
                }

            });
        }
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        request.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("/WEB-INF/student/schedule_now.jsp").forward(request, response);

    }

    public static boolean isTimeNotExceeded(String timeToCompare) {
        // Parse the timeToCompare string into a LocalTime object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime compareTime = LocalTime.parse(timeToCompare, formatter);

        // Get the current time
        LocalTime currentTime = LocalTime.now();

        // Compare times
        return !currentTime.isAfter(compareTime);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//Servlet 注解和配置：
//
//@WebServlet("/findScheduleNowByPageServlet")：指定 Servlet 的访问 URL。
//doPost 方法：
//
//设置请求编码为 UTF-8。
//获取当前页码 (currentPage) 和每页显示条数 (rows)，如果没有指定则默认为 1 和 5。
//获取条件查询参数 (condition)。
//使用 ScheduleService 查询当前页的班次信息，并封装到 PageBean<Schedule> 中。
//获取今天的日期，并格式化为 yyyy-MM-dd 格式的字符串 (formattedDate)。
//使用 TicketService 查询所有今天已购票的票务信息。
//使用流操作过滤出今天已购票的票务信息，并根据班次号统计每个班次的购票数量。
//遍历 PageBean 中的班次列表 (scheduleList)，更新每个班次的剩余座位数和状态：
//根据购票数量更新剩余座位数。
//判断班次是否已发车，调用 isTimeNotExceeded 方法判断。
//设置请求属性 (pb 和 condition)，然后将请求转发到 /WEB-INF/student/schedule_now.jsp 页面。
//isTimeNotExceeded 方法：
//
//根据当前时间与给定的时间比较，判断是否未超过指定时间。
//doGet 方法：
//
//调用 doPost 方法，实现 GET 请求的处理逻辑。
