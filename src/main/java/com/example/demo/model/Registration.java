package com.example.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idreg")
	private Integer idreg;
	private String time;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "idemp")
	private Employee employee;

//    @ManyToMany(mappedBy = "registrations")
//    private Set<Assignment> assignment;
    
	public Integer getIdreg() {
		return idreg;
	}

	public void setIdreg(Integer idreg) {
		this.idreg = idreg;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Registration [idreg=" + idreg + ", time=" + time + ", date=" + date + ", employee=" + employee + "]";
	}
}
