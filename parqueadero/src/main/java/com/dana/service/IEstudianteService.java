package com.dana.service;

import java.util.List;
import java.util.Optional;

import com.dana.model.Estudiante;

public interface IEstudianteService {
	
	void guardar(Estudiante entity);
	
	List<Estudiante> buscarTodo();
	
	Optional<Estudiante> buscarporId(Integer id);
	
	public void asignarEstudiante(String nombre,String codigo,int idPuesto);
	

}
