package com.projeto.clebeson.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.clebeson.dao.ServidorDAO;
import com.projeto.clebeson.entity.ServidorEntity;
import com.projeto.clebeson.exceptions.ObjNaoEncontradoException;

@Service
public class ServidorService {
	
	@Autowired
	private ServidorDAO dao;
	
	public  List<ServidorEntity> buscar(){
		return dao.findAll();
	}
	
	public ServidorEntity buscar(Integer id) {
		Optional<ServidorEntity> curso = dao.findById(id);
		//return curso.orElse(null);
		return curso.orElseThrow(()-> new ObjNaoEncontradoException("Curso Não Encontrado"));
	}
	
	public ServidorEntity salvar(ServidorEntity obj) {
		
		obj.setId(null);
		return dao.save(obj);
	}
	
	
}
