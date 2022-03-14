package dao;

import entities.Admin;
import entities.Trainer;
import entities.User;
import org.hibernate.query.Query;
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




}
