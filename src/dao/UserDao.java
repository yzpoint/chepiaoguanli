package dao;

import domain.User;
import java.util.List;
import java.util.Map;

public interface UserDao {
    void addUser(User user);
    User findUserById(int id);
    List<User> findAllUsers();
    void updateUser(User user);
    void deleteUserById(int id);

    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);

    User findByUserName(String userName);
}
//addUser(User user)
//
//添加一个用户到数据库。
//参数：User user - 要添加的用户对象。
//findUserById(int id)
//
//根据用户ID查找用户。
//参数：int id - 用户ID。
//返回：找到的User对象。
//findAllUsers()
//
//查找所有用户。
//返回：所有用户的List。
//updateUser(User user)
//
//更新用户信息。
//参数：User user - 要更新的用户对象。
//deleteUserById(int id)
//
//根据用户ID删除用户。
//参数：int id - 用户ID。
//findTotalCount(Map<String, String[]> condition)
//
//根据条件查找符合条件的记录总数。
//参数：Map<String, String[]> condition - 查询条件的Map。
//返回：符合条件的记录总数。
//findByPage(int start, int rows, Map<String, String[]> condition)
//
//分页查询用户。
//参数：
//int start - 查询的起始位置。
//int rows - 每页的记录数。
//Map<String, String[]> condition - 查询条件的Map。
//返回：符合条件的用户列表。
//findByUserName(String userName)
//
//根据用户名查找用户。
//参数：String userName - 用户名。
//返回：找到的User对象。