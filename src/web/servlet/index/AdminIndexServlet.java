package web.servlet.index;

import domain.Ticket;
import service.TicketService;
import service.impl.TicketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/adminIndexServlet")
public class AdminIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TicketService ticketService = new TicketServiceImpl();
        List<Ticket> ticketList = ticketService.findAll();
        List<Ticket> ticketList1 = ticketList.stream().filter(t->t.getStatus().
                equals("已购票")).collect(Collectors.toList());
        List<Ticket> ticketList2 = ticketList.stream().filter(t->t.getStatus().
                equals("已退票")).collect(Collectors.toList());
        request.setAttribute("ticketList",ticketList.size());
        request.setAttribute("ticketList1",ticketList1.size());
        request.setAttribute("ticketList2",ticketList2.size());
        request.getRequestDispatcher("/WEB-INF/admin/aIndex.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//doPost 方法：
//
//从 TicketService 中获取所有车票。
//使用 Java 8 的 Stream API 对车票列表进行过滤，分别获取状态为 "已购票" 和 "已退票" 的车票。
//将车票总数、已购票车票数和已退票车票数存储到请求属性中。
//转发请求到 aIndex.jsp 页面进行显示。
//doGet 方法：
//
//调用 doPost 方法，确保 GET 请求也能正常处理。