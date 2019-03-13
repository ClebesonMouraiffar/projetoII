package com.projeto.clebeson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.clebeson.entity.CursoEntity;

@Repository
public interface CursoDAO extends JpaRepository<CursoEntity, Integer>{

}
