package com.demo_api.demo_api;

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories

// Por el momento solo tenemos la opcion de acceder a los datos 
// Para tener a nuestra disposicion el resto de CRUD es requerido un repositorio
// Esta simple declaracion permite:
// - Crear nuevos empleados
// - Actualizar empleados existentes
// - Borrar empleados 
// - Buscar empleados 
//   * Todos 
//   * Por ID
//   * Por propiedades simples o complejas (primitivos u objetos declarados)

import org.springframework.data.jpa.repository.JpaRepository;
//JpaRepository <T,ID>
// Donde: 
// T: nuestra clase enidad.
// ID: el tipo de nuestro primary key definido en nuestra entidad.
interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // El repositorio contiene todas las definiciones para
    // ejecutar acciones mediante el motor de base de datos de 
    // nuestra prefrencia
    
    // A rasgos simples, el repositorio nos evita hacer boilerplate, 
    // abstrayendo los statements que se utilizan con frecuencia. 
    // ej. select, delete, update, insert, etc. 
    
    // Existen diferentes tipos de repositorios para diferentes tipos 
    // de motores de base de datos. Cada uno con sus funcionalidades 
    // propias del motor abstraidas por su propio repositorio.
    // ej. JpaRepository, MongoRepository, etc. 
    // Cabe destacar que estos repositorios extienden la abstraccion 
    // definida por CrudRepository
    
}
