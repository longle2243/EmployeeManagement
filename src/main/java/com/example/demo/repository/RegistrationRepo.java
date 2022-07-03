package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Registration;

public interface RegistrationRepo extends JpaRepository<Registration, Integer>{
	@Query("SELECT a.employee.idemp, a.employee.name FROM Registration a WHERE a.time='Moring'")
	List<Object[]> congviecbuoisang();
	@Query("SELECT a.employee.idemp, a.employee.name FROM Registration a WHERE a.time='Afternoon'")
	List<Object[]> congviecbuoichieu();
	@Query("SELECT a.employee.idemp, a.employee.name FROM Registration a WHERE a.time='Everning'")
	List<Object[]> congviecbuoitoi();
	
	//nativeQuery = true
	@Query(value="SELECT * FROM registration, employee WHERE employee.username=?1 AND registration.idemp=employee.idemp",nativeQuery = true)
	List<Registration> getuserregistration(String username);
}
