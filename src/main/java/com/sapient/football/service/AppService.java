package com.sapient.football.service;

import org.springframework.stereotype.Service;

@Service
public class AppService implements IService {
    @Override
    public String getTeamPosition(String jsonRequest) {
        return "Position : 12";
    }
}
