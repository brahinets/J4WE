package com.ysb.j2we.controller.rest;

import com.ysb.j2we.model.entity.Person;
import com.ysb.j2we.model.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonControllerRest {

    @Autowired
    private IPersonService personService;

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public Person getPerson(@RequestParam(name = "param") long param) {
        return personService.get(param);
    }
}
