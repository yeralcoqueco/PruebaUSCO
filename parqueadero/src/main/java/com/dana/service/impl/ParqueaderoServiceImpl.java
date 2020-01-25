package com.dana.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dana.model.Parqueadero;
import com.dana.repository.IParqueaderoRepository;
import com.dana.service.IParqueaderoService;

@Service
public class ParqueaderoServiceImpl implements IParqueaderoService{

	@Autowired
	private IParqueaderoRepository repo;
	
	@Override
	public void guardar(Parqueadero entity) {
		repo.save(entity);
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public List<Parqueadero> buscarTodo() {
		return repo.findAll();
	}

	@Override
	public Optional<Parqueadero> buscarporId(Integer id) {
		return repo.findById(id);
	}

}
