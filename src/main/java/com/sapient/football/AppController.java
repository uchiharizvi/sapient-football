package com.sapient.football;

import com.sapient.football.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    
    @Autowired
    private IService service;

    @PostMapping("v1/getTeamPosition")
    public String getTeamPosition(@RequestBody String jsonRequest){

        return service.getTeamPosition(jsonRequest);
    }
}
