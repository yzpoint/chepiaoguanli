package dao.impl;

import dao.TicketDao;

import domain.Ticket;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import utils.JDBCUtils;

import java.util.*;

public class TicketDaoImpl implements TicketDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //package dao.impl;：定义该类属于dao.impl包。
//            import ...：导入所需的类和接口。
//    public class TicketDaoImpl implements TicketDao：类定义，TicketDaoImpl实现了TicketDao接口。
//    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());：通过JDBCUtils获取数据源并初始化JdbcTemplate对象。
    @Override
    public void addTicket(Ticket ticket) {
        try {
            String sql = "INSERT INTO ticket (scheduleId, userName, name, route, scheduleCode, departureTime, " +
                    "arrivalTime, ticketPrice, ticketDate) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            template.update(sql,
                    ticket.getScheduleId(),
                    ticket.getUserName(),
                    ticket.getName(),
                    ticket.getRoute(),
                    ticket.getScheduleCode(),
                    ticket.getDepartureTime(),
                    ticket.getArrivalTime(),
                    ticket.getTicketPrice(),
                    ticket.getTicketDate());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
    //    public void addTicket(Ticket ticket);：方法签名，接受一个Ticket对象作为参数，用于添加新的票务记录。
//    通过template.update方法执行插入操作。
    @Override
    public Ticket findTicketById(int id) {
        try {
            String sql = "SELECT * FROM Ticket WHERE id = ?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(Ticket.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    //    public Ticket findTicketById(int id);：方法签名，接受一个票务ID作为参数，用于查找对应的票务记录。
//    通过template.queryForObject方法执行查询操作。
    @Override
    public List<Ticket> findAllTickets() {
        try {
            String sql = "SELECT * FROM Ticket";
            return template.query(sql, new BeanPropertyRowMapper<>(Ticket.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    //    public List<Ticket> findAllTickets();：方法签名，没有参数，用于查找所有票务记录。
//    通过template.query方法执行查询操作。
    @Override
    public void updateTicket(Ticket ticket) {
//        try {
//            String sql = "UPDATE Ticket SET schedule_id = ?, passenger_name = ?, purchase_time = ?, status = ? WHERE id = ?";
//            template.update(sql,
//                    ticket.getScheduleId(),
//                    ticket.getPassengerName(),
//                    Timestamp.valueOf(ticket.getPurchaseTime()),
//                    ticket.getStatus(),
//                    ticket.getId()
//            );
//        } catch (DataAccessException e) {
//            e.printStackTrace();
//        }
//        public void updateTicket(Ticket ticket);：方法签名，接受一个Ticket对象作为参数，用于更新票务记录。
//        此方法体被注释掉了，未实现。
    }

    @Override
    public void deleteTicketById(int id) {
        try {
            String sql = "DELETE FROM Ticket WHERE id = ?";
            template.update(sql, id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
//    public void deleteTicketById(int id);：方法签名，接受一个票务ID作为参数，用于删除对应的票务记录。
//    通过template.update方法执行删除操作。

    @Override
    public int findTotalCount(Map<String, String[]> condition, Ticket params2) {
        //定义模板初始化sql
        String sql = "select count(*) from ticket where 1=1";
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
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//?条件的值
            }
        }
        if(!StringUtils.isEmpty(params2.getUserName())){
            sb.append(" and "+"userName"+" like ? ");
            params.add("%"+params2.getUserName()+"%");//?条件的值
        }
        System.out.println(sb.toString());
        System.out.println(params);
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }
    //    public int findTotalCount(Map<String, String[]> condition, Ticket params2);：方法签名，接受条件映射和额外参数，用于查找符合条件的记录总数。
//    通过StringBuilder构建动态SQL查询语句，并通过template.queryForObject方法执行查询操作。
    @Override
    public List<Ticket> findByPage(int start, int rows, Map<String, String[]> condition, Ticket params2) {
        try {
            String sql = "select * from ticket where 1=1";
            StringBuilder sb = new StringBuilder(sql);
            //遍历map
            Set<String> keySet = condition.keySet();
            //定义参数集合
            List<Object> params = new ArrayList<Object>();
            for (String key : keySet) {
                //排除分页条件参数
                if ("currentPage".equals(key) || "rows".equals(key)) {
                    continue;
                }

                //获取value
                String value = condition.get(key)[0];
                //判断value是否有值
                if (value != null && !"".equals(value)) {
                    //有值
                    sb.append(" and "+key+" like ? ");
                    params.add("%"+value+"%");//?条件的值
                }
            }

            if(!StringUtils.isEmpty(params2.getUserName())){
                sb.append(" and "+"userName"+" like ? ");
                params.add("%"+params2.getUserName()+"%");//?条件的值
            }
            //添加分页查询
            sb.append(" limit ? , ?");
            //添加分页查询参数值
            params.add(start);
            params.add(rows);
            System.out.println(sb.toString());
            System.out.println(params);
            return template.query(sb.toString(),new BeanPropertyRowMapper<Ticket>(Ticket.class),params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    //    public List<Ticket> findByPage(int start, int rows, Map<String, String[]> condition, Ticket params2);：方法签名，接受分页参数和条件映射，用于分页查询票务记录。
//    通过StringBuilder构建动态SQL查询语句，并通过template.query方法执行分页查询操作。
    @Override
    public void updateTicketById(String id) {
        try {
            String sql = "UPDATE Ticket SET status = '已退票' WHERE id = ?";
            template.update(sql,
                    id
            );
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
//    public void updateTicketById(String id);：方法签名，接受一个票务ID作为参数，用于更新票务状态为已退票。
//    通过template.update方法执行更新操作。
}
