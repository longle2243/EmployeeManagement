package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Assignment;


public interface AssignmentRepo extends JpaRepository<Assignment, Integer>{
	@Query(value="SELECT c.registration.employee.name, c.registration.employee.position.position, "
			+ "COUNT(c.registration.time),c.registration.employee.position.position.payscale, "
			+ "SUM(c.job.salary) * c.registration.employee.position.position.payscale "
			+ "FROM Assignment AS c WHERE c.registration.date BETWEEN convert(?1,DATE) "
			+ "AND convert(?2,DATE) GROUP BY c.registration.employee.idemp")
	List<Object[]> allsalary(String start, String end);

	@Query(value="SELECT c.registration.employee.name, c.registration.employee.position.position, "
			+ "COUNT(c.registration.time),c.registration.employee.position.position.payscale, "
			+ "SUM(c.job.salary) * c.registration.employee.position.position.payscale "
			+ "FROM Assignment AS c WHERE c.registration.date BETWEEN convert(?1,DATE) "
			+ "AND convert(?2,DATE) AND c.registration.employee.idemp=?3")
	List<Object[]> salary(String start, String end,Integer idemp);
	
	@Query(value="SELECT c FROM Assignment AS c WHERE c.registration.employee.idemp = ?1")
	List<Assignment> listUserAssign(Integer idemp);
}
