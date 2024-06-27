package service.impl;


import dao.TicketDao;

import dao.impl.TicketDaoImpl;
import domain.PageBean;

import domain.Ticket;
import service.TicketService;

import java.util.List;
import java.util.Map;

public class TicketServiceImpl implements TicketService {
    private TicketDao dao = new TicketDaoImpl();
    @Override
    public PageBean<Ticket> findByPage(String _currentPage, String _rows, Map<String, String[]> condition, Ticket params) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //创建新的PageBean对象
        PageBean<Ticket> pb = new PageBean<Ticket>();

        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition,params);
        pb.setTotalCount(totalCount);

        //调用dao查询List集合
        //计算开始记录的索引
        int start = (currentPage - 1) * rows;
        List<Ticket> list = dao.findByPage(start,rows,condition,params);
        pb.setList(list);

        //计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public void addTicket(Ticket ticket) {
        dao.addTicket(ticket);
    }

    @Override
    public void updateStatus(String id) {
        dao.updateTicketById(id);
    }

    @Override
    public List<Ticket> findAll() {
        return dao.findAllTickets();
    }
}
//属性：
//
//dao：私有属性，类型为 TicketDao 接口的实例。在构造方法中初始化为 TicketDaoImpl 的实例，这是 TicketDao 的具体实现类。
//方法：
//
//findByPage(String _currentPage, String _rows, Map<String, String[]> condition, Ticket params) 方法：
//
//将传入的当前页码 _currentPage 和每页显示的记录数 _rows 转换为整数。
//创建一个新的 PageBean<Ticket> 对象。
//设置当前页码和每页记录数。
//调用 dao.findTotalCount(condition, params) 查询总记录数，并设置到 PageBean 对象中。
//计算开始记录的索引，并调用 dao.findByPage(start, rows, condition, params) 查询当前页的数据列表。
//计算总页码，并设置到 PageBean 对象中。
//返回 PageBean 对象。
//addTicket(Ticket ticket) 方法：
//
//调用 dao.addTicket(ticket) 添加新的票务信息。
//updateStatus(String id) 方法：
//
//调用 dao.updateTicketById(id) 更新票务状态。
//findAll() 方法：
//
//调用 dao.findAllTickets() 查找所有票务信息，并返回票务列表。