package com.projeto.clebeson.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.clebeson.DTO.ServidorDTO;
import com.projeto.clebeson.entity.ServidorEntity;
import com.projeto.clebeson.service.ServidorService;

@RestController
@RequestMapping(value = "/servidores")
public class ServidorResource {
	
	@Autowired
	ServidorService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ServidorDTO> listar() { 
		List<ServidorEntity> listaEntity = service.buscar();
		List<ServidorDTO> listaDTO = listaEntity.stream().map(obj -> new ServidorDTO(obj)).collect(Collectors.toList());
	return listaDTO; //listaCurso;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<ServidorEntity> buscar(@PathVariable Integer id){
		ServidorEntity curso = service.buscar(id);
		return ResponseEntity.ok(curso);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody ServidorEntity obj){
		
		obj = service.salvar(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}
