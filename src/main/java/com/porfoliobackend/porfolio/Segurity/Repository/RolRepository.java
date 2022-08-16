/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfoliobackend.porfolio.Segurity.Repository;

import com.porfoliobackend.porfolio.Security.Entity.Rol;
import com.porfoliobackend.porfolio.Security.Enums.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findRolNambre(RolName rolnombre);
}
