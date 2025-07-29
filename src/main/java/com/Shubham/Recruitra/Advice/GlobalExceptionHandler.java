package com.Shubham.Recruitra.Advice;

import com.Shubham.Recruitra.Exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<String> handleGlobalException(CompanyNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<String> handleGlobalException(JobNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ApplicantNotFoundException.class)
    public ResponseEntity<String> handleGlobalException(ApplicantNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ApplicationNotFoundException.class)
    public ResponseEntity<String> handleGlobalException(ApplicationNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CompanyExistException.class)
    public ResponseEntity<String> handleGlobalException(CompanyExistException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
    }
}
