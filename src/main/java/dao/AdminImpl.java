package dao;

import entities.Admin;
import entities.Role;
import entities.User;
import org.hibernate.NonUniqueResultException;
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
        try {
            String allAdmins = "FROM User U WHERE U.email=:email";
            Query query = transactionManager.getSessionFactory().getCurrentSession().createQuery(allAdmins, User.class);
            query.setParameter("email",email);
            query.setMaxResults(1);
            Admin admin = (Admin) query.getSingleResult();
            return admin.getPassWord().equals(passWord);
        } catch (Exception e){
            return false;
        }

    }

    @Override
    public Admin findByEmail(String email) {
        Admin admin = transactionManager.getSessionFactory().getCurrentSession().get(Admin.class,email);
        return admin;
    }
}
