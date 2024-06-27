package service.impl;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import domain.Admin;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
    private AdminDao dao = new AdminDaoImpl();

    @Override
    public Admin login(Admin admin) {
        return dao.findAdminidAndPassword(admin.getA_id(),admin.getA_password());
    }

    @Override
    public void updatePassword(String adminid, String newpassword) {
        dao.updatePassword(adminid,newpassword);
    }

    @Override
    public Admin findAdminById(Admin admin) {
        return dao.findAdminById(admin.getA_id());
    }
}
//AdminServiceImpl 类：
//属性：
//
//dao：私有属性，类型为 AdminDao 接口的实例。在构造方法中初始化为 AdminDaoImpl 的实例，这是 AdminDao 的具体实现类。
//方法：
//
//login(Admin admin) 方法：实现了 AdminService 接口的方法。该方法通过调用 AdminDao 的 findAdminidAndPassword 方法来验证管理员登录。它接收一个 Admin 对象作为参数，从中获取管理员的 a_id 和 a_password。
//
//updatePassword(String adminid, String newpassword) 方法：实现了 AdminService 接口的方法。该方法通过调用 AdminDao 的 updatePassword 方法来更新管理员的密码。它接收管理员的 adminid 和新密码 newpassword 作为参数。
//
//findAdminById(Admin admin) 方法：实现了 AdminService 接口的方法。该方法通过调用 AdminDao 的 findAdminById 方法来查找指定 a_id 的管理员信息。它接收一个 Admin 对象作为参数，从中获取管理员的 a_id。