package dao;

import entities.Admin;

public interface IAdmin {
   public void saveAdmin(Admin admin);
   public void deleteAdmin(Long id);
}
