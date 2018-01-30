package com.jwt.service;

import java.util.List;

import com.jwt.model.Rates;

public interface RatesService {
	public void addRates(Rates rates);
	public void deleteRates(Rates rates);
	public void addAllRates(List<Rates> ratesList);
	public List<Rates> getAllRates();
	public String getCSV(List<Rates> rates);
	public String getJSON(List<Rates> rates);
	public Rates getRates(java.sql.Date date);
}
