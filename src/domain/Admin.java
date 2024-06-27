package domain;

public class Admin {
    private String a_id;
    private String a_password;

    public String getA_id() {
        return a_id;
    }

    public void setA_id(String a_id) {
        this.a_id = a_id;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "a_id='" + a_id + '\'' +
                ", a_password='" + a_password + '\'' +
                '}';
    }
}
//类说明
//Admin类：
//属性：
//a_id：管理员ID。
//a_password：管理员密码。
//方法：
//getters和setters：用于获取和设置属性值。
//toString()：打印对象的字符串表示，方便调试和输出。
