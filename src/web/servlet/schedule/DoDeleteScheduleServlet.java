package web.servlet.schedule;


import service.ScheduleService;

import service.impl.ScheduleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteScheduleServlet")
public class DoDeleteScheduleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        ScheduleService service = new ScheduleServiceImpl();
        service.deleteServiceById(id);
        response.sendRedirect("findScheduleByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//doPost 方法：
//
//设置请求编码为 UTF-8，确保能正确处理中文参数。
//获取当前会话 (HttpSession)。
//获取请求参数 id，即要删除的班次的 ID。
//创建 ScheduleService 的实例，用于处理班次信息的业务逻辑。
//调用 ScheduleService 的 deleteServiceById 方法，根据传入的班次 ID 删除对应的班次信息。
//删除成功后，重定向到查询班次列表的 Servlet (findScheduleByPageServlet)，以显示更新后的班次信息列表。
//doGet 方法：
//
//调用 doPost 方法，确保 GET 请求也能处理相同的逻辑。