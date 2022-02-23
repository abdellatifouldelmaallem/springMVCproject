package dao;

import entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

@Repository
public class RoleImpl implements IRole{
    @Autowired
    @Qualifier("transactionManager")
    private HibernateTransactionManager transactionManager;
    private Role role;

    @Override
    public void saveRole(Role role) {
        transactionManager.getSessionFactory().getCurrentSession().save(role);
    }

    @Override
    public void deleteRole(Long id) {
      role = (Role) transactionManager.getSessionFactory().getCurrentSession().load(Role.class,id);
      if (role!=null){
          transactionManager.getSessionFactory().getCurrentSession().delete(role);
      }
    }
}
