package com.projeto.clebeson.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.clebeson.dao.ServidorDAO;
import com.projeto.clebeson.entity.ServidorEntity;
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
	
	public ServidorEntity atualizar(ServidorEntity obj) {
		//obj -> recebido do cliente
		//curso_banco -> Recuperado do Banco
		ServidorEntity servidor_banco = buscar(obj.getId());
		if (obj.getNome()==null) {
			obj.setNome(servidor_banco.getNome());
		}
		if (obj.getEmail()==null) {
			obj.setEmail(servidor_banco.getEmail());
		}
		if (obj.getSenha()==null) {
			obj.setSenha(servidor_banco.getSenha());;
		}
		return dao.save(obj);
	}
	
	public Page<ServidorEntity>BuscarPorPagina( Integer pagina, Integer qtdLinhas, String orderBy, String dir){
		PageRequest pageRequest=PageRequest.of(pagina, qtdLinhas, Direction.valueOf(dir),orderBy);
		
		return dao.findAll(pageRequest);
	}
}
