package com.projeto.clebeson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.clebeson.entity.AlunoEntity;
import com.projeto.clebeson.entity.CursoEntity;

@Repository
public interface AlunoDAO extends JpaRepository<AlunoEntity, Integer>{

}
