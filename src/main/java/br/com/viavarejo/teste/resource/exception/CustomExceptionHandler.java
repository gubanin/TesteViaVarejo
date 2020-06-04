package br.com.viavarejo.teste.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.viavarejo.teste.service.exception.ErroValidacaoException;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(ErroValidacaoException.class)
	public ResponseEntity<StandardError> erroValidacao(ErroValidacaoException e, HttpServletRequest request) {

		StandardError error = new StandardError(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
	}
}
