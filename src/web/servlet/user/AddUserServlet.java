package web.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

//        CDCService service2 = new CDCServiceImpl();
//        List<CDC> collegeList = service2.findAllCollege();
//        List<CDC> departmentList = service2.findAllDepartment();
//        List<CDC> classList = service2.findAllClass();

//        session.setAttribute("collegeLists",collegeList);
//        session.setAttribute("departmentLists",departmentList);
//        session.setAttribute("classLists",classList);

        request.getRequestDispatcher("/WEB-INF/admin/addUser.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//doPost 方法处理POST请求。首先设置请求的字符编码为UTF-8。
//获取当前会话 (session)，尽管在当前代码中并未使用。
//注释部分的代码段可能是用来获取学院、部门、班级等数据，并设置到会话中的，但在当前情况下是被注释掉的。
//最后，通过 request.getRequestDispatcher("/WEB-INF/admin/addUser.jsp").forward(request, response);
//将请求转发到位于 WEB-INF/admin/ 目录下的 addUser.jsp 页面，
//这样页面的访问只能通过后端的转发，提高了安全性。
//
//doGet 方法直接调用了 doPost 方法，确保无论是GET还是POST请求，最终都会执行用户添加页面的转发逻辑。