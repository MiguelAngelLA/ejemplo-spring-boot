package com.demo_api.demo_api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @RestController indica que los datos devueltos por cada metodo seran enviados
// al cuerpo de la respuesta en lugar de renderizar a un template.

// Los template engines son utilizados para crear las vistas en una aplicacion 
// MVC tradicional. Debido a que esto es una API, solo la parte de 
// M - Modelo, y; 
// C - Controlador; seran los que se utilizan

@RestController
public class EmployeeController {
    // Nuestro repositorio es inyectado al controlador.
    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository employeeRepository){
        this.repository = employeeRepository; 
    }

    // Definimos los metodos y las rutas para manipular nuestro modelo. 
    // - GET
    // - POST
    // - PUT
    // - Delete

    @GetMapping("/employees")
    List<Employee> all(){
        return repository.findAll();
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee){
        return repository.save(newEmployee); 
    }

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id){
        // EmmployeeNotFoundException indica cuando un empleado es 
        // buscado, pero nunca encontrado. 

        // Todo bien, pero nos falta causar que la excepcion devuelva 
        // el codigo HTTP correspondiente (404)
        return repository.findById(id)
        .orElseThrow(()->new EmployeeNotFoundException(id)); 
    }

    @PutMapping("/employees/{id}")
    Employee replacEmployee (
        @RequestBody Employee newEmployee,
        @PathVariable Long id){
            return repository.findById(id)
            .map(employee -> {
                employee.setName(newEmployee.getName());
                employee.setRole(newEmployee.getRole());
                return repository.save(newEmployee); 
            }).orElseGet(() ->{
                newEmployee.setId(id);
                return repository.save(newEmployee);
            });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id){
        repository.deleteById(id);
    }
}
