package com.ysb.j2we.model.dao.impl;

import com.ysb.j2we.model.dao.IPersonDAO;
import com.ysb.j2we.model.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PersonDAO implements IPersonDAO {

    @Autowired
    private SessionFactory factory;

    @Override
    @Transactional
    public Person get(Long id) {
        return factory.getCurrentSession().get(Person.class, id);
    }

    @Override
    @Transactional
    public List<Person> list() {
        CriteriaQuery<Person> criteria = factory.getCurrentSession().getCriteriaBuilder().createQuery(Person.class);
        Root<Person> root = criteria.from(Person.class);
        CriteriaQuery<Person> select = criteria.select(root);
        
        return factory.getCurrentSession().createQuery(select).getResultList();
    }
}
