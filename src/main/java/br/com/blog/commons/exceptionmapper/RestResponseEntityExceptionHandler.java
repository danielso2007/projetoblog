package br.com.blog.commons.exceptionmapper;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javassist.NotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ AccessDeniedException.class })
	public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
		logger.error(ex);
		return new ResponseEntity<>("Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		logger.error(ex);
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolationException(Exception ex, WebRequest request) {
		logger.error(ex);
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ NotFoundException.class })
	public ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request) {
		logger.error(ex);
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({ BadCredentialsException.class })
	public ResponseEntity<Object> handleBadCredentialsException(Exception ex, WebRequest request) {
		logger.error(ex);
		return new ResponseEntity<>("Login ou senha inválido", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler({ DisabledException.class })
	public ResponseEntity<Object> handleDisabledException(Exception ex, WebRequest request) {
		logger.error(ex);
		return new ResponseEntity<>("Sua conta expirou. Entre em contato com a administração.", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
	}
	
}
