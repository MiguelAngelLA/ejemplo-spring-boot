package com.demo_api.demo_api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// @Entity cause que este objeto 
// pueda ser utilizado en un data store de JPA

// JPA siendo: Java Persistence API
// Una especificacion que describe el 
// manejo de datos relacionales en aplicaciones 
// Java.
@Entity
public class Employee {
    //Representacion de las columnas en la tabla
    // AKA: Domain Object

    // @ID inidca que ese atributo es nuestro Primary Key
    // @GeneratedBalue indica que ese valor sera dado por 
    // el proveedor de datos (JPA)
    private @Id @GeneratedValue Long id; 
    private String name; 
    private String role;    
    ////////////////////////////////////////////

    protected Employee() {
    }

    //El constructor es creado sin ID, ya que este es autogenerado
    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    } 

    @Override
    public String toString(){
        return "[ " + this.id + ", " +
                this.name + ", " + 
                this.role +" ]"; 
    }

}
