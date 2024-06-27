package web.servlet.schedule;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import domain.Schedule;
import service.ScheduleService;
import service.impl.ScheduleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@WebServlet("/excelUploadServlet")
@MultipartConfig
public class ExcelUploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the file part from the request
        Part filePart = request.getPart("file");

        // Get input stream from the file part
        InputStream inputStream = filePart.getInputStream();

        // Configure listener to handle Excel data
        AnalysisEventListener<Map<String,String>> listener = new AnalysisEventListener<Map<String,String>>() {
            @Override
            public void invoke(Map<String,String> data, AnalysisContext context) {
                // Handle each row of data here
                ScheduleService service= new ScheduleServiceImpl();
                String scheduleCode = data.get(0);
                Integer newStudent = service.findByScheduleCode(scheduleCode);
                if (newStudent >0) {
                    return;
                }else {
                    String route = data.get(3);
                    String departureTime = data.get(1);
                    String arrivalTime = data.get(2);
                    String ticketPrice = data.get(4);
                    String capacity = data.get(5);

                    Schedule updateStudent = new Schedule();

                    updateStudent.setScheduleCode(scheduleCode);
                    updateStudent.setArrivalTime(arrivalTime);
                    updateStudent.setDepartureTime(departureTime);
                    updateStudent.setRoute(route);
                    updateStudent.setCapacity(Integer.parseInt(capacity));
                    updateStudent.setTicketPrice(new BigDecimal(ticketPrice));


                    service.addSchedule(updateStudent);


                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                // After all data is read
                System.out.println("All data read.");
            }
        };

        // Build Excel reader
        ExcelReaderBuilder excelReaderBuilder = EasyExcel.read(inputStream, listener);

        // Start reading
        excelReaderBuilder.sheet().doRead();

        // Close input stream
        inputStream.close();
        response.sendRedirect("findScheduleByPageServlet");
    }
}
//Servlet 注解和配置：
//
//@WebServlet("/excelUploadServlet")：指定 Servlet 的访问 URL。
//@MultipartConfig：标注支持文件上传。
//doPost 方法：
//
//设置请求编码为 UTF-8。
//获取上传的文件部分 (Part)。
//从 Part 中获取输入流 (InputStream)。
//创建一个 Excel 解析的事件监听器 (AnalysisEventListener)，处理 Excel 文件中每一行的数据。
//在 invoke 方法中，根据每一行数据中的班次号 (scheduleCode)，检查数据库中是否已存在该班次号。
//如果存在，跳过当前数据行。
//如果不存在，解析该行数据并创建一个新的 Schedule 对象，然后调用 ScheduleService 的 addSchedule 方法添加班次信息。
//在 doAfterAllAnalysed 方法中，所有数据行都读取完成后执行必要的后续操作（在此处打印一条消息）。
//使用 EasyExcel 提供的 ExcelReaderBuilder 构建 Excel 读取器，并开始读取数据。
//读取完成后关闭输入流。
//最后，重定向到查询班次列表的 Servlet (findScheduleByPageServlet)，以展示更新后的班次列表。

