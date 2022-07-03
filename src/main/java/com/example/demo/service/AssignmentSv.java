package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Assignment;
import com.example.demo.repository.AssignmentRepo;

@Service
public class AssignmentSv {
	@Autowired
	private AssignmentRepo repo;
	
	public List<Assignment> listAll(){
		return repo.findAll();
	}	
	public void save(Assignment ent) {
		repo.save(ent);
	}
	public List<Object[]> getAllSalary(String start, String end) {
		return repo.allsalary(start,end);
	}
	public List<Object[]> getSalary(String start, String end, Integer idemp) {
		return repo.salary(start,end,idemp);
	}
}
