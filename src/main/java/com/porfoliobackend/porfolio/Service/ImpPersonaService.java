package com.porfoliobackend.porfolio.Service;

import com.porfoliobackend.porfolio.Entity.Persona;
import com.porfoliobackend.porfolio.Interface.IPersonaService;
import com.porfoliobackend.porfolio.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService {

    @Autowired IPersonaRepository iPersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> personas = iPersonaRepository.findAll();
        return personas;
    }

    @Override
    public void savePersona(Persona persona) {
        iPersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona=iPersonaRepository.findById(id).orElse(null);
       
        return persona;
    }
    
}
