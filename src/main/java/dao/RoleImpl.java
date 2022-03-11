package dao;

import entities.Role;
import entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public Role getRole(Long id) {
        role = transactionManager.getSessionFactory().getCurrentSession().get(Role.class,id);
        return role;
    }

    @Override
    public List<Role> getAllRole() {
        List<Role> roleList = transactionManager.getSessionFactory().getCurrentSession().createQuery("from Role").list();
        return roleList;
    }
}
