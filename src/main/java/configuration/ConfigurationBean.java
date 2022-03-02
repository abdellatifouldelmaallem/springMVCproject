package configuration;

import entities.Admin;
import entities.Role;
import entities.Trainer;

import entities.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"entities", "dao", "service"})
public class ConfigurationBean {

    @Bean
    @Primary
    @Scope("prototype")
    public User getUser(){
        return new User();
    }

    @Bean
    @Scope("prototype")
    public Admin getAdmin(){
        return new Admin();
    }

    @Bean
    @Scope("prototype")
    public Trainer getTrainer(){
        return new Trainer();
    }

    @Bean
    @Scope("prototype")
    public Role getRole(){
        return new Role();
    }
}
