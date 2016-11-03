package com.ysb.j2we.model.service;

import com.ysb.j2we.model.entity.Person;

import java.util.Collection;

public interface IPersonService {
    Person get(Long id);
    
    Collection<Person> list();
}
