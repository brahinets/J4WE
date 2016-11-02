package com.ysb.j2we;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping("/*")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model m) {
        m.addAttribute("date", new Date());
        return "index";
    }
}
