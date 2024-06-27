package domain;

public class User {
    private Long id;

    private String userName;

    private String password;

    private String name;
    private String email;

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
//User 类：
//属性：
//
//id：用户的唯一标识符。
//userName：用于登录和识别的用户名。
//password：与用户账户关联的密码。
//name：用户的全名。
//email：与用户账户关联的电子邮件地址。
//构造方法：
//
//类中包含一个默认构造方法 (User())，可以用来实例化对象而不需要参数。
//Getter 和 Setter 方法：
//
//提供了每个属性的 Getter 方法 (getId(), getUserName(), getPassword(), getName(), getEmail()) 和 Setter 方法 (setId(Long id),
// setUserName(String userName), setPassword(String password), setName(String name), setEmail(String email))，用于访问和修改它们的值。