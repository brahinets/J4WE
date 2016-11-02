package com.ysb.j2we.model.service.impl;

import com.ysb.j2we.model.service.IService;
import org.springframework.stereotype.Service;

@Service
public class TestService implements IService {
    public String getMessage(){
        return "2 b || ! 2 b";
    }
}