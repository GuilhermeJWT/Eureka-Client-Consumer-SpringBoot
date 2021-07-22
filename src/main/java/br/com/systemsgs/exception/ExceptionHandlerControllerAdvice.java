package br.com.systemsgs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(FalhaServicoOpenFeignException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public RestApiErrorsException falhaServicoOpenFeignException(FalhaServicoOpenFeignException falhaServicoOpenFeignException) {
		return new RestApiErrorsException(falhaServicoOpenFeignException.getMessage());
	}
}
