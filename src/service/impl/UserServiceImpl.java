package service.impl;

import dao.ScheduleDao;
import dao.UserDao;
import dao.impl.ScheduleDaoImpl;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.Schedule;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public PageBean<User> findByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //创建新的PageBean对象
        PageBean<User> pb = new PageBean<>();

        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        //调用dao查询List集合
        //计算开始记录的索引
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start,rows,condition);
        pb.setList(list);

        //计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public void addUser(User updateStudent) {
        dao.addUser(updateStudent);
    }

    @Override
    public User findByUserName(String userName) {
        return dao.findByUserName(userName);
    }
}
//属性：
//
//dao：私有属性，类型为 UserDao 接口的实例。在构造方法中初始化为 UserDaoImpl 的实例，这是 UserDao 的具体实现类。
//方法：
//
//findByPage(String _currentPage, String _rows, Map<String, String[]> condition) 方法：
//
//将传入的当前页码 _currentPage 和每页显示的记录数 _rows 转换为整数。
//创建一个新的 PageBean<User> 对象。
//设置当前页码和每页记录数。
//调用 dao.findTotalCount(condition) 查询总记录数，并设置到 PageBean 对象中。
//计算开始记录的索引，并调用 dao.findByPage(start, rows, condition) 查询当前页的数据列表。
//计算总页码，并设置到 PageBean 对象中。
//返回 PageBean 对象。
//addUser(User updateStudent) 方法：
//
//调用 dao.addUser(updateStudent) 添加新的用户信息。
//findByUserName(String userName) 方法：
//
//调用 dao.findByUserName(userName) 根据用户名查找用户信息，并返回用户对象。
