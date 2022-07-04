package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Registration;

public interface RegistrationRepo extends JpaRepository<Registration, Integer>{
	@Query(value="SELECT * FROM registration, employee WHERE registration.time='Morning' AND employee.idemp=registration.idemp",nativeQuery = true)
	List<Registration> congviecbuoisang();
	@Query(value="SELECT * FROM registration, employee WHERE registration.time='Afternoon' AND employee.idemp=registration.idemp",nativeQuery = true)
	List<Registration> congviecbuoichieu();
	@Query(value="SELECT * FROM registration, employee WHERE registration.time='Everning' AND employee.idemp=registration.idemp",nativeQuery = true)
	List<Registration> congviecbuoitoi();
	
	//nativeQuery = true
	@Query(value="SELECT * FROM registration, employee WHERE employee.username=?1 AND registration.idemp=employee.idemp",nativeQuery = true)
	List<Registration> getuserregistration(String username);
}
