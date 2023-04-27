package com.porfoliobackend.porfolio.Security.Service;

import com.porfoliobackend.porfolio.Security.Entity.Usuario;
import com.porfoliobackend.porfolio.Security.Entity.UsuarioAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service 
public class UserDetailsImpl implements UserDetailsService {
    
    @Autowired
    UsuarioServis usuarioServis;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario=usuarioServis.getByNombreUsuario(nombreUsuario).get();
   
      return  UsuarioAdmin.build(usuario);
    }
    
    
}
