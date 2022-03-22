package dao;

import entities.Admin;

public interface IAdmin {
   public void saveAdmin(Admin admin);
   public void deleteAdmin(Long id);
   public Boolean login(String email, String passWord);
   // create methode findByEmail
   public Admin findByEmail(String email);
}
