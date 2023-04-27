package com.porfoliobackend.porfolio.Entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Persona  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
  
    @Size(min = 1 ,max=50 ,message ="supera la cantidad de caracteres")
    private String nombre;
    
    @Size(min = 1 ,max=50 ,message ="supera la cantidad de caracteres")
    private String apellido;
 
    @Size(min = 1 ,max=50 ,message ="supera la cantidad de caracteres")
    private String img;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String img) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
    }
    
    
    
    
}
