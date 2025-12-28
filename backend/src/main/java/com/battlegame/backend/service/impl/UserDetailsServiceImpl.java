package com.battlegame.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.battlegame.backend.mapper.UserMapper;
import com.battlegame.backend.pojo.User;
import com.battlegame.backend.service.impl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //用QueryWrapper实现一个sql查询
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);

        //通过查询的方式找到某个数据
        User user = userMapper.selectOne(queryWrapper);
        if (user==null){
            throw new RuntimeException("No such user");
        }

        return new UserDetailsImpl(user);
    }
}
