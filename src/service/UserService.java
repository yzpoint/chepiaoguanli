package service;

import domain.PageBean;
import domain.User;

import java.util.Map;

public interface UserService {
    PageBean<User> findByPage(String currentPage, String rows, Map<String, String[]> condition);

    void addUser(User updateStudent);

    User findByUserName(String userName);
}
//findByPage(String currentPage, String rows, Map<String, String[]> condition):
//
//功能：分页查询用户信息。
//参数：
//currentPage：当前页码。
//rows：每页显示的记录数。
//condition：查询条件。
//返回值：返回包含分页结果的 PageBean<User> 对象。
//addUser(User user):
//
//功能：添加新的用户。
//参数：user，要添加的 User 对象。
//findByUserName(String userName):
//
//功能：通过用户名查找用户。
//参数：userName，用户名。
//返回值：返回查找到的 User 对象。