package com.battlegame.backend.controller.user;

import com.battlegame.backend.mapper.UserMapper;
import com.battlegame.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper; //在MyBatis-Plus的官网有文档说明这个类继承了 BaseMapper里面的那些东西

    @GetMapping("/user/all/")
    public List<User> getAll(){
        return userMapper.selectList(null);
    }

    @GetMapping("/user/{userId}/")
    public User getUser(@PathVariable int userId){
        return userMapper.selectById(userId);
    }

    @GetMapping("/user/add/{userid}/{username}/{password}/")
    public String addUser(@PathVariable int userid,
                          @PathVariable String username,
                          @PathVariable String password){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(userid, username, encodedPassword);
        userMapper.insert(user);
        return "Added a new user successfully";
    }


}
