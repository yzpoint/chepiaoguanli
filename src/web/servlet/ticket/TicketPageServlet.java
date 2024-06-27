package web.servlet.ticket;

import domain.*;
import org.springframework.util.CollectionUtils;

import service.TicketService;

import service.impl.TicketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@WebServlet("/findTickByPageServlet")
public class TicketPageServlet extends HttpServlet {
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
        User user = (User) request.getSession().getAttribute("user");

        //获取条件查询参数
        Map<String,String[]> condition = request.getParameterMap();
        Ticket params = new Ticket();
        if(user != null){
            params.setUserName(user.getUserName());
        }

        TicketService service = new TicketServiceImpl();
        PageBean<Ticket> pb =  service.findByPage(currentPage,rows,condition,params);
        List<Ticket> ticketList = pb.getList();
        if(!CollectionUtils.isEmpty(ticketList)){
            ticketList.forEach(t->{
                try {
                    String time = t.getTicketDate()+" "+t.getDepartureTime();
                    if(isAfterCurrentTime(time)){
                        t.setStatus2(1);
                    }else {
                        t.setStatus2(0);
                    }
                }catch (Exception e){
                    t.setStatus2(0);
                }

            });
        }

        request.setAttribute("pb",pb);
        request.setAttribute("flag",request.getSession().getAttribute("role"));
        request.setAttribute("condition",condition);//存入查询条件
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        request.getRequestDispatcher("/WEB-INF/admin/ticket.jsp").forward(request, response);

    }

    public static boolean isAfterCurrentTime(String dateTimeString) {
        // Define the format for the input date-time string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Parse the input date-time string into LocalDateTime
        LocalDateTime inputDateTime = LocalDateTime.parse(dateTimeString, formatter);

        // Get the current date-time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Compare the input date-time with current date-time
        return inputDateTime.isAfter(currentDateTime);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//doPost方法：处理POST请求。首先设置请求字符编码为UTF-8，并获取当前页码和每页显示条数。
//如果当前页码或每页显示条数为空，则设置默认值。
//从会话中获取当前登录用户信息。
//获取条件查询参数，并根据当前用户设置查询参数。
//创建TicketService实例，调用findByPage方法进行分页查询，将结果存储在pb中。
//对查询结果进行处理，判断每个车票的状态是否已过期，调用isAfterCurrentTime方法进行判断。
//设置请求属性，包括分页数据、用户角色信息和查询条件，并将请求转发到/WEB-INF/admin/ticket.jsp页面。
//
//isAfterCurrentTime方法：静态方法，用于判断给定的日期时间字符串是否晚于当前时间。
//使用DateTimeFormatter定义日期时间格式为"yyyy-MM-dd HH:mm
//        "。
//将输入的日期时间字符串解析为LocalDateTime对象。
//获取当前时间的LocalDateTime对象。
//比较输入的日期时间和当前时间，返回比较结果。
//
//doGet方法：处理GET请求。直接调用doPost(request, response)方法，实现GET和POST请求的统一处理逻辑，确保请求都由doPost方法处理。