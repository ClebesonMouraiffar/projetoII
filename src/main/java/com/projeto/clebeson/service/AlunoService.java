package com.projeto.clebeson.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.clebeson.dao.CursoDAO;
import com.projeto.clebeson.dao.AlunoDAO;
import com.projeto.clebeson.entity.CursoEntity;
import com.projeto.clebeson.entity.AlunoEntity;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoDAO dao;
	
	public  List<AlunoEntity> buscar(){
		return dao.findAll();
	}
	
	public AlunoEntity buscar(Integer id) {
		Optional<AlunoEntity> objeto = dao.findById(id);
		return objeto.orElse(null);
	}
	
	
}
