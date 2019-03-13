package com.projeto.clebeson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.clebeson.entity.CursoEntity;
import com.projeto.clebeson.entity.TurmaEntity;

@Repository
public interface TurmaDAO extends JpaRepository<TurmaEntity, Integer>{

}
