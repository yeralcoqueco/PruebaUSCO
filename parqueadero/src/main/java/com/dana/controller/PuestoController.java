package com.dana.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dana.model.Puesto;
import com.dana.repository.IPuestoRepository;
import com.dana.service.IParqueaderoService;
import com.dana.service.IPuestoService;

@RestController
@RequestMapping("api/puesto")
public class PuestoController {

	@Autowired
	private IPuestoService service;

	@Autowired
	private IPuestoRepository repo;

	@PostMapping
	public void guardar(@RequestBody Puesto entity) {
		service.guardar(entity);
	}

	@DeleteMapping(path = "{id}")
	public void eliminar(Integer id) {
		service.eliminar(id);
	}

	@GetMapping(path = "buscar-todo")
	public List<Puesto> buscarTodo() {

		return service.buscarTodo();
	}

	@GetMapping(path = "buscar/{id}")
	public ResponseEntity<?> buscarporId(@PathVariable Integer id) {

		Optional<Puesto> puesto = service.buscarporId(id);

		if (puesto.isPresent()) {
			return new ResponseEntity<>(puesto.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "listarPuestosParqueadero/{idParqueadero}")
	public List<Puesto> listarPuestosParqueadero(@PathVariable int idParqueadero) {
		return repo.listarPuestosParqueadero(idParqueadero);
	}
	
	@GetMapping(path = "liberar/{idPuesto}")
	public void liberar(@PathVariable int idPuesto) {
		service.liberar(idPuesto);
	}

}
