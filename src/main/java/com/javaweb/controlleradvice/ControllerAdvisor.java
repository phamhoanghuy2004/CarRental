package com.javaweb.controlleradvice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.beans.ErrorResponseDTO;
import com.javaweb.customeExceptions.FiledRequiredException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(FiledRequiredException.class)
	public ResponseEntity<Object> handlerLoginRequiredException (FiledRequiredException ex, WebRequest request){
		ErrorResponseDTO errorResponseDTO  = new ErrorResponseDTO();
		errorResponseDTO.setError(ex.getMessage());
		List<String> details = new ArrayList<>();
		details.add("Bạn phải nhập các trường bắt buộc!");
		errorResponseDTO.setDetails(details);
		return new ResponseEntity<>(errorResponseDTO,HttpStatus.BAD_REQUEST);
	}
	
	
}
