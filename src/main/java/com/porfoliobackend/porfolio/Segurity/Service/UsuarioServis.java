package com.porfoliobackend.porfolio.Segurity.Service;

import com.porfoliobackend.porfolio.Security.Entity.Usuario;
import com.porfoliobackend.porfolio.Segurity.Repository.UsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioServis {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {

        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombre(String nombreUsuario) {

        return usuarioRepository.existsByNombreUsuarion(nombreUsuario);
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

}
