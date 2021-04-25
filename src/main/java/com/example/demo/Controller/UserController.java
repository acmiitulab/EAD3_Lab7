package com.example.demo.Controller;


import com.example.demo.Models.User;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserServise userServise;


    @GetMapping("")
    public List<User> getAllUsers() {
        return userServise.getAllUsersBy();
    }

    @GetMapping("/{id}")
    public User getAllUsers(@PathVariable("id") int id) {
        return userServise.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserByID(@PathVariable("id") long id) {
         userServise.DeleteByID(id);
    }


    @PostMapping("")
    public void createUser( @RequestParam("username") String name, @RequestParam("password") String password) {
        User user =  new User(0, name, password, false);

        userServise.update(user);

    }

    @PutMapping("")
    public void updateUser( @RequestParam("username") String name, @RequestParam("password") String password) {
        User user = userServise.getByUsername(name);
        if (user == null) {
            return;
        }
        user.setPassword(password);
        userServise.update(user);
    }



}
