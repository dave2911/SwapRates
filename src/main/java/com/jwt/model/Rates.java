package com.jwt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="RATES")
public class Rates implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private int swap_rate_id;
	
	@Column
	private java.sql.Date date;
	
	@Column
	private float inr;

	@Column
	private float cad;
	
	@Column
	private float aus;
	
	@Column
	private float eur;
	
	@Column
	private java.sql.Date last_updated;
	
	public float getInr() {
		return inr;
	}

	public void setInr(float inr) {
		this.inr = inr;
	}

	public float getCad() {
		return cad;
	}

	public void setCad(float cad) {
		this.cad = cad;
	}

	public float getAus() {
		return aus;
	}

	public void setAus(float aus) {
		this.aus = aus;
	}

	public float getEur() {
		return eur;
	}

	public void setEur(float eur) {
		this.eur = eur;
	}


	public int getSwap_rate_id() {
		return swap_rate_id;
	}

	public void setSwap_rate_id(int swap_rate_id) {
		this.swap_rate_id = swap_rate_id;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public java.sql.Date getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(java.sql.Date last_updated) {
		this.last_updated = last_updated;
	}	
}
