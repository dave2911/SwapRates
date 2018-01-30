package com.jwt.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", userName));		
		return (User) criteria.uniqueResult();
	}
}