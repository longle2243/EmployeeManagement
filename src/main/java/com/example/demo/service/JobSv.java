package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Job;
import com.example.demo.repository.JobRepo;

@Service
@Transactional
public class JobSv {
	@Autowired
	private JobRepo repo;

	public List<Job> listAll() {
		return repo.findAll();
	}

	public void save(Job ent) {
		repo.save(ent);
	}

	public Job get(int id) {
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}

	public List<Object[]> Jobsang() {
		return repo.congviecbuoisang();
	}

	public List<Object[]> Jobchieu() {
		return repo.congviecbuoichieu();
	}

	public List<Object[]> Jobtoi() {
		return repo.congviecbuoitoi();
	}
}