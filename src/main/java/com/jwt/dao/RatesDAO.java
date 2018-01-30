package com.jwt.dao;

import java.util.List;

import com.jwt.model.Rates;

public interface RatesDAO {
	public void addRates(Rates rates);
	public void deleteRates(Rates rates);
	public void updateRate(Rates rates);
	public Rates getRates(java.sql.Date date);
	public List<Rates> getAllRates();
}