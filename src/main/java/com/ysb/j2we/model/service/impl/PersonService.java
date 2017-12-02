package com.ysb.j2we.model.service.impl;

import com.ysb.j2we.model.dao.IPersonDAO;
import com.ysb.j2we.model.entity.Person;
import com.ysb.j2we.model.exception.PersonNotFoundException;
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
        Person person = personDAO.get(id);

        if (person == null) {
            throw new PersonNotFoundException(String.format("Person with id: %d not found", id));
        }

        return person;
    }

    @Override
    public Collection<Person> list() {
        return personDAO.list();
    }
}
