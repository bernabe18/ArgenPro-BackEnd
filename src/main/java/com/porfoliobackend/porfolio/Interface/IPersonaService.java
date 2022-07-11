package com.porfoliobackend.porfolio.Interface;

import com.porfoliobackend.porfolio.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    //lista de personas
    public List<Persona> getPersona();
    
    //guardar Persona
    public void savePersona(Persona persona);
    
    //borrar Persona
    public void deletePersona(Long id);
    
    //buscar Persona
    public Persona findPersona(Long id);
    
   
}
