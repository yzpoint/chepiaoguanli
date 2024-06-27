package service;

import domain.PageBean;
import domain.Schedule;

import java.util.Map;

public interface ScheduleService {
    PageBean<Schedule> findByPage(String currentPage, String rows, Map<String, String[]> condition);

    void addSchedule(Schedule updateStudent);

    Integer findByScheduleCode(String scheduleCode);

    Schedule findById(String id);

    void updateInfo(Schedule updateStudent);

    void deleteServiceById(String id);
}
//findByPage(String currentPage, String rows, Map<String, String[]> condition):
//
//功能：分页查询时间表信息。
//参数：
//currentPage：当前页码。
//rows：每页显示的记录数。
//condition：查询条件。
//返回值：返回包含分页结果的 PageBean<Schedule> 对象。
//addSchedule(Schedule updateStudent):
//
//功能：添加新的时间表。
//参数：updateStudent，要添加的 Schedule 对象。
//findByScheduleCode(String scheduleCode):
//
//功能：根据车次号查找时间表。
//参数：scheduleCode，车次号。
//返回值：返回车次号对应的时间表ID。
//findById(String id):
//
//功能：根据ID查找时间表。
//参数：id，时间表ID。
//返回值：返回查找到的 Schedule 对象。
//updateInfo(Schedule updateStudent):
//
//功能：更新时间表信息。
//参数：updateStudent，要更新的 Schedule 对象。
//deleteServiceById(String id):
//
//功能：根据ID删除时间表。
//参数：id，时间表ID。