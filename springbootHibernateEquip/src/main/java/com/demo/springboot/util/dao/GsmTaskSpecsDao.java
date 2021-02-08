package com.demo.springboot.util.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.springboot.entity.GsmTaskSpecs;
import com.demo.springboot.util.HibernateUtil;


public class GsmTaskSpecsDao {
	public void saveStudent(GsmTaskSpecs gsmTaskSpecs) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(gsmTaskSpecs);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List <GsmTaskSpecs> getGsmTaskSpecs() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.createQuery("from Student", Student.class).list();
//        }
    	
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	return session.createQuery("from gsm_task_specs", GsmTaskSpecs.class).list();
    }
}