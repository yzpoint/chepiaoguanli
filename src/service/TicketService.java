package service;

import domain.PageBean;
import domain.Ticket;

import java.util.List;
import java.util.Map;

public interface TicketService {
    PageBean<Ticket> findByPage(String currentPage, String rows, Map<String, String[]> condition, Ticket params);

    void addTicket(Ticket ticket);

    void updateStatus(String id);

    List<Ticket> findAll();
}
//findByPage(String currentPage, String rows, Map<String, String[]> condition, Ticket params):
//
//功能：分页查询车票信息。
//参数：
//currentPage：当前页码。
//rows：每页显示的记录数。
//condition：查询条件。
//params：查询参数。
//返回值：返回包含分页结果的 PageBean<Ticket> 对象。
//addTicket(Ticket ticket):
//
//功能：添加新的车票。
//参数：ticket，要添加的 Ticket 对象。
//updateStatus(String id):
//
//功能：更新车票状态。
//参数：id，车票ID。
//findAll():
//
//功能：查询所有车票。
//返回值：返回所有车票的列表。