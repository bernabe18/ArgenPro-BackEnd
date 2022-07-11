package com.porfoliobackend.porfolio.Controller;

import com.porfoliobackend.porfolio.Entity.Persona;
import com.porfoliobackend.porfolio.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPersona{
    @Autowired IPersonaService iPersonaService;
    
   @GetMapping("/hola/{nombre}")
    public String hola(@PathVariable String nombre){
        return "hola "+nombre;
    }
    
    
    @GetMapping("/personas/traer")
    
    public List<Persona> getPersona(){
        return iPersonaService.getPersona();
    }
    
    @PostMapping("/personas/crear")
    public Persona createPersona(@RequestBody Persona persona){
        iPersonaService.savePersona(persona);
        return persona ;
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        iPersonaService.deletePersona(id);
    return "La persona fue eliminada ";
    }
    
    @PutMapping("/personas/edita/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String newName,
            @RequestParam("apellido") String newLastName ,
            @RequestParam("img") String newImg){
        
    //busacar a la persona por id
    Persona persona=iPersonaService.findPersona(id);
    //editar los atributos de la persona 
    persona.setNombre(newName);
    persona.setApellido(newLastName);
    persona.setImg(newImg);
    
    //guardar la persona editada
    iPersonaService.savePersona(persona);
    
    return persona;
    }
    
}
