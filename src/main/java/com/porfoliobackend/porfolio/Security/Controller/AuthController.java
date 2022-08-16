package com.porfoliobackend.porfolio.Security.Controller;

import com.porfoliobackend.porfolio.Security.Dto.JwtDto;
import com.porfoliobackend.porfolio.Security.Dto.LoginUsuario;
import com.porfoliobackend.porfolio.Security.Dto.NuevoUsuario;
import com.porfoliobackend.porfolio.Security.Entity.Rol;
import com.porfoliobackend.porfolio.Security.Entity.Usuario;
import com.porfoliobackend.porfolio.Security.Enums.RolName;
import com.porfoliobackend.porfolio.Security.Jwt.JwtProvider;
import com.porfoliobackend.porfolio.Segurity.Service.RolService;
import com.porfoliobackend.porfolio.Segurity.Service.UserDatailsImpl;
import com.porfoliobackend.porfolio.Segurity.Service.UsuarioServis;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    Authentication authentication;
    @Autowired
    UsuarioServis usuarioServis;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Campos invalidos "), HttpStatus.BAD_REQUEST);
        }

        if (usuarioServis.existsByNombre(nuevoUsuario.getNombreUsuario())) {
            return new ResponseEntity(new Mensaje("Este nombre de Usuario ya existe "), HttpStatus.BAD_REQUEST);
        }

        if (usuarioServis.existsByEmail(nuevoUsuario.getEmail())) {
            return new ResponseEntity(new Mensaje("Este email ya existe "), HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
                nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolName.ROLE_USER).get());

        if (nuevoUsuario.getRoles().contains("admin")) {
            roles.add(rolService.getByRolNombre(RolName.ROLE_ADMIN).get());
            usuario.setRoles(roles);
            usuarioServis.save(usuario);

            return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
        }
        return null;
    }
    

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Campos mal puesto "), HttpStatus.BAD_REQUEST);
        }

        Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),loginUsuario.getPassword()) );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    
    
    
    

//fin de class
}
