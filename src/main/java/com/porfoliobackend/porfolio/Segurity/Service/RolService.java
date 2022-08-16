package com.porfoliobackend.porfolio.Segurity.Service;

import com.porfoliobackend.porfolio.Security.Entity.Rol;
import com.porfoliobackend.porfolio.Security.Enums.RolName;
import com.porfoliobackend.porfolio.Segurity.Repository.RolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolrepository;
    
    public Optional<Rol> getByRolNombre(RolName rolnombre){
    
    return rolrepository.findRolNambre(rolnombre); 
    }
    
    public void save(Rol rol){
        rolrepository.save(rol);
    }
    
    
    
    
    
    
}
