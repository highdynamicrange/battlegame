package com.battlegame.backend.service.impl.user.account;

import com.battlegame.backend.pojo.User;
import com.battlegame.backend.service.impl.utils.UserDetailsImpl;
import com.battlegame.backend.service.user.account.InfoService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InfoServiceImpl implements InfoService {

    @Override
    public Map<String, String> getInfo() {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        Map<String, String> map = new HashMap<>();
        map.put("errpr_message", "success");
        map.put("id", user.getId().toString());
        map.put("useraname", user.getUsername());
        map.put("photo", user.getPhoto());
        return map;
    }
}
