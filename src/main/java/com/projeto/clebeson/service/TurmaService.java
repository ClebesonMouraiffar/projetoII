package com.projeto.clebeson.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.clebeson.dao.CursoDAO;
import com.projeto.clebeson.dao.TurmaDAO;
import com.projeto.clebeson.entity.CursoEntity;
import com.projeto.clebeson.entity.TurmaEntity;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaDAO dao;
	
	public  List<TurmaEntity> buscar(){
		return dao.findAll();
	}
	
	public TurmaEntity buscar(Integer id) {
		Optional<TurmaEntity> objeto = dao.findById(id);
		return objeto.orElse(null);
	}
	
	
}
