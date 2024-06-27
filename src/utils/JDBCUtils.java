package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid连接池工具类,将来dao层调用
 */
public class JDBCUtils {
    private static DataSource dataSource;   //定义成员变量DataSource
    static {
        try {
            //加载配置文件
            Properties properties = new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));

            //获取DataSource
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 释放资源
     */
    public static void close(Statement statement,Connection connection) {
        close(null,statement,connection);
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();//归还连接
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池方法
     */
    public static DataSource getDataSource() {
        return dataSource;
    }
}
//DruidDataSourceFactory 是阿里巴巴开源的连接池实现，用于创建和管理数据库连接池。
//javax.sql.DataSource 是Java中用于管理数据库连接的标准接口。
//java.sql.* 包含了Java JDBC API 的核心类和接口，用于执行SQL查询和管理数据库连接。
//JDBCUtils 类中声明了一个静态成员变量 dataSource，用于保存 Druid 数据源对象。
//static 代码块在类加载时执行，用于初始化 dataSource，从 druid.properties 配置文件中读取配置信息
// 并创建 Druid 数据源。
//getConnection 方法用于从连接池中获取一个数据库连接 (Connection) 对象。
// 抛出 SQLException 异常，如果连接获取失败。
//close 方法用于释放数据库资源，包括 ResultSet、Statement 和 Connection 对象。
//重载的 close 方法允许同时关闭 ResultSet、Statement 和 Connection 对象。
//getDataSource 方法返回 dataSource，允许其他类获取 Druid 连接池对象。