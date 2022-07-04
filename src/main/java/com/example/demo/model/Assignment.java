package com.example.demo.model;

import java.util.Date;
import java.util.Set;

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
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idass;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date deadline;
	
	@ManyToOne
	@JoinColumn(name = "idjob")
	private Job job;
	@ManyToOne
	@JoinColumn(name = "idreg")
	private Registration registration;
	
//	@ManyToMany
//	private Set<Registration> registrations;
	
	public Integer getIdass() {
		return idass;
	}
	public void setIdass(Integer idass) {
		this.idass = idass;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Registration getRegistration() {
		return registration;
	}
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	@Override
	public String toString() {
		return "Assignment [idass=" + idass + ", deadline=" + deadline + ", job=" + job + ", registration="
				+ registration + "]";
	}
	
}



























