package service;

import dao.IRole;
import entities.Role;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {

    @Autowired
    private IRole roleDao;

    public void save(Role role) {
        roleDao.saveRole(role);
    }

    public  void delete(Long id){
        roleDao.deleteRole(id);
    }

    public List<Role> getAllRole(){
        List<Role> roleList = roleDao.getAllRole();
        return roleList;
}
}
