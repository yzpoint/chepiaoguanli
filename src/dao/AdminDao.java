package dao;

import domain.Admin;

public interface AdminDao {
    Admin findAdminidAndPassword(String id, String password);

    void updatePassword(String adminid, String newpassword);

    Admin findAdminById(String a_id);
}
//这个接口定义了三个主要方法：
//findAdminidAndPassword：根据管理员ID和密码查找管理员。
//updatePassword：更新管理员密码。
//findAdminById：根据ID查找管理员。
//这些方法定义了与Admin实体相关的基本数据库操作。在AdminDaoImpl类中，这些方法被具体实现，用于实际的数据库查询和更新操作。接口的作用在于定义规范，而具体的实现则通过实现类（如AdminDaoImpl）来完成。





