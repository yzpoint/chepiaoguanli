package dao.impl;

import dao.AdminDao;
import domain.Admin;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;
//package dao.impl;：定义这个类属于dao.impl包。
//import dao.AdminDao;：导入AdminDao接口。
//import domain.Admin;：导入Admin实体类。
//import org.springframework.dao.DataAccessException;：导入Spring的DataAccessException类，用于捕获数据库访问异常。
//import org.springframework.jdbc.core.BeanPropertyRowMapper;：导入Spring的BeanPropertyRowMapper类，用于将结果集映射为Java对象。
//import org.springframework.jdbc.core.JdbcTemplate;：导入Spring的JdbcTemplate类，用于简化JDBC操作。
//import utils.JDBCUtils;：导入JDBCUtils工具类，用于获取数据源。
public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //    public class AdminDaoImpl implements AdminDao：定义AdminDaoImpl类，并声明实现AdminDao接口。
//    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());：创建一个JdbcTemplate实例，并通过JDBCUtils.getDataSource()获取数据源。
    @Override
    public Admin findAdminidAndPassword(String id, String password) {
        try {
            String sql = "select * from admin where a_id = ? and a_password = ?";
            Admin admin = template.queryForObject(sql,new BeanPropertyRowMapper<Admin>(Admin.class),id,password);
            return admin;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    //    @Override：注解表明这是实现AdminDao接口中的方法。
//    public Admin findAdminidAndPassword(String id, String password)：方法签名，接受管理员ID和密码作为参数。
//    try块：尝试执行SQL查询。
//    String sql = "select * from admin where a_id = ? and a_password = ?";：定义SQL查询语句。
//    Admin admin = template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), id, password);：执行查询，并将结果映射为Admin对象。
//            return admin;：返回查询到的管理员对象。
//            catch (DataAccessException e)：捕获数据库访问异常。
//            e.printStackTrace();：打印异常堆栈跟踪。
//            return null;：返回null表示没有找到对应的管理员。
    @Override
    public void updatePassword(String adminid, String newpassword) {
        try {
            String sql = "update admin set a_password=? where a_id=?";
            template.update(sql,newpassword,adminid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //    public void updatePassword(String adminid, String newpassword)：方法签名，接受管理员ID和新密码作为参数。
//    try块：尝试执行SQL更新。
//    String sql = "update admin set a_password=? where a_id=?";：定义SQL更新语句。
//            template.update(sql, newpassword, adminid);：执行更新操作。
//            catch (Exception e)：捕获所有异常。
//            e.printStackTrace();：打印异常堆栈跟踪。
    @Override
    public Admin findAdminById(String id) {
        try {
            String sql = "select * from admin where a_id = ?";
            Admin admin = template.queryForObject(sql,new BeanPropertyRowMapper<Admin>(Admin.class),id);
            return admin;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
//    public Admin findAdminById(String id)：方法签名，接受管理员ID作为参数。
//    try块：尝试执行SQL查询。
//    String sql = "select * from admin where a_id = ?";：定义SQL查询语句。
//    Admin admin = template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), id);：执行查询，并将结果映射为Admin对象。
//            return admin;：返回查询到的管理员对象。
//            catch (DataAccessException e)：捕获数据库访问异常。
//            e.printStackTrace();：打印异常堆栈跟踪。
//            return null;：返回null表示没有找到对应的管理员。
}
