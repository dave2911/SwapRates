package com.jwt.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.dao.RatesDAO;
import com.jwt.model.Rates;



@Service
@Transactional
public class RatesServiceImpl implements RatesService {

	@Autowired
	private RatesDAO ratesDAO;
	
	
	@Override
	public void addRates(Rates rates) {
		// TODO Auto-generated method stub
		ratesDAO.addRates(rates);
	}


	@Override
	public void deleteRates(Rates rates) {
		// TODO Auto-generated method stub
		ratesDAO.deleteRates(rates);
	}


	@Override
	public void addAllRates(List<Rates> ratesList) {
		// TODO Auto-generated method stub
		for(Rates rate:ratesList)
			ratesDAO.addRates(rate);
	}


	@Override
	public List<Rates> getAllRates() {
		// TODO Auto-generated method stub
		return ratesDAO.getAllRates();
	}

	
	
	
	@Override
	public String getCSV(List<Rates> rates) {
		// TODO Auto-generated method stub
		String FILE_HEADER="DATE,INR,AUS,CAD,EUR,LASTUPDATED";
		final String NEW_LINE_SEPARATOR = "\n";
		final String COMMA_DELIMITER = ",";
		StringBuffer csvString=new StringBuffer();
		csvString.append(FILE_HEADER);
		csvString.append(NEW_LINE_SEPARATOR);
		for(Rates rate:rates)
		{
			csvString.append(rate.getDate());
			csvString.append(COMMA_DELIMITER);
			csvString.append(rate.getInr());
			csvString.append(COMMA_DELIMITER);
			csvString.append(rate.getAus());
			csvString.append(COMMA_DELIMITER);
			csvString.append(rate.getCad());
			csvString.append(COMMA_DELIMITER);
			csvString.append(rate.getEur());
			csvString.append(COMMA_DELIMITER);
			csvString.append(rate.getLast_updated());
			csvString.append(NEW_LINE_SEPARATOR);
		}
		return csvString.toString();
	}


	@Override
	public String getJSON(List<Rates> rates) {
		// TODO Auto-generated method stub
		String json="";
		JSONArray rootObject=new JSONArray();
		for(Rates rate:rates)
		{
			JSONObject obj = new JSONObject();
			obj.put("date",rate.getDate());
			obj.put("last_updated",rate.getLast_updated());
			JSONObject swaprates=new JSONObject();
			swaprates.put("inr",rate.getInr());
			swaprates.put("aus",rate.getAus());
			swaprates.put("cad",rate.getCad());
			swaprates.put("eur",rate.getEur());
			obj.put("rates",swaprates);
			rootObject.add(obj);
		}
		System.out.println("from here"+rootObject.toJSONString());
		return rootObject.toJSONString();
	}


	@Override
	public Rates getRates(Date date) {
		// TODO Auto-generated method stub
		return ratesDAO.getRates(date);
	}

}
