package dao;

import domain.Schedule;
import java.util.List;
import java.util.Map;

public interface ScheduleDao {
    void addSchedule(Schedule schedule);
    Schedule findScheduleById(int id);
    List<Schedule> findAllSchedules();
    void updateSchedule(Schedule schedule);
    void deleteScheduleById(int id);

    int findTotalCount(Map<String, String[]> condition);

    List<Schedule> findByPage(int start, int rows, Map<String, String[]> condition);

    Integer findByScheduleCode(String scheduleCode);
}
//这个接口定义了操作Schedule表的基本方法：
//
//addSchedule：添加新的时间表记录。
//findScheduleById：根据ID查找时间表记录。
//findAllSchedules：查找所有时间表记录。
//updateSchedule：更新时间表记录。
//deleteScheduleById：根据ID删除时间表记录。
//findTotalCount：根据条件查找记录总数。
//findByPage：分页查询时间表记录。
//findByScheduleCode：根据时间表代码查找记录数。
//这些方法定义了与Schedule实体相关的基本数据库操作。在ScheduleDaoImpl类中，这些方法被具体实现，用于实际的数据库查询和更新操作。接口的作用在于定义规范，而具体的实现则通过实现类（如ScheduleDaoImpl）来完成。