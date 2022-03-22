package entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "recordType",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "userType")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Size(min=5, max=40)
    @Column(name="fullName", length=50, nullable=false, unique=false)
    private String fullName;


    @Size(min=11, max=40)
    @Column(name="email", length=40, nullable=false, unique=false)
    private String email;


    @Size(min=2, max=50)
    @Column(name="passWord", length=50, nullable=false, unique=false)
    private String passWord;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id", nullable=false)
    private Role rol;


    public User() {
    }

    public User(Long id, String fullName, String email, String passWord ,Role role) {
        this.idUser = id;
        this.fullName = fullName;
        this.email = email;
        this.passWord = passWord;
        this.rol = role;
    }

    public User(String fullName, String email, String passWord,Role role) {
        this.fullName = fullName;
        this.email = email;
        this.passWord = passWord;
        this.rol = role;
    }

    public Long getId() {
        return idUser;
    }

    public void setId(Long id) {
        this.idUser = id;
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
        this.rol = role;
    }

        public Role getRole() {
        return rol;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", passWord='" + passWord + '\'' +
                ", role=" + rol +
                '}';
    }
}
