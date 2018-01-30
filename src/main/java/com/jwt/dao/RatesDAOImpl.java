package com.jwt.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jwt.model.Rates;

@Repository
public class RatesDAOImpl implements RatesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addRates(Rates rates) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(rates);
	}

	@Override
	public void deleteRates(Rates rates) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(rates);
	}

	@Override
	public void updateRate(Rates rates) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(rates);
	}

	@Override
	public Rates getRates(Date date) {
		// TODO Auto-generated method stub
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Rates.class);
		criteria.add(Restrictions.eq("date", date));
		criteria.addOrder(Order.desc("date"));
		return (Rates)criteria.uniqueResult();
	}

	@Override
	public List<Rates> getAllRates() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Rates").list();
	}
}