package com.projeto.clebeson.exceptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ErroValidacao extends ErroResource{
	private static final long serialVersionUID = 1L;
	
	private List<MensagemErroCampoException> listaErros = new ArrayList<>();
	
	public ErroValidacao(Integer httpStatus, String msg) {
		super(httpStatus, msg);
	}

	public List<MensagemErroCampoException> getListaErros() {
		return listaErros;
	}

	public void setListaErros(List<MensagemErroCampoException> listaErros) {
		this.listaErros = listaErros;
	}
	
	public void addErro(String campo, String msg) {
		MensagemErroCampoException m = new MensagemErroCampoException(campo, msg);
		
		this.listaErros.add(m);
	}

}
