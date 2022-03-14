package dao;

import entities.Admin;
import entities.Role;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminImpl implements IAdmin{

    @Autowired
    @Qualifier("transactionManager")
    private HibernateTransactionManager transactionManager;
    private Admin admin;

    @Override
    public void saveAdmin(Admin admin) {
        transactionManager.getSessionFactory().getCurrentSession().save(admin);
    }

    @Override
    public void deleteAdmin(Long id) {
        admin = transactionManager.getSessionFactory().getCurrentSession().load(Admin.class,id);
        if (admin!=null){
            transactionManager.getSessionFactory().getCurrentSession().delete(admin);
        }
    }

    @Override
    public Boolean login(String email, String passWord) {
        Boolean AdminStatus = false;

        String allAdmins = "FROM User as U WHERE  U.email = :email AND U.passWord = :passWord ";
        Query query = transactionManager.getSessionFactory().getCurrentSession().createQuery(allAdmins);
        query.setParameter(":email",email);
        List<Admin> adminList = query.list();
        if (adminList!=null && admin.getPassWord().equals(passWord)){
            return AdminStatus = true;
        }

        return AdminStatus;
    }
}
