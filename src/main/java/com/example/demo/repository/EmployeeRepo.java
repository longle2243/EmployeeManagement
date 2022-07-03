package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	@Query("SELECT u FROM Employee u WHERE u.name = :name")
	Employee findUserById(@Param("name") String name);
	Employee findByUsername(String username);
	
	@Query(value = "SELECT * FROM employee AS c WHERE c.username = ?1",nativeQuery = true)
	List<Employee> infoemp(String username);
}
