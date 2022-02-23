package entities;

import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue(value = "adminType")
public class Admin extends User {

    public Admin() {
    }

    public Admin(Long id, String fullName, String email, String passWord, Role role) {
        super(id, fullName, email, passWord, role);
    }

    public Admin(String fullName, String email, String passWord, Role role) {
        super(fullName, email, passWord, role);
    }
}
