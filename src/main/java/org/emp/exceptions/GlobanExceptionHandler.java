package org.emp.exceptions;

import org.emp.responseObjects.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobanExceptionHandler extends ResponseEntityExceptionHandler {

        @ResponseStatus(HttpStatus.CONFLICT)  // 409
        @ExceptionHandler(EmployeeNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException message){
            ErrorResponse res = ErrorResponse.builder().errorMessage(message.getMessage()).status("FAILED").build();
            return ResponseEntity.ok().body(res);
        }



}
