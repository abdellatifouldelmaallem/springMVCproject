package dao;

import entities.Trainer;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserImpl implements IUser{

    @Autowired
    @Qualifier("transactionManager")
    private HibernateTransactionManager transactionManager;
    private User user;
    @Override
    public void saveUser(User user) {
        transactionManager.getSessionFactory().getCurrentSession().save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> ListOfUser = transactionManager.getSessionFactory().getCurrentSession().createQuery("from User").list();
        return ListOfUser;
    }
}
