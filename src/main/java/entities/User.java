package entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "recordType",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "userType")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="fullName", length=50, nullable=false, unique=false)
    private String fullName;
    @Column(name="email", length=40, nullable=false, unique=false)
    private String email;
    @Column(name="passWord", length=50, nullable=false, unique=false)
    private String passWord;
    @OneToOne
    private Role role;


    public User() {
    }

    public User(Long id, String fullName, String email, String passWord ,Role role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.passWord = passWord;
        this.role = role;
    }

    public User(String fullName, String email, String passWord,Role role) {
        this.fullName = fullName;
        this.email = email;
        this.passWord = passWord;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
}
