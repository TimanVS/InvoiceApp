package ua.timan.invoice.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	@ResponseStatus(value = BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgumentException(HttpServletRequest req,
			IllegalArgumentException exception) {
		Map<String, String> body = new HashMap<>();
		body.put("class", exception.getClass().getName());
		body.put("message", exception.getMessage());
		return new ResponseEntity<Object>(body, BAD_REQUEST);
	}
}