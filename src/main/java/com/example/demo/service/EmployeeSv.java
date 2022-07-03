package com.example.demo.service;

import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EmployeeRepo;
import com.example.demo.repository.RoleRepository;
import com.example.demo.model.Employee;

@Service
@Transactional
public class EmployeeSv {

	@Autowired
	private EmployeeRepo repo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	public List<Employee> listAll() {
		return repo.findAll();
	}

	public void save(Employee employee) {
		employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
		employee.setRoles(new HashSet<>(roleRepository.findAll()));
		repo.save(employee);
	}

	public Employee get(int id) {
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}

	public Employee findByUsername(String username) {
		return repo.findByUsername(username);
	}

	public List<Employee> getinfouser(String username) {
		return repo.infoemp(username);
	}
}






