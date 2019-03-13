package com.projeto.clebeson.resource;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.clebeson.entity.AlunoEntity;
import com.projeto.clebeson.service.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	
	@Autowired
	AlunoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<AlunoEntity> listar() {
		List<AlunoEntity> lista = service.buscar();
	return lista; //listaAluno;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<AlunoEntity> buscar(@PathVariable Integer id){
		AlunoEntity objeto = service.buscar(id);
		if(objeto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(objeto);
	}
	
}
