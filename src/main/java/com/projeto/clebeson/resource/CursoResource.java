package com.projeto.clebeson.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.clebeson.entity.CursoEntity;

@RestController
@RequestMapping(value="/cursos")
public class CursoResource {
	

	@RequestMapping(method=RequestMethod.GET)
	public List<CursoEntity> listar() {
		CursoEntity curso1 = new CursoEntity(1, "Sistemas", "Superior", "Noturno");
		
		CursoEntity curso2 = new CursoEntity(2, "Biologia", "Superior", "Diurno");
		
		List<CursoEntity> listaCursos = new ArrayList<>();
		
		listaCursos.add(curso1);
		listaCursos.add(curso2);
		
		return listaCursos;
	}
	
	
}
