package entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    @Column(name="typeOfUser", length=20, nullable=false, unique=false)
    private String typeOfUser;


    public Role() {
    }

    public Role(String user) {
        this.typeOfUser = user;
    }

    public Role(Long id, String user) {
        this.idRole = id;
        this.typeOfUser = user;
    }

    public Long getId() {
        return idRole;
    }

    public void setId(Long id) {
        this.idRole = id;
    }

    public String getUser() {
        return typeOfUser;
    }

    public void setUser(String user) {
        this.typeOfUser = user;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + idRole +
                ", typeofuser='" + typeOfUser + '\'' +
                '}';
    }
}
