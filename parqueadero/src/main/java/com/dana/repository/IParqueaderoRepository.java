package com.dana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dana.model.Parqueadero;

@Repository
public interface IParqueaderoRepository extends JpaRepository<Parqueadero, Integer> {

}
