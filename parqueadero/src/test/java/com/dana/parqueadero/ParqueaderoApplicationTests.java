package com.dana.parqueadero;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dana.service.IEstudianteService;

@SpringBootTest
class ParqueaderoApplicationTests {

	@Autowired
	private IEstudianteService estudianteService;

	@Test
	void contextLoads() {

		System.out.println(estudianteService.buscarporId(1));
	}

}
