package com.porfoliobackend.porfolio.Security.Repository;

import com.porfoliobackend.porfolio.Security.Entity.Rol;
import com.porfoliobackend.porfolio.Security.Enums.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolName(RolName rolNombre);
}
