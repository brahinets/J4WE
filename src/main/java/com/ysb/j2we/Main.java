package com.ysb.j2we;

import com.ysb.j2we.model.service.IService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext("com.ysb.j2we.model");
        
        IService s = c.getBean(IService.class);
        System.out.println(s.getMessage());
    }
}
