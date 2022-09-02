package com.greatlearning.studentManagement.service;

import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.greatlearning.studentManagement.entity.Student;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Repository
public class StudentServiceImplementation implements StudentService {

	private SessionFactory sessionFactory;
	private Session session;
	
	@Autowired
	public StudentServiceImplementation(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		
		try {
			session=sessionFactory.getCurrentSession();
		}
		catch(HibernateException e) {
			session=sessionFactory.openSession();
		}
	}

	@Transactional
	@Override
	public List<Student> findAll() {

		Transaction tx = session.beginTransaction();
		List<Student> students = session.createQuery("from Student").list();
		tx.commit();

		return students;
	}

	@Override
	public Student findById(int theId) {
		Student student = new Student();
		
		Transaction tx = session.beginTransaction();
		student=session.get(Student.class, theId);
		tx.commit();
		
		return student;
	}

	@Override
	public void save(Student thestudent) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(thestudent);
		tx.commit();
		
	}

	@Override
	public void deleteById(int theId) {
		Student student = new Student();
		
		Transaction tx = session.beginTransaction();
		student=session.get(Student.class, theId);
		session.delete(student);
		
		tx.commit();
		
	}

}