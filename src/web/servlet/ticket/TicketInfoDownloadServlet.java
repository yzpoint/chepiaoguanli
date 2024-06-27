package web.servlet.ticket;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
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
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/download")
public class TicketInfoDownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response headers
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"example.xlsx\"");

        // Create Excel data (example data)
        TicketService ticketService = new TicketServiceImpl();

        List<Ticket> dataList = ticketService.findAll();
        User user = (User) request.getSession().getAttribute("user");
        if(user != null){
            dataList = dataList.stream().filter(t->t.getUserName().equals(user.getUserName())).collect(Collectors.toList());
        }
        // Write Excel to output stream
        try (OutputStream outputStream = response.getOutputStream()) {
            ExcelWriterBuilder writerBuilder = EasyExcel.write(outputStream, Ticket.class);
            ExcelWriterSheetBuilder sheetBuilder = writerBuilder.sheet("Sheet1");
            sheetBuilder.doWrite(dataList);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//doPost方法：处理POST请求。首先设置响应的Content-Type为Excel格式，并设置Content-Disposition为attachment，以便浏览器下载该文件。
//获取所有的车票信息列表。
//获取当前会话中的用户对象，如果存在用户登录，则筛选出该用户的车票信息。
//使用EasyExcel库的ExcelWriterBuilder创建Excel写操作的构建器，并将车票信息写入Excel的Sheet1中。
//将生成的Excel文件通过响应流输出到客户端。
//doGet方法：处理GET请求。直接调用doPost(request, response)方法，实现GET和POST请求的统一处理逻辑，确保请求都由doPost方法处理。