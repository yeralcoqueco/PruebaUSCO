package com.dana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dana.model.Estudiante;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer> {

}
