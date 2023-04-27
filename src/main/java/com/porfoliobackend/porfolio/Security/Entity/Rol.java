
package com.porfoliobackend.porfolio.Security.Entity;

import com.porfoliobackend.porfolio.Security.Enums.RolName;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;



//getter y setter con lombok
@Getter @Setter
@Entity
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    //NO PUEDE SER NULL y debe ser string
    //@NotNull
    @Enumerated(EnumType.STRING)
    private RolName rolName;

    public Rol() {
    }

    public Rol(RolName rolName) {
        this.rolName = rolName;
    }
    
    
    
    
}
