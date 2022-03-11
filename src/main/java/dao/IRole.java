package dao;

import entities.Role;
import entities.Trainer;

import java.util.List;

public interface IRole {
    void saveRole(Role role);
    void deleteRole(Long id);
    Role getRole(Long id);
    List <Role> getAllRole();
}
