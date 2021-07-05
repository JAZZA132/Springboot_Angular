package backend.bean;

import java.io.Serializable;

//@Entity
public class Member implements Serializable {

    private String id ;
    private String name;
    private String account;
    private String password;

    public Member() {
    }

    public Member(String id, String name, String account, String password) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
