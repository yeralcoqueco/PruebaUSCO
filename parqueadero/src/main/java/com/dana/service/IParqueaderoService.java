package com.dana.service;

import java.util.List;
import java.util.Optional;

import com.dana.model.Parqueadero;

public interface IParqueaderoService {
	
	void guardar(Parqueadero entity);

	void eliminar(Integer id);

	List<Parqueadero> buscarTodo();

	Optional<Parqueadero> buscarporId(Integer id);

}
