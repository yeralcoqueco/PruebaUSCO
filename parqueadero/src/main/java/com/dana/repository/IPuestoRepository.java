package com.dana.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dana.model.Puesto;

@Repository
public interface IPuestoRepository extends JpaRepository<Puesto, Integer> {

	@Query("from Puesto p where p.idParqueadero.id = :idParqueadero")
	public List<Puesto> listarPuestosParqueadero(@Param("idParqueadero") int idParqueadero);

}
