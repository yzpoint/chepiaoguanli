package domain;

import java.math.BigDecimal;

public class Ticket {
    private int id;
    private int scheduleId;
    private String userName;

    private String name;
    private String route;
    private String scheduleCode;
    //发车时间
    private String departureTime;

    //到达时间
    private String arrivalTime;

    private BigDecimal ticketPrice;

    private String ticketDate;

    private String status;

    private Integer status2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getScheduleCode() {
        return scheduleCode;
    }

    public void setScheduleCode(String scheduleCode) {
        this.scheduleCode = scheduleCode;
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

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStatus2() {
        return status2;
    }

    public void setStatus2(Integer status2) {
        this.status2 = status2;
    }
}
//Ticket类：
//属性：
//
//id：车票的唯一标识。
//scheduleId：关联的班次ID，指示此车票属于哪个班次。
//userName：购票用户的用户名。
//name：购票人的姓名。
//route：行程路线描述。
//scheduleCode：车次号，例如火车编号。
//departureTime：发车时间，以字符串形式表示。
//arrivalTime：预计到达时间，以字符串形式表示。
//ticketPrice：票价，使用BigDecimal类型表示。
//ticketDate：票务日期，可能指定具体的日期。
//status：车票状态，例如已购买、已使用、已退票等。
//status2：第二状态，可以用于进一步描述车票的状态信息。
//方法：
//
//getters和setters：用于获取和设置属性值。