package backend.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "member")
@Component
@IdClass(Member.class)
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private int id ;
    private String name;
    private String account;

    private String password;


    private String membercode;

    public Member() {
    }

    public Member(int id, String name, String account, String password, String memberCode) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.membercode = memberCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMemberCode() {
        return membercode;
    }

    public void setMemberCode(String memberCode) {
        this.membercode = memberCode;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", memberCode='" + membercode + '\'' +
                '}';
    }
}
