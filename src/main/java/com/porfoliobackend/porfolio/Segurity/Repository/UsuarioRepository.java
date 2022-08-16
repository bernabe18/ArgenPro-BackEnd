package com.porfoliobackend.porfolio.Segurity.Repository;

import com.porfoliobackend.porfolio.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByNombreUsuarion(String nombreUsuario);
    boolean existsByEmail(String email);
}
