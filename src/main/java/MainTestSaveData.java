import configuration.ConfigurationBean;
import configuration.HibernateUtil;
import entities.Admin;
import entities.Role;


import entities.Trainer;
import entities.User;
import org.hibernate.HibernateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.AdminService;
import service.RoleService;
import service.TrainerService;
import service.UserService;

import java.util.List;

public class MainTestSaveData {

    public static void main(String[] args) {
    
 try{
     ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurationBean.class, HibernateUtil.class);

    /*Role roleUser = ctx.getBean(Role.class);
    roleUser.setUser("simple_User");

     Role roleAdmin = ctx.getBean(Role.class);
     roleAdmin.setUser("Admin");

     Role roleTrainer = ctx.getBean(Role.class);
     roleTrainer.setUser("trainer");

     RoleService roleService = ctx.getBean(RoleService.class);
     roleService.save(roleUser);
     roleService.save(roleAdmin);
     roleService.save(roleTrainer);



     UserService UserService = ctx.getBean(UserService.class);
     User user = ctx.getBean(User.class);
     user.setFullName("userName");
     user.setEmail("user@gmail.com");
     user.setPassWord("54321");
     user.setRole(roleUser);
     UserService.save(user);

     AdminService AdminService = ctx.getBean(AdminService.class);
     Admin admin = ctx.getBean(Admin.class);
     admin.setFullName("ABDELLATIF OULDELMAALEM");
     admin.setEmail("abdellatif@gmail.com");
     admin.setPassWord("12345");
     admin.setRole(roleAdmin);
     AdminService.save(admin);

     TrainerService trainerService = ctx.getBean(TrainerService.class);
     Trainer trainer = ctx.getBean(Trainer.class);
     trainer.setFullName("mohamed Rabah");
     trainer.setEmail("mohamed@gmail.com");
     trainer.setPassWord("AZERT");
     trainer.setSpeciality("teacher math");
     trainer.setRole(roleTrainer);
     trainer.setPhoneNamber(0666665667L);
     trainerService.RsaveTrainer(trainer);*/

    /* UserService userService = ctx.getBean(UserService.class);
     List<User> list = userService.getAllUsers();
     for (User name : list) {
         System.out.println(name);
     }*/
/*
     TrainerService trainerService = ctx.getBean(TrainerService.class);
     List<Trainer> list = trainerService.getAllTrainer();
     for (User name : list) {
         System.out.println("udhyyz"+name.toString());
     }*/



 }catch (HibernateException e ){
     //System.out.println("hi is the problem");
     e.printStackTrace();
 }




    }
}
