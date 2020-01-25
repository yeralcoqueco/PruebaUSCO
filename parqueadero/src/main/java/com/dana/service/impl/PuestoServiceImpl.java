package com.dana.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dana.model.Parqueadero;
import com.dana.model.Puesto;
import com.dana.repository.IPuestoRepository;
import com.dana.service.IPuestoService;
@Service
public class PuestoServiceImpl implements IPuestoService{

	@Autowired
	private IPuestoRepository repo;
	
	@Override
	public void guardar(Puesto entity) {
		repo.save(entity);
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);	
	}

	@Override
	public List<Puesto> buscarTodo() {
		return repo.findAll();
	}

	@Override
	public Optional<Puesto> buscarporId(Integer id) {
		return repo.findById(id);
	}

	@Override
	public void liberar(int idPuesto) {
		Puesto puesto = this.buscarporId(idPuesto).get();
		puesto.setIdEstudiante(null);
		puesto.setEstado(false);	
		this.guardar(puesto);
	}

	

}
