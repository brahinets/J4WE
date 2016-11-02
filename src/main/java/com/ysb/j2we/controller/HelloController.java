package com.ysb.j2we.controller;

import com.ysb.j2we.model.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping("/*")
public class HelloController {

    @Autowired
    IService s;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model m) {
        m.addAttribute("date", new Date());
        m.addAttribute("text", s.getMessage());
        return "index";
    }
}
