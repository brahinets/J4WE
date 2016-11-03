package com.ysb.j2we.controller;

import com.ysb.j2we.model.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;

@Controller
public class PersonController {

    @Autowired
    IPersonService personService;

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public String person(@PathVariable Long id, Model m) {
        m.addAttribute("persons", Collections.singletonList(personService.get(id)));
        return "person";
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String persons(Model m) {
        m.addAttribute("persons", personService.list());
        return "person";
    }
}
