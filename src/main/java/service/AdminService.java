package service;

import dao.IAdmin;
import entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
    @Autowired
    private IAdmin adminDAO;

    public void save(Admin admin){
        adminDAO.saveAdmin(admin);
    }

    public void delete(Long id){
        adminDAO.deleteAdmin(id);
    }
}
