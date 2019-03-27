package com.projeto.clebeson.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.clebeson.DTO.CursoDTO;
import com.projeto.clebeson.entity.CursoEntity;
import com.projeto.clebeson.service.CursoService;

import net.bytebuddy.implementation.bytecode.constant.DefaultValue;

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
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid  @RequestBody CursoDTO objDTO){
		
		CursoEntity obj = new CursoEntity(null, objDTO.getNome(), objDTO.getNivel(), objDTO.getTurno());
		obj = service.salvar(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	//Listar todos -> localhost:8000/sursos [GET]
	//Listar um -> localhost:8000/sursos/1 [GET]
	//Adicionar -> localhost:8000/sursos [POST]
	//eDITAR -> localhost:8000/sursos/1 [PUT]
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void>atualizar(@Valid  @RequestBody CursoDTO objDTO, @PathVariable Integer id){
		
		CursoEntity obj = new CursoEntity(id, objDTO.getNome(), objDTO.getNivel(), objDTO.getTurno());
		
		obj.setId(id);
		
		obj = service.atualizar(obj);
		
		return ResponseEntity.noContent().build();//204
	}
	
	@RequestMapping(value="/paginacao", method=RequestMethod.GET)
	public ResponseEntity<Page<CursoDTO>> listarPaginas(
			@RequestParam(value="pagina", defaultValue="0") Integer pagina, 
			@RequestParam(value="qtd", defaultValue="15") Integer qtdLinhas, 
			@RequestParam(value="ordem", defaultValue="nome") String orderBy, 
			@RequestParam(value="dir", defaultValue="DESC") String dir){
		
		Page<CursoEntity> listaCursos = service.BuscarPorPagina(pagina, qtdLinhas, orderBy, dir);
		Page<CursoDTO> listaDTO = listaCursos.map(obj -> new CursoDTO(obj));
		
		return ResponseEntity.ok().body(listaDTO);
	}
	
}
