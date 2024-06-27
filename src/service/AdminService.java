package service;


import domain.Admin;

/**
 * 管理员的业务接口
 */
public interface AdminService {
    /**
     * 管理员登录
     */
    Admin login(Admin admin);

    void updatePassword(String adminid, String newpassword);

    Admin findAdminById(Admin admin);
}
//login(Admin admin):
//
//功能：用于管理员登录验证。
//参数：admin，一个封装了管理员ID和密码的 Admin 对象。
//返回值：返回查找到的 Admin 对象，如果登录失败则返回 null。
//updatePassword(String adminid, String newpassword):
//
//功能：用于更新管理员的密码。
//参数：
//adminid：管理员的ID。
//newpassword：管理员的新密码。
//findAdminById(Admin admin):
//
//功能：根据管理员ID查找管理员信息。
//参数：admin，一个封装了管理员ID的 Admin 对象。
//返回值：返回查找到的 Admin 对象，如果没有找到则返回 null。