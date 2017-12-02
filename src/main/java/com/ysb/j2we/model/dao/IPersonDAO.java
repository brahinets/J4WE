package com.ysb.j2we.model.dao;

import com.ysb.j2we.model.entity.Person;

import java.util.Collection;

public interface IPersonDAO {
    Person get(Long id);

    Collection<Person> list();
}
