import configuration.ConfigurationBean;
import configuration.HibernateUtil;
import configuration.WebServletConfiguration;
import dao.IRole;
import dao.RoleImpl;
import entities.Admin;
import entities.Role;
import entities.Trainer;
import entities.User;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.RoleAdmin;
import service.RoleService;

public class MainTestSaveData {

    public static void main(String[] args) {
    
 try{
     ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurationBean.class, HibernateUtil.class);



     RoleService roleService = ctx.getBean(RoleService.class);
     Role roleUser = ctx.getBean(Role.class);
     roleUser.setUser("admin");
     roleService.save(roleUser);

     RoleAdmin roleAdmin = ctx.getBean(RoleAdmin.class);
     Admin admin = ctx.getBean(Admin.class);
     admin.setFullName("ABDELLATIF OULDELMAALEM");
     admin.setEmail("abdellatif@gmail.com");
     admin.setPassWord("12345");
     admin.setRole(roleUser);






 }catch (HibernateException e ){
     //System.out.println("hi is the problem");
     e.printStackTrace();
 }




    }
}
