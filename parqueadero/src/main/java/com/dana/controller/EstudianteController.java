package com.dana.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dana.model.Estudiante;
import com.dana.service.IEstudianteService;

@RestController
@RequestMapping("api/estudiante")
public class EstudianteController {

	@Autowired
	private IEstudianteService service;

	@PostMapping
	public void guardar(@RequestBody Estudiante entity) {
		service.guardar(entity);
	}

	@GetMapping(path = "buscar-todo")
	public List<Estudiante> buscarTodo() {

		return service.buscarTodo();
	}

	@GetMapping(path = "buscar/{id}")
	public ResponseEntity<?> buscarporId(@PathVariable Integer id) {

		Optional<Estudiante> estudiante = service.buscarporId(id);

		if (estudiante.isPresent()) {
			return new ResponseEntity<>(estudiante.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "asignarEstudiante/{nombre}/{codigo}/{idPuesto}")
	public void asignarEstudiante(@PathVariable String nombre, @PathVariable String codigo,
			@PathVariable int idPuesto) {
		service.asignarEstudiante(nombre, codigo, idPuesto);
	}

}
