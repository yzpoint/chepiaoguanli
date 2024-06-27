package web.servlet.ticket;



import domain.Schedule;
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

@WebServlet("/updateTicketServlet")
public class UpdateTicketInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
//        HttpSession session = request.getSession();

        String id = request.getParameter("id");

        TicketService service= new TicketServiceImpl();
        service.updateStatus(id);
        response.sendRedirect("findTickByPageServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//doPost 方法处理POST请求。首先通过 request.setCharacterEncoding("utf-8") 设置请求的字符编码为UTF-8。
//然后从请求参数中获取参数名为 "id" 的值，这是票务的唯一标识。
//创建 TicketService 的实例，并调用其 updateStatus(id) 方法来更新票务状态，传入的参数是从请求中获取的票务ID。
//最后调用 response.sendRedirect("findTickByPageServlet") 将请求重定向到另一个Servlet，
// 即 findTickByPageServlet，用于查找并显示票务信息。
//
//doGet 方法直接调用了 doPost 方法，实现了GET请求与POST请求的统一处理，使得无论是GET还是POST请求，
// 最终都会执行更新票务信息的逻辑。