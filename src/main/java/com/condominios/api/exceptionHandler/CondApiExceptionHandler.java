package com.condominios.api.exceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.condominios.api.service.exception.EnderecoInexistenteException;

@ControllerAdvice
public class CondApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(value = { EnderecoInexistenteException.class })
	protected ResponseEntity<Object> handleEndInexistente(RuntimeException ex, WebRequest request) {

		String mensagemUsuario = messageSource.getMessage("endereco.inexistente", null,
				LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
		Erro erro = new Erro(mensagemUsuario, mensagemDesenvolvedor);

		return handleExceptionInternal(ex, erro, new HttpHeaders(), 
				HttpStatus.BAD_REQUEST, request);
	}

/*	@ExceptionHandler(value = {HttpMessageNotReadableException.class})
	protected ResponseEntity<Object> handleInvalidFormatException(RuntimeException ex, WebRequest request) {

		String mensagemUsuraio = messageSource.getMessage("formato.invalido", null,
				LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
		Erro erro = new Erro(mensagemUsuraio, mensagemDesenvolvedor);

		return handleExceptionInternal(ex, erro, new HttpHeaders(), 
				HttpStatus.UNPROCESSABLE_ENTITY, request);
	}*/
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		
		String mensagemUsuario = messageSource.getMessage("mensagem.invalida", null, 
				LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getCause() != null ? 
				ex.getCause().toString() : ex.toString();
		Erro erro = new Erro(mensagemUsuario, mensagemDesenvolvedor);
		
		return handleExceptionInternal(ex, erro, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Object> handleEmptyResultDataAccessException(
			EmptyResultDataAccessException ex, WebRequest request) {
		
		String mensagemUsuario = messageSource.getMessage("recurso.nao-encontrado", null, 
				LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		Erro erro = new Erro(mensagemUsuario, mensagemDesenvolvedor);
		return handleExceptionInternal(ex, erro, new HttpHeaders(), HttpStatus.NOT_FOUND, 
				request);
	}
	
	public static class Erro {
		private String mensagemUsuario;
		private String mensagemDesenvolvedor;

		public Erro(String mensagemUsuario, String mensagemDesenvolvedor) {
			this.mensagemUsuario = mensagemUsuario;
			this.mensagemDesenvolvedor = mensagemDesenvolvedor;
		}

		public String getMensagemUsuario() {
			return mensagemUsuario;
		}

		public String getMensagemDesenvolvedor() {
			return mensagemDesenvolvedor;
		}
	}
}
