package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Position;

public interface PositionRepo extends JpaRepository<Position, Integer>{

}
