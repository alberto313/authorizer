/**
 * 
 */
package com.exercise.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.exercise.model.AccountResponse;


/**
 * @author Z749313
 *
 */
@RestControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<AccountResponse> handleServiceException(final ServiceException ex) {
		return new ResponseEntity<>(ex.getError(), INTERNAL_SERVER_ERROR);
	}
}
