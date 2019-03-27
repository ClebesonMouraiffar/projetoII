package com.projeto.clebeson.exceptions;

import java.io.Serializable;

public class MensagemErroCampoException implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String campo;
	private String mensagem;
	
	public MensagemErroCampoException() {
		super();
	}

	public MensagemErroCampoException(String campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
