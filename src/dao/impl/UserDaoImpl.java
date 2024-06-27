package dao.impl;

import dao.UserDao;
import domain.Admin;
import domain.Ticket;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.*;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //    public class UserDaoImpl implements UserDao：定义实现了UserDao接口的UserDaoImpl类。
//    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());：创建一个JdbcTemplate对象，用于执行SQL语句。JDBCUtils.getDataSource()方法获取数据源。
    @Override
    public void addUser(User user) {
        try {
            String sql = "INSERT INTO `User` (user_name,password, name, email) VALUES (?, ?, ?,?)";
            template.update(sql,
                    user.getUserName(),
                    user.getPassword(),
                    user.getName(),
                    user.getEmail()
            );
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
    //    void addUser(User user);：方法签名，接受一个User对象作为参数，用于添加新的用户记录。
//    使用JdbcTemplate的update方法执行插入操作。
    @Override
    public User findUserById(int id) {
        try {
            String sql = "SELECT * FROM User WHERE id = ?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    //    User findUserById(int id);：方法签名，接受一个用户ID作为参数，返回对应的User对象，用于查找用户记录。
//    使用JdbcTemplate的queryForObject方法执行查询操作。
    @Override
    public List<User> findAllUsers() {
        try {
            String sql = "SELECT * FROM User";
            return template.query(sql, new BeanPropertyRowMapper<>(User.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    //    List<User> findAllUsers();：方法签名，没有参数，返回所有用户记录的列表。
//    使用JdbcTemplate的query方法执行查询操作。
    @Override
    public void updateUser(User user) {
        try {
            String sql = "UPDATE User SET name = ?, email = ? WHERE id = ?";
            template.update(sql,
                    user.getName(),
                    user.getEmail(),
                    user.getId()
            );
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
    //    void updateUser(User user);：方法签名，接受一个User对象作为参数，用于更新用户记录。
//    使用JdbcTemplate的update方法执行更新操作。
    @Override
    public void deleteUserById(int id) {
        try {
            String sql = "DELETE FROM User WHERE id = ?";
            template.update(sql, id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
    //    void deleteUserById(int id);：方法签名，接受一个用户ID作为参数，用于删除对应的用户记录。
//    使用JdbcTemplate的update方法执行删除操作。
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义模板初始化sql
        String sql = "select count(*) from user where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> params = new ArrayList<Object>();

        System.out.println(sb.toString());
        System.out.println(params);
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }
    //    int findTotalCount(Map<String, String[]> condition);：方法签名，接受条件映射，返回符合条件的记录总数。
//    使用JdbcTemplate的queryForObject方法执行查询操作。
    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        try {
            String sql = "select * from user where 1=1";
            StringBuilder sb = new StringBuilder(sql);
            //遍历map
            Set<String> keySet = condition.keySet();
            //定义参数集合
            List<Object> params = new ArrayList<Object>();

            //添加分页查询
            sb.append(" limit ? , ?");
            //添加分页查询参数值
            params.add(start);
            params.add(rows);
            System.out.println(sb.toString());
            System.out.println(params);
            return template.query(sb.toString(),new BeanPropertyRowMapper<User>(User.class),params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    //    List<User> findByPage(int start, int rows, Map<String, String[]> condition);：方法签名，接受分页参数和条件映射，返回分页后的用户记录列表。
//    使用JdbcTemplate的query方法执行查询操作。
    @Override
    public User findByUserName(String userName) {
        try {
            String sql = "select * from user where user_name = ?";
            User admin = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),userName);
            return admin;
//            String sql = "SELECT * FROM user WHERE user_name = ?";
//            return template.queryForObject(sql, User.class, userName);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
//    User findByUserName(String userName);：方法签名，接受一个用户名作为参数，返回对应的User对象，用于查找用户记录。
//    使用JdbcTemplate的queryForObject方法执行查询操作。
}
