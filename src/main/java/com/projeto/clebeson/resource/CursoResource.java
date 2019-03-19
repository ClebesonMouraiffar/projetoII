package com.projeto.clebeson.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.clebeson.DTO.CursoDTO;
import com.projeto.clebeson.entity.CursoEntity;
import com.projeto.clebeson.service.CursoService;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {
	
	@Autowired
	CursoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<CursoDTO> listar() { 
		List<CursoEntity> listaEntity = service.buscar();
		List<CursoDTO> listaDTO = listaEntity.stream().map(obj -> new CursoDTO(obj)).collect(Collectors.toList());
	return listaDTO; //listaCurso;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<CursoEntity> buscar(@PathVariable Integer id){
		CursoEntity curso = service.buscar(id);
		return ResponseEntity.ok(curso);
	}
	
}
