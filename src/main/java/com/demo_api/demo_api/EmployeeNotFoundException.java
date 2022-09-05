package com.demo_api.demo_api;

//RuntimeException 
// https://docs.oracle.com/javase/7/docs/api/java/lang/RuntimeException.html

// RuntimeException es la superclase de las excepciones que pueden 
// ser lanzadas por La maquina virtual de java. 

// RuntimeException y sus subclases son "unchecked exceptions". Dichas excepciones
// no requieren ser declaradas por un metodo o por un constructor mediante 
// throws si estas pueden ser lanzadas por la execucion de un metodo o 
// constructor y se propagan fuera de los limites de la clase o metodo en la que se
// utilicen. 
public class EmployeeNotFoundException extends RuntimeException {
    EmployeeNotFoundException(Long id){
        super("Could not find employee " + id); 
    }
}
