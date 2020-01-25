package com.dana.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dana.model.Estudiante;
import com.dana.model.Puesto;
import com.dana.repository.IEstudianteRepository;
import com.dana.service.IEstudianteService;
import com.dana.service.IPuestoService;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository repo;

	@Autowired
	private IPuestoService servicioPuesto;

	@Override
	public void guardar(Estudiante entity) {
		repo.save(entity);
	}

	@Override
	public List<Estudiante> buscarTodo() {
		return repo.findAll();
	}

	@Override
	public Optional<Estudiante> buscarporId(Integer id) {
		return repo.findById(id);
	}

	@Override
	public void asignarEstudiante(String nombre, String codigo, int idPuesto) {

		Estudiante estudiante = new Estudiante();
		estudiante.setNombreEst(nombre);
		estudiante.setCodigoEst(codigo);
		this.guardar(estudiante);

		Puesto puesto = servicioPuesto.buscarporId(idPuesto).get();
		puesto.setIdEstudiante(estudiante);
		puesto.setEstado(true);
		servicioPuesto.guardar(puesto);
	}
}
