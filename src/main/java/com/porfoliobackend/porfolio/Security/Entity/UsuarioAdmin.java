package com.porfoliobackend.porfolio.Security.Entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioAdmin implements UserDetails {

    private String nombre;
    private String nombreUsuario;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> autority;

    public UsuarioAdmin() {
    }

    public UsuarioAdmin(String nombre, String nombreUsuario, String email, String password, Collection<? extends GrantedAuthority> autority) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.autority = autority;
    }

    public static UsuarioAdmin build(Usuario usuario) {
        List<GrantedAuthority> autority = usuario
                .getRoles()
                .stream()
                .map(rol -> new SimpleGrantedAuthority(rol
                .getRolName()
                .name()))
                .collect(Collectors.toList());
        
        return new UsuarioAdmin(usuario.getNombre(),
                usuario.getNombreUsuario(),
                usuario.getEmail(),
                usuario.getPassword(), autority);

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return autority;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
