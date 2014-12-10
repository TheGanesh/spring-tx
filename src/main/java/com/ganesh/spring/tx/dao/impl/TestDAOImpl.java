package com.ganesh.spring.tx.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.spring.tx.dao.TestDAO;
import com.ganesh.spring.tx.model.User;

@Service
public class TestDAOImpl implements TestDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

}
