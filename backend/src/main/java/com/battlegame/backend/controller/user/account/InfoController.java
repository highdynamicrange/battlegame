package com.battlegame.backend.controller.user.account;

import com.battlegame.backend.service.user.account.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InfoController {
    @Autowired
    private InfoService infoService;

    @CrossOrigin
    @GetMapping("/user/account/info/")
    public Map<String, String> getinfo(){
        return infoService.getInfo();
    }
}
