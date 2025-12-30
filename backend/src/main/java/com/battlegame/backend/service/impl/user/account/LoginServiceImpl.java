package com.battlegame.backend.service.impl.user.account;

import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.battlegame.backend.pojo.User;
import com.battlegame.backend.service.impl.utils.UserDetailsImpl;
import com.battlegame.backend.service.user.account.LoginService;
import com.battlegame.backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Map<String, String> getToken(String username, String password) throws Exception{

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        try {
            Authentication authenticate = authenticationManager.authenticate(authenticationToken); //如果登陆失败，会自动处理

            UserDetailsImpl loginUser = (UserDetailsImpl) authenticate.getPrincipal();
            User user = loginUser.getUser();

            String jwt = JwtUtil.createJWT(user.getId().toString());
            Map<String, String> map = new HashMap<>();
            map.put("error_message", "success");
            map.put("token", jwt);

            return map;
        } catch (Exception e){
            Map<String, String> map = new HashMap<>();
            map.put("error_message", e.toString());
            return map;
        }


    }
}
