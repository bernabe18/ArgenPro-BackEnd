package com.porfoliobackend.porfolio.Controller;

import com.porfoliobackend.porfolio.Dto.DtoExperiencia;
import com.porfoliobackend.porfolio.Entity.Experiencia;
import com.porfoliobackend.porfolio.Security.Controller.Mensaje;
import com.porfoliobackend.porfolio.Service.ImpExperienciaService;
import java.util.List;
import org.codehaus.plexus.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerExperiencia {

    @Autowired
    ImpExperienciaService ImpExperienciaService;

    @GetMapping("/list")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> lista = ImpExperienciaService.list();

        return new ResponseEntity(lista, HttpStatus.OK);
    }
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(ImpExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = ImpExperienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?>  create(@RequestBody Experiencia rexperiencia) {
       
        /*con prueba que los datos ingresen*/
        if (StringUtils.isBlank(rexperiencia.getDescripcionEx() )) {
            return new ResponseEntity(new Mensaje("Campo experiencia obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (ImpExperienciaService.existsByNombreEx(rexperiencia.getNombreEx())) {
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = new Experiencia(rexperiencia.getNombreEx(),rexperiencia.getDescripcionEx());
        System.out.println(experiencia.getNombreEx()+" "+experiencia.getDescripcionEx());
        ImpExperienciaService.save(experiencia);
      
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExperiencia) {

        if (!ImpExperienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        //compara nombre experiencias 
        if (ImpExperienciaService.existsByNombreEx(dtoExperiencia.getNombreEX()) && ImpExperienciaService.getByNombreEx(dtoExperiencia.getNombreEX()).get().getId()!=id) {
               return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoExperiencia.getNombreEX())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia =ImpExperienciaService.getOne(id).get();
        experiencia.setNombreEx(dtoExperiencia.getNombreEX());
        experiencia.setDescripcionEx(dtoExperiencia.getDescripcionEx());
        ImpExperienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia guardad"),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
    
          if (!ImpExperienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
          ImpExperienciaService.delete(id);
           return new ResponseEntity(new Mensaje("La Experiencia fue eliminada"),HttpStatus.OK);
    }
    
}
