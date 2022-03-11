package service;

import dao.IUser;
import entities.Trainer;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private IUser user;

    public void save(User user1){
        user.saveUser(user1);
    }

    public List<User> getAllUsers(){
        List<User> ListUser = user.getAllUser();
        return ListUser;
    }
}
