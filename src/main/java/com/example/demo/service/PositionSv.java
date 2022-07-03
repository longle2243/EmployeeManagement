package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Position;
import com.example.demo.repository.PositionRepo;

@Service
@Transactional
public class PositionSv {
	@Autowired
	private PositionRepo repo;

	public List<Position> listAll() {
		return repo.findAll();
	}

	public void save(Position ent) {
		repo.save(ent);
	}

	public Position get(int id) {
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}
}