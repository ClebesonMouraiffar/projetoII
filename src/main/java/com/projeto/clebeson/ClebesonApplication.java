package com.projeto.clebeson;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.clebeson.dao.CursoDAO;
import com.projeto.clebeson.dao.TurmaDAO;
import com.projeto.clebeson.entity.CursoEntity;
import com.projeto.clebeson.entity.TurmaEntity;

@SpringBootApplication
public class ClebesonApplication implements CommandLineRunner{
	
	@Autowired
	private CursoDAO cursoDAO;
	
	@Autowired
	private TurmaDAO turmaDAO;

	public static void main(String[] args) {
		SpringApplication.run(ClebesonApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
											//id, descrião, nivel e turma
		CursoEntity curso1 = new CursoEntity(null, "Sistemas para Internet", "Superior", "Noturno");
		CursoEntity curso2 = new CursoEntity(null, "Biologia", "Superior", "Diurno");
		
		/*****/
		TurmaEntity turma1 = new TurmaEntity(null, "Turma Formandos", 5, curso1);
		TurmaEntity turma2 = new TurmaEntity(null, "Turma Nova", 1, curso1);
		TurmaEntity turma3 = new TurmaEntity(null, "Turma ", 2, curso2);
		
		curso1.getTurmas().addAll(Arrays.asList(turma1,turma2));
		curso2.getTurmas().addAll(Arrays.asList(turma3));
				
		cursoDAO.saveAll(Arrays.asList(curso1, curso2));
		
	}

}
