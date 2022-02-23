package dao;

import entities.Admin;
import entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

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
}
