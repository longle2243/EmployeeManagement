package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Job;

public interface JobRepo extends JpaRepository<Job, Integer>{
	@Query("SELECT a.employee.idemp, a.employee.name FROM Registration a WHERE a.time='Moring'")
	List<Object[]> congviecbuoisang();
	@Query("SELECT a.employee.idemp, a.employee.name FROM Registration a WHERE a.time='Afternoon'")
	List<Object[]> congviecbuoichieu();
	@Query("SELECT a.employee.idemp, a.employee.name FROM Registration a WHERE a.time='Everning'")
	List<Object[]> congviecbuoitoi();
	
	
	@Query(value ="SELECT a.time, a.date FROM Registration AS a WHERE a.employee.idemp=?1",nativeQuery = true)
	Job congvieccanhan(Integer manv);
}
