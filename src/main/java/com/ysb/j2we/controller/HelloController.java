package com.ysb.j2we.controller;

import com.ysb.j2we.model.exception.PersonNotFoundException;
import com.ysb.j2we.model.exception.PersonNotFoundExceptionControllerSpecific;
import com.ysb.j2we.model.exception.PersonNotFoundExceptionHttpStatusCodeSpecific;
import com.ysb.j2we.model.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    @RequestMapping(method = RequestMethod.GET, value = "/PersonNotFoundExceptionHttpStatusCodeSpecific")
    public String index1() {
        throw new PersonNotFoundExceptionHttpStatusCodeSpecific("PersonNotFoundExceptionHttpStatusCodeSpecific");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/PersonNotFoundException")
    public String index2() {
        throw new PersonNotFoundException("PersonNotFoundException");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/PersonNotFoundExceptionControllerSpecific")
    public String index3() {
        throw new PersonNotFoundExceptionControllerSpecific("PersonNotFoundExceptionControllerSpecific");
    }

    @ExceptionHandler(PersonNotFoundExceptionControllerSpecific.class)
    public ResponseEntity eh() {
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
