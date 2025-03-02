package com.crudSpringBoolWEBc.Repository;

import com.crudSpringBoolWEBc.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

   /* @Query("SELECT p FROM Persona p WHERE p.nombre LIKE %?1%"
            + "OR p.apellido LIKE %?1%"
            + "OR p.correo Like %?1%"
            + "OR FUNCTION('DATE_FORMAT', p.fecha_nacimiento, '%d-%m-%Y') Like %?1%")*/
    @Query("SELECT p FROM Persona p WHERE" +
            " concat(p.id,p.nombre,p.apellido,p.correo)"+
            " LIKE %?1%")
    List<Persona> findAll(String palabraClave);
}
