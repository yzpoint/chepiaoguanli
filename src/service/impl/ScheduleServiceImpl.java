package service.impl;

import dao.ScheduleDao;
import dao.TicketDao;
import dao.impl.ScheduleDaoImpl;
import dao.impl.TicketDaoImpl;
import domain.PageBean;
import domain.Schedule;
import domain.Ticket;
import service.ScheduleService;

import java.util.List;
import java.util.Map;

public class ScheduleServiceImpl implements ScheduleService {
    private ScheduleDao dao = new ScheduleDaoImpl();
    @Override
    public PageBean<Schedule> findByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //创建新的PageBean对象
        PageBean<Schedule> pb = new PageBean<>();

        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        //调用dao查询List集合
        //计算开始记录的索引
        int start = (currentPage - 1) * rows;
        List<Schedule> list = dao.findByPage(start,rows,condition);
        pb.setList(list);

        //计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public void addSchedule(Schedule updateStudent) {
        dao.addSchedule(updateStudent);
    }

    @Override
    public Integer findByScheduleCode(String scheduleCode) {
        return dao.findByScheduleCode(scheduleCode);
    }

    @Override
    public Schedule findById(String id) {
        return dao.findScheduleById(Integer.parseInt(id));
    }

    @Override
    public void updateInfo(Schedule updateStudent) {
        dao.updateSchedule(updateStudent);
    }

    @Override
    public void deleteServiceById(String id) {
        dao.deleteScheduleById(Integer.parseInt(id));
    }
}

//属性：
//
//dao：私有属性，类型为 ScheduleDao 接口的实例。在构造方法中初始化为 ScheduleDaoImpl 的实例，这是 ScheduleDao 的具体实现类。
//方法：
//
//findByPage(String _currentPage, String _rows, Map<String, String[]> condition) 方法：
//
//将传入的当前页码 _currentPage 和每页显示的记录数 _rows 转换为整数。
//创建一个新的 PageBean<Schedule> 对象。
//设置当前页码和每页记录数。
//调用 dao.findTotalCount(condition) 查询总记录数，并设置到 PageBean 对象中。
//计算开始记录的索引，并调用 dao.findByPage(start, rows, condition) 查询当前页的数据列表。
//计算总页码，并设置到 PageBean 对象中。
//返回 PageBean 对象。
//addSchedule(Schedule updateStudent) 方法：
//
//调用 dao.addSchedule(updateStudent) 添加新的车次信息。
//findByScheduleCode(String scheduleCode) 方法：
//
//调用 dao.findByScheduleCode(scheduleCode) 根据车次号查找车次。
//findById(String id) 方法：
//
//将传入的车次ID转换为整数，并调用 dao.findScheduleById(Integer.parseInt(id)) 查找车次。
//updateInfo(Schedule updateStudent) 方法：
//
//调用 dao.updateSchedule(updateStudent) 更新车次信息。
//deleteServiceById(String id) 方法：
//
//将传入的车次ID转换为整数，并调用 dao.deleteScheduleById(Integer.parseInt(id)) 删除车次。