package domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Schedule {
    private int id;

    //车次号
    private String scheduleCode;
    //发车时间
    private String departureTime;
    //路线
    private String route;

    //到达时间
    private String arrivalTime;

    //容量
    private int capacity;

    private BigDecimal ticketPrice;

    private String status;

    private String ticketDate;

    public Schedule() {}

    public String getScheduleCode() {
        return scheduleCode;
    }

    public void setScheduleCode(String scheduleCode) {
        this.scheduleCode = scheduleCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }



    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }
}
//Schedule类：
//属性：
//
//id：班次的唯一标识。
//scheduleCode：车次号，例如火车编号。
//departureTime：发车时间，以字符串形式表示。
//route：路线描述。
//arrivalTime：预计到达时间，以字符串形式表示。
//capacity：容量，表示可容纳的乘客数量。
//ticketPrice：票价，使用BigDecimal类型表示。
//status：班次状态，例如运行中、已取消等。
//ticketDate：票务日期，可能指定具体的日期。
//方法：
//
//getters和setters：用于获取和设置属性值。
//toString()：打印对象的字符串表示，方便调试和输出。

