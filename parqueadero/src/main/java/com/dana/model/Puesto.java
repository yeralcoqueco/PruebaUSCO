package com.dana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "puesto", schema = "parqueaderobd")
public class Puesto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "estado" , nullable = false)
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "id_parqueadero" , nullable = false)
	private Parqueadero idParqueadero;
	
	@ManyToOne
	@JoinColumn(name = "id_estudiante" , nullable = true)
	private Estudiante idEstudiante;

}
