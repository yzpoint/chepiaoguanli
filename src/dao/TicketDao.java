package dao;

import domain.Ticket;
import java.util.List;
import java.util.Map;

public interface TicketDao {
    void addTicket(Ticket ticket);
    Ticket findTicketById(int id);
    List<Ticket> findAllTickets();
    void updateTicket(Ticket ticket);
    void deleteTicketById(int id);

    int findTotalCount(Map<String, String[]> condition, Ticket params);

    List<Ticket> findByPage(int start, int rows, Map<String, String[]> condition, Ticket params);

    void updateTicketById(String id);
}
//这个接口定义了以下方法，用于对Ticket表进行各种操作：
//
//addTicket：添加新的票务记录。
//findTicketById：根据ID查找票务记录。
//findAllTickets：查找所有票务记录。
//updateTicket：更新票务记录。
//deleteTicketById：根据ID删除票务记录。
//findTotalCount：根据条件查找记录总数。
//findByPage：分页查找票务记录。
//updateTicketById：根据ID更新票务状态。
//这些方法为实现类提供了标准的操作接口，确保了对Ticket表进行一致的操作。
