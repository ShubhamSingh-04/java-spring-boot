package com.shubham.jpa_hibernate.dao;

import com.shubham.jpa_hibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    // implement findById()
    @Override
    public Student findById(Integer id){
        return theEntityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll(){
        TypedQuery<Student> theQuery = theEntityManager.createQuery("from Student order by lastName", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByFname(String firstName) {
        TypedQuery<Student> theQuery = theEntityManager.createQuery("from Student where firstName=:fName", Student.class);

        theQuery.setParameter("fName", firstName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student){
        theEntityManager.merge(student);
    }

    @Override
    @Transactional
    // updates all the rows
    public int updateEmailNull(){
        Query theQuery = theEntityManager.createQuery("update Student set email=NULL");

        return theQuery.executeUpdate(); // returns number of rows updated

//        return theEntityManager.createQuery("update Student set email=NULL")
//                .executeUpdate();
    }

    @Override
    @Transactional
    public void delete(Student student) {
        theEntityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        Query theQuery = theEntityManager.createQuery("delete from Student where id=:theId");
        theQuery.setParameter("theId", id);

        // returns void
//        theEntityManager.remove(
//                theEntityManager.find(Student.class, id)
//        );

        return theQuery.executeUpdate(); // returns number of rows affected
    }

    @Override
    @Transactional
    public int deleteAll(){
        return theEntityManager.createQuery("delete from Student").executeUpdate();
    }


}
