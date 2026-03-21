package com.shubham.jpa_hibernate.dao;

import com.shubham.jpa_hibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define filed for entity manager
    private EntityManager theEntityManager;

    // inject entity manager using constructor
    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager){
        this.theEntityManager = theEntityManager;
    }


    // implement save()
    @Override
    @Transactional
    public void save(Student theStudent){
        theEntityManager.persist(theStudent);
    }
}
