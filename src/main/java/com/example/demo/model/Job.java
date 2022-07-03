package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idjob")
	private Integer idjob;
	private String job,description,salary;
	public Integer getIdjob() {
		return idjob;
	}
	public void setIdjob(Integer idjob) {
		this.idjob = idjob;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Job [idjob=" + idjob + ", job=" + job + ", description=" + description + ", salary=" + salary + "]";
	}
	
	
}
