package com.demo_api.demo_api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//Definimos la clase como un controller advice
@ControllerAdvice
public class EmployeeNotFoundAdvice {
    // @ResponseBody: Definimos que lo que retorne la funcion
    // sea enviado ocmo respuesta HTTP
    
    // @ExceptionHandler(EmployeeNotFoundException.class):
    // Definimos que la excepcion sea controlada por nuestro 
    // EMployeeNotFoundException.
    
    //@ResponseStatus(HttpStatus.NOT_FOUND): 

    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(EmployeeNotFoundException ex){
        return ex.getMessage(); 
    }
}
