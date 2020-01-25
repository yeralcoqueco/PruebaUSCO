package com.dana.service;

import java.util.List;
import java.util.Optional;

import com.dana.model.Puesto;

public interface IPuestoService {
	
	void guardar(Puesto entity);

	void eliminar(Integer id);

	List<Puesto> buscarTodo();

	Optional<Puesto> buscarporId(Integer id);
	
	public void liberar(int idPuesto);

}
