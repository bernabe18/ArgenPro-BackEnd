package com.porfoliobackend.porfolio.Security.Service;

import com.porfoliobackend.porfolio.Security.Entity.Rol;
import com.porfoliobackend.porfolio.Security.Enums.RolName;
import com.porfoliobackend.porfolio.Security.Repository.RolRepository;
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
    
    return rolrepository.findByRolName(rolnombre); 
    }
    
    public void save(Rol rol){
        rolrepository.save(rol);
    }

    
}
