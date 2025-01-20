package br.com.spring.erudio.api_gateway.exceptions.handler;


import br.com.spring.erudio.api_gateway.exceptions.ExceptionResponse;
import br.com.spring.erudio.api_gateway.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { Exception.class })
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex,  WebRequest request) {
        ExceptionResponse exceptionResponse=
                new ExceptionResponse(new Date(),
                        ex.getMessage(),
                        request.getDescription(false),
                        HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { ResourceNotFoundException.class })
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex,  WebRequest request) {
        ExceptionResponse exceptionResponse= new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false),
                HttpStatus.NOT_FOUND.value()
        );


        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
