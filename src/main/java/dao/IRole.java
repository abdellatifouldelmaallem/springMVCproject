package dao;

import entities.Role;

public interface IRole {
    void saveRole(Role role);
    void deleteRole(Long id);
}
