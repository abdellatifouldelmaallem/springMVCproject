package entities;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue(value = "trainerType")
public class Trainer extends User {

    @Column(name="speciality", length=40, nullable=true, unique=false)
    private String speciality;
    @Column(name="phoneNamber", length=40, nullable=true, unique=false)
    private Long phoneNamber;


  public Trainer() {
  }

  public Trainer(Long id, String fullName, String email, String passWord, Role role, String speciality, Long phoneNamber) {
    super(id, fullName, email, passWord, role);
    this.speciality = speciality;
    this.phoneNamber = phoneNamber;
  }

  public Trainer(String fullName, String email, String passWord, Role role, String speciality, Long phoneNamber) {
    super(fullName, email, passWord, role);
    this.speciality = speciality;
    this.phoneNamber = phoneNamber;
  }

  public String getSpeciality() {
    return speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

  public Long getPhoneNamber() {
    return phoneNamber;
  }

  public void setPhoneNamber(Long phoneNamber) {
    this.phoneNamber = phoneNamber;
  }

  @Override
  public String toString() {
    return "Trainer{" +
            "speciality='" + speciality + '\'' +
            ", phoneNamber=" + phoneNamber +
            "} " + super.toString();
  }
}
