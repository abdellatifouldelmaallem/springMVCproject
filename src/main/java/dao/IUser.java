package dao;

import entities.Trainer;
import entities.User;

import java.util.List;

public interface IUser {
    void saveUser(User user);
    List<User> getAllUser();

}
