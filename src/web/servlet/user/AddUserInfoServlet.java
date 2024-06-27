package web.servlet.user;

import domain.Schedule;
import domain.User;
import service.ScheduleService;
import service.UserService;
import service.impl.ScheduleServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

@WebServlet("/addUserInfoServlet")
public class AddUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserService service= new UserServiceImpl();
        //先进行判断是否已存在该班次号
        String userName = request.getParameter("userName");
        User s = new User();
        s.setUserName(userName);
        User newStudent = service.findByUserName(userName);
        if (newStudent != null) {
            request.setAttribute("update_msg","已存在该用户名，请重新添加！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("addUserServlet").forward(request, response);
        }else {
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String email = request.getParameter("email");

            User updateStudent = new User();
            updateStudent.setUserName(userName);
            updateStudent.setPassword(password);
            updateStudent.setName(name);
            updateStudent.setEmail(email);
            service.addUser(updateStudent);
            request.setAttribute("update_msg","添加成功！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("findUserByPageServlet").forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//doPost 方法处理POST请求。首先通过 request.setCharacterEncoding("utf-8") 设置请求的字符编码为UTF-8。
//创建 UserService 的实例，并调用其方法来处理用户信息。
//从请求中获取用户名 (userName)，并根据用户名查询是否已存在该用户。
//如果已存在该用户 (existingUser != null)，设置错误消息 (update_msg) 并转发到添加用户页面重新添加。
//如果用户名不存在，则从请求中获取密码 (password)、姓名 (name) 和邮箱 (email)，创建一个新的 User 对象并调用 service.addUser(newUser) 方法添加新用户。
//最后设置成功消息 (update_msg) 并转发到查找用户页面 (findUserByPageServlet)。
//doGet 方法直接调用了 doPost 方法，确保无论是GET还是POST请求，最终都会执行用户信息添加的逻辑。