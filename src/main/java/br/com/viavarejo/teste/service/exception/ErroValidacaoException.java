package br.com.viavarejo.teste.service.exception;

import java.io.Serializable;

public class ErroValidacaoException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;

	private String field;
	private String message;

	public ErroValidacaoException() {
	}

	public ErroValidacaoException(String message) {
		super();
		this.message = message;
	}

	public ErroValidacaoException(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
