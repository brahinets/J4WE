package com.ysb.j2we.model.service.impl;

import com.ysb.j2we.model.entity.Person;
import com.ysb.j2we.model.dao.IPersonDAO;
import com.ysb.j2we.model.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonService implements IPersonService {

    @Autowired
    IPersonDAO personDAO;

    @Override
    public Person get(Long id) {
        return personDAO.get(id);
    }

    @Override
    public Collection<Person> list() {
        return personDAO.list();
    }
}
