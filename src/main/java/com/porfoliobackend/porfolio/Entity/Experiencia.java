
package com.porfoliobackend.porfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEx;
    private String descripcionEx;

    public Experiencia() {
    }

    public Experiencia(String nombreEx, String descripcionEx) {
        this.nombreEx = nombreEx;
        this.descripcionEx = descripcionEx;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEx() {
        return nombreEx;
    }

    public void setNombreEx(String nombreEx) {
        this.nombreEx = nombreEx;
    }

    public String getDescripcionEx() {
        return descripcionEx;
    }

    public void setDescripcionEx(String descripcionEx) {
        this.descripcionEx = descripcionEx;
    }
    
}
