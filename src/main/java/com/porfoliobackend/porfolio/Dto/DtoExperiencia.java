package com.porfoliobackend.porfolio.Dto;

import javax.validation.constraints.NotBlank;


public class DtoExperiencia {
    
  @NotBlank
    private String nombreEX;
    
  @NotBlank
    private String descripcionEx;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreEX, String descripcionEx) {
        this.nombreEX = nombreEX;
        this.descripcionEx = descripcionEx;
    }

    public String getNombreEX() {
        return nombreEX;
    }

    public void setNombreEX(String nombreEX) {
        this.nombreEX = nombreEX;
    }

    public String getDescripcionEx() {
        return descripcionEx;
    }

    public void setDescripcionEx(String descripcionEx) {
        this.descripcionEx = descripcionEx;
    }
    
}
