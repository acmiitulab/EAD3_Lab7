package com.example.demo.Service;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServise implements IUserServise {
    @Autowired
    private UserRep userRep;


    public User getById (int id) {
        return userRep.getById(id);
    }

    public Boolean isAdmin (String username, String pasw) {
        User user = userRep.getByUsername(username);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(pasw) && user.isAdmin();

    }

    public Boolean isUser (String username, String pasw) {
        User user = userRep.getByUsername(username);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(pasw) ;
    }

    public User getByUsername(String username) {
        return userRep.getByUsername(username);
    }

    public void update (User user) {
        userRep.save(user);
    }

    public List<User> getAllUsersBy() {
        return userRep.getUsersBy();
    }

    public void DeleteByID(long id) {
        userRep.deleteById(id);
    }


}