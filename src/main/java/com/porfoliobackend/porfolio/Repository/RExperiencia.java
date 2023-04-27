package com.porfoliobackend.porfolio.Repository;

import com.porfoliobackend.porfolio.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia,Integer> {
    
    public Optional<Experiencia> findByNombreEx(String nombreEx);
    
    public boolean existsByNombreEx(String nombreEx);
   
}
