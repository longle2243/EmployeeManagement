package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpos")
	private Integer idpos;
	private String position;
	private float payscale;
	public Integer getIdpos() {
		return idpos;
	}
	public void setIdpos(Integer idpos) {
		this.idpos = idpos;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public float getPayscale() {
		return payscale;
	}
	public void setPayscale(float payscale) {
		this.payscale = payscale;
	}
	@Override
	public String toString() {
		return "Position [idpos=" + idpos + ", position=" + position + ", payscale=" + payscale + "]";
	}	
	
}
