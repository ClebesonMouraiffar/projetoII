package com.projeto.clebeson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.clebeson.entity.CursoEntity;
import com.projeto.clebeson.entity.ServidorEntity;

@Repository
public interface ServidorDAO extends JpaRepository<ServidorEntity, Integer>{

}
