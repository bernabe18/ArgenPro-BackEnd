
package com.porfoliobackend.porfolio.Security.Dto;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter @Setter
public class JwtDto {
    
    private String token;
    private String beare="beare";
    private String nombreUsuario;
    private Collection<? extends GrantedAuthority> authorities; 

    public JwtDto() {
    }

    public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.authorities = authorities;
    }
     
    
    
    
    
}