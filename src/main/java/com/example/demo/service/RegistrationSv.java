package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Registration;
import com.example.demo.repository.RegistrationRepo;

@Service
@Transactional
public class RegistrationSv {
	@Autowired
	private RegistrationRepo repo;

	public List<Registration> listAll() {
		return repo.findAll();
	}

	public void save(Registration ent) {
		repo.save(ent);
	}

	public Registration get(int id) {
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}
	
	// VIET THEM
	public List<Object[]> Jobsang() {
		return repo.congviecbuoisang();
	}

	public List<Object[]> Jobchieu() {
		return repo.congviecbuoichieu();
	}

	public List<Object[]> Jobtoi() {
		return repo.congviecbuoitoi();
	}
	
	public List<Registration> listuserregistration(String username) {
		return repo.getuserregistration(username);
	}
}