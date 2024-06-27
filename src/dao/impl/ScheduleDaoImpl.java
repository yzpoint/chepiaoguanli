package dao.impl;

import dao.ScheduleDao;
import domain.Schedule;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.sql.Timestamp;
import java.util.*;
//package dao.impl;：定义该类属于dao.impl包。
//import dao.ScheduleDao;：导入ScheduleDao接口。
//import domain.Schedule;：导入Schedule实体类。
//import domain.User;：导入User实体类（虽然在这个类中未使用）。
//import org.springframework.dao.DataAccessException;：导入Spring的DataAccessException类，用于捕获数据库访问异常。
//import org.springframework.jdbc.core.BeanPropertyRowMapper;：导入Spring的BeanPropertyRowMapper类，用于将结果集映射为Java对象。
//import org.springframework.jdbc.core.JdbcTemplate;：导入Spring的JdbcTemplate类，用于简化JDBC操作。
//import utils.JDBCUtils;：导入JDBCUtils工具类，用于获取数据源。
//import java.sql.Timestamp;：导入Timestamp类。
//import java.util.*;：导入所有的java.util包内容。
public class ScheduleDaoImpl implements ScheduleDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //    public class ScheduleDaoImpl implements ScheduleDao：定义ScheduleDaoImpl类，并声明实现ScheduleDao接口。
//    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());：创建一个JdbcTemplate实例，并通过JDBCUtils.getDataSource()获取数据源。
    @Override
    public void addSchedule(Schedule schedule) {
        try {
            String sql = "INSERT INTO Schedule (schedule_code, departure_time, route, arrival_time, capacity,ticket_price) VALUES (?, ?, ?, ?, ?,?)";
            template.update(sql,
                    schedule.getScheduleCode(),
                    schedule.getDepartureTime(),
                    schedule.getRoute(),
                    schedule.getArrivalTime(),
                    schedule.getCapacity(),
                    schedule.getTicketPrice()
            );
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
//    public void addSchedule(Schedule schedule)：方法签名，接受一个Schedule对象作为参数。
//    try块：尝试执行SQL插入操作。
//    String sql = "INSERT INTO Schedule (schedule_code, departure_time, route, arrival_time, capacity, ticket_price) VALUES (?, ?, ?, ?, ?,?)";：定义SQL插入语句。
//            template.update(sql, ...)：执行插入操作，插入新时间表记录。

    @Override
    public Schedule findScheduleById(int id) {
        try {
            String sql = "SELECT * FROM Schedule WHERE id = ?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(Schedule.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
//    public Schedule findScheduleById(int id)：方法签名，接受一个时间表ID作为参数。
//    try块：尝试执行SQL查询操作。
//    String sql = "SELECT * FROM Schedule WHERE id = ?";：定义SQL查询语句。
//            return template.queryForObject(sql, new BeanPropertyRowMapper<>(Schedule.class), id);：执行查询，并将结果映射为Schedule对象。

    @Override
    public List<Schedule> findAllSchedules() {
        try {
            String sql = "SELECT * FROM Schedule";
            return template.query(sql, new BeanPropertyRowMapper<>(Schedule.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    //    public List<Schedule> findAllSchedules()：方法签名，没有参数，返回一个Schedule对象的列表。
//    try块：尝试执行SQL查询操作。
//    String sql = "SELECT * FROM Schedule";：定义SQL查询语句。
//            return template.query(sql, new BeanPropertyRowMapper<>(Schedule.class));：执行查询，并将结果映射为Schedule对象的列表。
    @Override
    public void updateSchedule(Schedule schedule) {
        try {
            String sql = "UPDATE Schedule SET schedule_code = ?,departure_time = ?, route = ?, " +
                    "arrival_time = ?, capacity = ?, ticket_price = ? WHERE id = ?";
            template.update(sql,
                    schedule.getScheduleCode(),
                    schedule.getDepartureTime(),
                    schedule.getRoute(),
                    schedule.getArrivalTime(),
                    schedule.getCapacity(),
                    schedule.getTicketPrice(),
                    schedule.getId()
            );
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
    //    public void updateSchedule(Schedule schedule)：方法签名，接受一个Schedule对象作为参数。
//    try块：尝试执行SQL更新操作。
//    String sql = "UPDATE Schedule SET schedule_code = ?, departure_time = ?, route = ?, arrival_time = ?, capacity = ?, ticket_price = ? WHERE id = ?";：定义SQL更新语句。
//            template.update(sql, ...)：执行更新操作，更新指定ID的时间表记录。
    @Override
    public void deleteScheduleById(int id) {
        try {
            String sql = "DELETE FROM Schedule WHERE id = ?";
            template.update(sql, id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
    //    public void deleteScheduleById(int id)：方法签名，接受一个时间表ID作为参数。
//    try块：尝试执行SQL删除操作。
//    String sql = "DELETE FROM Schedule WHERE id = ?";：定义SQL删除语句。
//            template.update(sql, id);：执行删除操作，删除指定ID的时间表记录。
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义模板初始化sql
        String sql = "select count(*) from Schedule where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            System.out.println(key);
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            if(key.equals("scheduleCode")){
                if (value != null && !"".equals(value)) {
                    //有值
                    sb.append(" and "+"schedule_code"+" like ? ");
                    params.add("%"+value+"%");//?条件的值
                }
            }
            if(key.equals("route")){
                if (value != null && !"".equals(value)) {
                    //有值
                    sb.append(" and "+"route"+" like ? ");
                    params.add("%"+value+"%");//?条件的值
                }
            }
            //判断value是否有值

        }
        System.out.println(sb.toString());
        System.out.println(params);
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }
//    public int findTotalCount(Map<String, String[]> condition)：方法签名，接受一个条件映射作为参数，返回记录总数。
//    String sql = "select count(*) from Schedule where 1=1";：定义基础SQL查询语句。
//    StringBuilder sb = new StringBuilder(sql);：使用StringBuilder拼接SQL查询语句。
//    遍历条件映射condition：
//    排除分页参数currentPage和rows。
//    根据scheduleCode和route条件拼接SQL查询语句，并添加参数值。
//            return template.queryForObject(sb.toString(), Integer.class, params.toArray());：执行查询，返回记录总数。

    @Override
    public List<Schedule> findByPage(int start, int rows, Map<String, String[]> condition) {
        try {
            String sql = "select * from schedule where 1=1";
            StringBuilder sb = new StringBuilder(sql);
            //遍历map
            Set<String> keySet = condition.keySet();
            //定义参数集合
            List<Object> params = new ArrayList<Object>();
            for (String key : keySet) {
                System.out.println(key);
                //排除分页条件参数
                if ("currentPage".equals(key) || "rows".equals(key)) {
                    continue;
                }

                //获取value
                String value = condition.get(key)[0];
                if(key.equals("scheduleCode")){
                    if (value != null && !"".equals(value)) {
                        //有值
                        sb.append(" and "+"schedule_code"+" like ? ");
                        params.add("%"+value+"%");//?条件的值
                    }
                }
                if(key.equals("route")){
                    if (value != null && !"".equals(value)) {
                        //有值
                        sb.append(" and "+"route"+" like ? ");
                        params.add("%"+value+"%");//?条件的值
                    }
                }
                //判断value是否有值

            }
            //添加分页查询
            sb.append(" limit ? , ?");
            //添加分页查询参数值
            params.add(start);
            params.add(rows);
            System.out.println(sb.toString());
            System.out.println(params);
            return template.query(sb.toString(),new BeanPropertyRowMapper<Schedule>(Schedule.class),params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    //    public List<Schedule> findByPage(int start, int rows, Map<String, String[]> condition)：方法签名，接受分页参数和条件映射，返回分页结果。
//    String sql = "select * from schedule where 1=1";：定义基础SQL查询语句。
//    StringBuilder sb = new StringBuilder(sql);：使用StringBuilder拼接SQL查询语句。
//    遍历条件映射condition：
//    排除分页参数currentPage和rows。
//    根据scheduleCode和route条件拼接SQL查询语句，并添加参数值。
//    添加分页查询参数值start和rows。
//            return template.query(sb.toString(), new BeanPropertyRowMapper<>(Schedule.class), params.toArray());：执行分页查询，返回结果列表。
    @Override
    public Integer findByScheduleCode(String scheduleCode) {
        try {
            String sql = "SELECT count(*) FROM Schedule WHERE schedule_code = ?";
            return template.queryForObject(sql, Integer.class, scheduleCode);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
//    public Integer findByScheduleCode(String scheduleCode)：方法签名，接受一个时间表代码作为参数，返回记录数。
//    try块：尝试执行SQL查询操作。
//    String sql = "SELECT count(*) FROM Schedule WHERE schedule_code = ?";：定义SQL查询语句。
//            return template.queryForObject(sql, Integer.class, scheduleCode);：执行查询，返回记录数。
}
