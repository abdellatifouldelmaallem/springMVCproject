package service;

import dao.IRole;
import entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
