package web.servlet.login;

import domain.*;
import org.apache.commons.beanutils.BeanUtils;
import service.*;
import service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin loginAdmin = null;

        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取数据
        String verifycode = request.getParameter("verifycode");
        String loginid = request.getParameter("id");
        String loginpassword = request.getParameter("password");

        //验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证一次性
        if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(verifycode)) {
            //验证码不正确
            request.setAttribute("login_msg","验证码错误");
            //跳转页面
            request.setAttribute("loginid",loginid);
            request.setAttribute("loginpassword",loginpassword);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        //封装对象
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String roles = request.getParameter("roles");


        //判断roles封装对象、保存session、调用不同Service查询
        if ("user".equals(roles)) {

            User student = new User();
            student.setUserName(id);
            student.setPassword(password);

            UserService service= new UserServiceImpl();
            User user = service.findByUserName(student.getUserName());

            if (user != null && user.getPassword().equals(student.getPassword())) {
                session.setAttribute("role", "user");
                session.setAttribute("user", user);
                session.setAttribute("html_title", "乘客端");
                response.sendRedirect("userIndexServlet");
            }else {
                //登录失败 提示信息
                request.setAttribute("login_msg", "用户名或密码错误！");
                request.setAttribute("loginid",loginid);
                request.setAttribute("loginpassword",loginpassword);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }else {

            Admin admin = new Admin();
            admin.setA_id(id);
            admin.setA_password(password);

            AdminService service = new AdminServiceImpl();
            loginAdmin = service.login(admin);

            if (loginAdmin != null) {
                session.setAttribute("role", "admin");
                session.setAttribute("admin", loginAdmin);
                session.setAttribute("html_title", "管理员");
//                request.getRequestDispatcher("/WEB-INF/admin/aIndex.jsp").forward(request,response);
                response.sendRedirect("adminIndexServlet");
            }else {
                //登录失败 提示信息
                request.setAttribute("login_msg", "用户名或密码错误！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
//doPost 方法：
//
//设置编码：确保正确解析请求中的中文参数。
//获取验证码和登录信息：从请求中获取验证码、用户名（id）、密码等信息。
//验证码校验：将从 session 中获取的验证码与用户输入的验证码进行比较，确保输入的验证码正确。
//封装对象：根据角色（roles）不同，封装相应的用户对象（User 或 Admin）。
//用户登录验证：
//如果角色是 "user"，则调用 UserService 的 findByUserName 方法查询用户，如果用户名和密码匹配，则设置用户角色为 "user"，保存用户信息到 session，并重定向到用户首页 (userIndexServlet)。
//如果角色是 "admin"，则调用 AdminService 的 login 方法验证管理员登录，如果验证成功，则设置管理员角色为 "admin"，保存管理员信息到 session，并重定向到管理员首页 (adminIndexServlet)。
//如果登录失败（用户名或密码错误），则设置错误提示信息，并转发回登录页面 (login.jsp)。
//doGet 方法：
//
//调用 doPost 方法，确保 GET 请求也能处理相同的逻辑。
